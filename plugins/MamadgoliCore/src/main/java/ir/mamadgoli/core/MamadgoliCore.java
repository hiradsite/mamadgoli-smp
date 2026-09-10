package ir.mamadgoli.core;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class MamadgoliCore extends JavaPlugin {
    private Location spawn;

    @Override public void onEnable() {
        saveDefaultConfig();
        loadSpawn();
        getLogger().info("MamadgoliCore enabled — MAMADGOLI SMP");
        getServer().getPluginManager().registerEvents(new CoreListener(this), this);
    }

    private void loadSpawn() {
        String worldName = getConfig().getString("spawn.world", "world");
        World w = Bukkit.getWorld(worldName);
        if (w == null) return;
        spawn = new Location(w,
                getConfig().getDouble("spawn.x", 0.5),
                getConfig().getDouble("spawn.y", 100),
                getConfig().getDouble("spawn.z", 0.5),
                (float)getConfig().getDouble("spawn.yaw", 0),
                (float)getConfig().getDouble("spawn.pitch", 0));
    }

    public Location getSpawn() { return spawn == null ? null : spawn.clone(); }

    @Override public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("mamadgoli.admin")) { sender.sendMessage("§cNo permission."); return true; }
        if (args.length == 0 || args[0].equalsIgnoreCase("info")) {
            sender.sendMessage("§6MAMADGOLI SMP §f| MamadgoliCore 1.0.0");
            sender.sendMessage("§7Spawn radius: §f" + getConfig().getInt("regions.spawn-radius"));
            sender.sendMessage("§7Survival border: §f" + getConfig().getInt("regions.survival-border"));
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) { reloadConfig(); loadSpawn(); sender.sendMessage("§aMamadgoliCore reloaded."); return true; }
        if (args[0].equalsIgnoreCase("setspawn") && sender instanceof Player) {
            Player p=(Player)sender; Location l=p.getLocation();
            getConfig().set("spawn.world", l.getWorld().getName()); getConfig().set("spawn.x", l.getX());
            getConfig().set("spawn.y", l.getY()); getConfig().set("spawn.z", l.getZ());
            getConfig().set("spawn.yaw", l.getYaw()); getConfig().set("spawn.pitch", l.getPitch()); saveConfig(); loadSpawn();
            p.sendMessage("§aSpawn updated."); return true;
        }
        sender.sendMessage("§e/mg info §7| §e/mg reload §7| §e/mg setspawn"); return true;
    }
}
