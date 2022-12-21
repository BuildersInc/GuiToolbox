package de.buildersinc.guitoolbox.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;

public class GuiHandler implements Listener {

    private String resultKey;

    public GuiHandler(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        resultKey = event.getWhoClicked().getName();
        System.out.println(resultKey);
    }

    public String getResultKey() {
        return resultKey;
    }
}
