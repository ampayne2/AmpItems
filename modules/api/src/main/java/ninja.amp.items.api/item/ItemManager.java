/*
 * This file is part of AmpItems API.
 *
 * Copyright (c) 2017 <http://github.com/ampayne2/AmpItems//>
 *
 * AmpItems API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AmpItems API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with AmpItems API.  If not, see <http://www.gnu.org/licenses/>.
 */
package ninja.amp.items.api.item;

import ninja.amp.items.api.config.ItemConfig;
import ninja.amp.items.api.item.attribute.AttributeType;
import ninja.amp.items.api.item.attribute.ItemAttribute;
import ninja.amp.items.nms.nbt.NBTTagCompound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.Map;

public interface ItemManager {

    boolean isItem(ItemStack itemStack);

    Item getItem(ItemStack itemStack);

    Item getItem(NBTTagCompound compound);

    Item getItem(ConfigurationSection config);

    Item getItem(ItemConfig config);

    Item getItem(String item);

    boolean hasItemConfig(String item);

    ItemConfig getItemConfig(String item);

    Map<String, ItemConfig> getItemConfigs();

    void registerItemConfigs(Collection<? extends ItemConfig> items, JavaPlugin plugin);

    void registerItemConfig(ItemConfig item, JavaPlugin plugin);

    boolean hasItemType(String type);

    ItemType getItemType(String type);

    Map<String, ItemType> getItemTypes();

    void registerItemTypes(Collection<? extends ItemType> types, JavaPlugin plugin);

    void registerItemType(ItemType type, JavaPlugin plugin);

    boolean hasAttributeType(String type);

    AttributeType getAttributeType(String type);

    Map<String, AttributeType> getAttributeTypes();

    void registerAttributeTypes(Collection<? extends AttributeType> types, JavaPlugin plugin);

    void registerAttributeType(AttributeType type, JavaPlugin plugin);

    ItemAttribute loadAttribute(ConfigurationSection config);

    ItemAttribute loadAttribute(NBTTagCompound compound);

    ItemFactory getFactory();

}
