/*
 * This file is part of AmpItems API.
 *
 * Copyright (c) 2017, Austin Payne <payneaustin5@gmail.com - http://github.com/ampayne2>
 *
 * All Rights Reserved.
 *
 * Unauthorized copying and/or distribution of AmpItems API,
 * via any medium is strictly prohibited.
 */
package ninja.amp.items.api.menu;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * Allows you to set the item menu that created the inventory as the inventory's holder.
 *
 * @author Austin Payne
 */
public class MenuHolder implements InventoryHolder {

    private ItemMenu menu;
    private Inventory inventory;

    private MenuHolder(ItemMenu menu) {
        this.menu = menu;
    }

    /**
     * Gets the item menu holding the inventory.
     *
     * @return The item menu holding the inventory
     */
    public ItemMenu getMenu() {
        return menu;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Creates an inventory owned by a menu holder.
     *
     * @param owner The item menu to own the inventory
     * @param size  The size of the inventory
     * @param name  The name of the inventory
     * @return The inventory created
     */
    public static MenuHolder createInventory(ItemMenu owner, int size, String name) {
        MenuHolder holder = new MenuHolder(owner);
        holder.inventory = Bukkit.createInventory(holder, size, name);
        return holder;
    }

}