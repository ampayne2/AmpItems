/*
 * This file is part of Relics API.
 *
 * Copyright (c) 2017, Austin Payne <payneaustin5@gmail.com - http://github.com/ampayne2>
 *
 * All Rights Reserved.
 *
 * Unauthorized copying and/or distribution of Relics API,
 * via any medium is strictly prohibited.
 */
package com.herocraftonline.items.api.item.attribute.attributes.triggers;

/**
 * A trigger attribute that can only trigger once every period of time.
 *
 * @author Austin Payne
 */
public interface Cooldown extends Trigger<Cooldown> {

    /**
     * Gets the duration of the cooldown between triggering target triggerables.
     *
     * @return the cooldown's duration
     */
    long getDuration();

    /**
     * Sets the duration of the cooldown between triggering target triggerables.
     *
     * @param duration the cooldown's duration
     */
    void setDuration(long duration);

    /**
     * Gets the last time the cooldown was used.
     *
     * @return the cooldown's last used time
     */
    long getLastUsed();

    /**
     * Sets the last time the cooldown was used.
     *
     * @param lastUsed the cooldown's last used time
     */
    void setLastUsed(long lastUsed);

    /**
     * Checks if the trigger is on cooldown.
     *
     * @return if the trigger is on cooldown
     */
    boolean isOnCooldown();

    /**
     * Sets if the trigger is on cooldown.
     *
     * @param onCooldown if the trigger is on cooldown
     */
    void setOnCooldown(boolean onCooldown);

}
