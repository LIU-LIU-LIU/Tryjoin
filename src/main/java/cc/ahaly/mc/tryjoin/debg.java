package cc.ahaly.mc.tryjoin;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

//tc - dl - dk+
public class debg implements Listener{
    @EventHandler()
    public void tc(ServerKickEvent e) {
        new Plugin().getLogger().warning("踢出事件" + "\n玩家:" + e.getPlayer() + "\n服务器:" + e.getPlayer().getServer());
        System.out.println("踢出事件" + "\n玩家:" + e.getPlayer() + "\n服务器:" + e.getPlayer().getServer());
        for (BaseComponent x : e.getKickReasonComponent()) {
            System.out.println("Reason:" + x);
        }
    }
    @EventHandler()
    public void dk(ServerDisconnectEvent e) {
        System.out.println("断开事件" + "\n玩家:" + e.getPlayer() + "\n服务器:" + e.getTarget());
        new Plugin().getLogger().warning("断开事件" + "\n玩家:" + e.getPlayer() + "\n服务器:" + e.getTarget());
    }
    @EventHandler()
    public void dl(PlayerDisconnectEvent e){
        new Plugin().getLogger().warning("断链事件" + "\n玩家:" + e.getPlayer());
    }
}
