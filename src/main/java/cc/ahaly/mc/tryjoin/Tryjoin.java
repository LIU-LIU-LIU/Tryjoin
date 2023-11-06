package cc.ahaly.mc.tryjoin;

import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Tryjoin extends Plugin implements Listener {
    public static String serverName = "login";

    @Override
    public void onEnable() {
        Configuration config = loadConfig();

        serverName = config.getString("serverName", "login");

        // Plugin startup logic
        getLogger().info("tryjoin插件已经启用");
        getProxy().getPluginManager().registerListener(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("tryjoin插件已经关闭");
    }
    @EventHandler()
    public void onServerKick(ServerKickEvent e) {
        e.setCancelled(true);
        e.setCancelServer(getProxy().getServerInfo(serverName));
    }


    private Configuration loadConfig(){
        Configuration config = null;
        // 获取插件的数据文件夹
        File dataFolder = getDataFolder();

        // 如果数据文件夹不存在，BungeeCord会自动创建它
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        // 定义配置文件的路径
        File configFile = new File(dataFolder, "config.yml");

        // 如果配置文件不存在，从JAR文件中复制默认配置文件
        if (!configFile.exists()) {
            try {
                try (InputStream inputStream = getResourceAsStream("config.yml");
                     FileOutputStream outputStream = new FileOutputStream(configFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 加载配置文件
        try {
            config = YamlConfiguration.getProvider(YamlConfiguration.class).load(configFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return config;
    }
}

