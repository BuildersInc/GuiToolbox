package de.builderinc.guitoolbox.main;


import de.builderinc.guitoolbox.events.GuiHandler;
import de.builderinc.guitoolbox.toolBox.GuiToolbox;
import de.builderinc.guitoolbox.toolBox.ItemToolbox;
import org.bukkit.plugin.Plugin;


public class GuiBuilder {

    private Plugin plugin;
    private final ItemToolbox itemToolbox;
    private final GuiToolbox guiToolbox;
    private final GuiHandler handler;

    public GuiBuilder(Plugin p) {
        this.plugin = p;
        this.handler = new GuiHandler(p);
        this.itemToolbox = new ItemToolbox(this);
        this.guiToolbox = new GuiToolbox(this);
    }

    private void startTask() {
        plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            System.out.println(handler.getResultKey());
        }, 1, 1);
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public ItemToolbox getItemToolbox() {
        return itemToolbox;
    }

    public GuiToolbox getGuiToolbox() {
        return guiToolbox;
    }
}
