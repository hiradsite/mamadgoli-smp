package ir.mamadgoli.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public final class CoreListener implements Listener {
    private final MamadgoliCore plugin;
    public CoreListener(MamadgoliCore plugin){this.plugin=plugin;}
    @EventHandler public void join(PlayerJoinEvent e){ e.setJoinMessage("§6+ §f" + e.getPlayer().getName() + " §7joined §6MAMADGOLI SMP"); }
    @EventHandler public void respawn(PlayerRespawnEvent e){ if(plugin.getSpawn()!=null) e.setRespawnLocation(plugin.getSpawn()); }
}
