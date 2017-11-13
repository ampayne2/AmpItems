package com.herocraftonline.items.api.equipment;

import com.herocraftonline.items.api.item.Item;
import com.herocraftonline.items.api.item.ItemType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public interface PlayerEquipment extends HumanEquipment<Player> {

    @Override
    Slot getSlot(String name);

    @Override
    default Slot getSlot(Player equipmentHolder, String name) {
        return getSlot(name);
    }

    @Override
    Slot getMainHandSlot();

    @Override
    default Slot getMainHandSlot(Player equipmentHolder) {
        return getMainHandSlot();
    }

    @Override
    Slot getOffHandSlot();

    @Override
    default Slot getOffHandSlot(Player equipmentHolder) {
        return getOffHandSlot();
    }

    @Override
    Slot getHeadSlot();

    @Override
    default Slot getHeadSlot(Player equipmentHolder) {
        return getHeadSlot();
    }

    @Override
    Slot getChestSlot();

    @Override
    default Slot getChestSlot(Player equipmentHolder) {
        return getChestSlot();
    }

    @Override
    Slot getLegsSlot();

    @Override
    default Slot getLegsSlot(Player equipmentHolder) {
        return getLegsSlot();
    }

    @Override
    Slot getFeetSlot();

    @Override
    default Slot getFeetSlot(Player equipmentHolder) {
        return getFeetSlot();
    }

    @Override
    default Slot getSlot(EquipmentSlot equipmentSlot) {
        switch (equipmentSlot) {
            case HAND:
                return getMainHandSlot();
            case OFF_HAND:
                return getOffHandSlot();
            case HEAD:
                return getHeadSlot();
            case CHEST:
                return getChestSlot();
            case LEGS:
                return getLegsSlot();
            case FEET:
                return getFeetSlot();
            default:
                return null;
        }
    }

    @Override
    default Slot getSlot(Player equipmentHolder, EquipmentSlot equipmentSlot) {
        switch (equipmentSlot) {
            case HAND:
                return getMainHandSlot(equipmentHolder);
            case OFF_HAND:
                return getOffHandSlot(equipmentHolder);
            case HEAD:
                return getHeadSlot(equipmentHolder);
            case CHEST:
                return getChestSlot(equipmentHolder);
            case LEGS:
                return getLegsSlot(equipmentHolder);
            case FEET:
                return getFeetSlot(equipmentHolder);
            default:
                return null;
        }
    }

    @Override
    Slot getSlot(int inventorySlot);

    @Override
    default Slot getSlot(Player equipmentHolder, int inventorySlot) {
        return getSlot(inventorySlot);
    }

    @Override
    Collection<? extends Slot> getSlots();

    @Override
    default Collection<? extends Slot> getSlots(Player equipmentHolder) {
        return getSlots();
    }

    @Override
    default Collection<? extends Slot> getSlotsForItem(ItemType itemType) {
        if (itemType == null) return Collections.emptyList();
        return getSlots().stream()
                .filter(slot -> slot.canHoldItem(itemType))
                .collect(Collectors.toList());
    }

    @Override
    default Collection<? extends Slot> getSlotsForItem(Player equipmentHolder, ItemType itemType) {
        if (itemType == null) return Collections.emptyList();
        return getSlots(equipmentHolder).stream()
                .filter(slot -> slot.canHoldItem(itemType))
                .collect(Collectors.toList());
    }

    @Override
    default Collection<? extends Slot> getSlotsForItem(Item item) {
        if (item == null) return Collections.emptyList();
        return getSlots().stream()
                .filter(slot -> slot.canHoldItem(item))
                .collect(Collectors.toList());
    }

    @Override
    default Collection<? extends Slot> getSlotsForItem(Player equipmentHolder, Item item) {
        if (item == null) return Collections.emptyList();
        return getSlots(equipmentHolder).stream()
                .filter(slot -> slot.canHoldItem(item))
                .collect(Collectors.toList());
    }

    @Override
    default Collection<? extends Slot> getEquipmentSlots() {
        return getSlots().stream()
                .filter(Slot::isEquipmentSlot)
                .collect(Collectors.toList());
    }

    @Override
    default Collection<? extends Slot> getEquipmentSlots(Player equipmentHolder) {
        return getSlots(equipmentHolder).stream()
                .filter(Slot::isEquipmentSlot)
                .collect(Collectors.toList());
    }

    @Override
    default Collection<? extends Slot> getInventorySlots() {
        return getSlots().stream()
                .filter(Slot::isInventorySlot)
                .collect(Collectors.toList());
    }

    @Override
    default Collection<? extends Slot> getInventorySlots(Player equipmentHolder) {
        return getSlots(equipmentHolder).stream()
                .filter(Slot::isInventorySlot)
                .collect(Collectors.toList());
    }

    interface Slot extends HumanEquipment.Slot<Player> { }
}