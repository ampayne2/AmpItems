/*
 * This file is part of Relics.
 *
 * Copyright (c) 2017, Austin Payne <amperialdev@gmail.com - http://github.com/Amperial>
 *
 * All Rights Reserved.
 *
 * Unauthorized copying and/or distribution of Relics,
 * via any medium is strictly prohibited.
 */
package com.herocraftonline.items.item.attributes.triggers.sources.entity;

import com.herocraftonline.items.api.item.Item;
import org.bukkit.entity.HumanEntity;

public class HumanEntitySource extends LivingEntitySource implements com.herocraftonline.items.api.item.attribute.attributes.trigger.source.entity.HumanEntitySource {

    public HumanEntitySource(Item item, HumanEntity entity) {
        super(item, entity);
    }

    @Override
    public HumanEntity getEntity() {
        return (HumanEntity) super.getEntity();
    }

}
