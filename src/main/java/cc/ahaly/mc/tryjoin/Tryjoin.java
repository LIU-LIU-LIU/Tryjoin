package cc.ahaly.mc.tryjoin;

import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Tryjoin extends Plugin implements Listener {

    @Override
    public void onEnable() {
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
        e.setCancelServer(getProxy().getServerInfo("login"));
    }
}
