/*
 * This file is part of Relics API.
 *
 * Copyright (c) 2017, Austin Payne <amperialdev@gmail.com - http://github.com/Amperial>
 *
 * All Rights Reserved.
 *
 * Unauthorized copying and/or distribution of Relics API,
 * via any medium is strictly prohibited.
 */
package com.herocraftonline.items.api.item.attribute.attributes.trigger.source.event;

import com.herocraftonline.items.api.item.attribute.attributes.trigger.source.entity.EntitySource;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;

public interface EntityDamageSource extends EntitySource {

    EntityDamageEvent getEvent();

    default Entity getEntity() {
        return getEvent().getEntity();
    }

}
