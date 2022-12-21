package de.buildersinc.guitoolbox.toolBox;

import de.buildersinc.guitoolbox.main.GuiBuilder;
import de.buildersinc.guitoolbox.utils.DummyHolder;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiToolbox {

    private final GuiBuilder guiBuilder;
    public GuiToolbox(GuiBuilder builder) {
        this.guiBuilder = builder;

    }

    /**
     * Creates an inventory with a filler material
     * @param height the height of the Inventory
     * @param nameSpace The namespace for the filler item
     * @param nameOfInventory title of the Interface
     * @param material material of the filler item
     * @param glint the filler item glows
     * @param check implements a way of detecting a custom Gui (See DummyHolder) for more details
     *
     * @return chestGui
     */
    public Inventory createChestGui(int height, String nameSpace, String nameOfInventory, Material material, boolean glint, boolean check) {
        Inventory inv;
        if (check) {
            inv = Bukkit.createInventory(new DummyHolder(), 9 * height, Component.text(nameOfInventory));
        } else {
            inv = Bukkit.createInventory(null, 9 * height, Component.text(nameOfInventory));
        }
        ItemStack placeholder = guiBuilder.getItemToolbox().nonAirPlaceholder(material, nameSpace, glint);
        for (int i = 0; i < height * 9; i++) {
            inv.setItem(i, placeholder);
        }
        return inv;
    }

    public static void setItem(int row, int col, ItemStack item, Inventory inventory) {
        int slot = (9 * row) + (1 * col);
        inventory.setItem(slot, item);
    }
}
