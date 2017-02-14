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
package ninja.amp.items.api.item.attribute.attributes.stats;

import ninja.amp.items.api.item.attribute.AttributeType;
import ninja.amp.items.api.item.attribute.attributes.BasicAttribute;

/**
 * A basic stat attribute implementation to simplify the creation of stat attributes.<br>
 * Handles the attribute's stat type.
 *
 * @param <T> the type of stat the attribute tracks
 * @author Austin Payne
 */
public abstract class BasicStatAttribute<T extends StatType<T>> extends BasicAttribute implements StatAttribute<T> {

    private T statType;

    public BasicStatAttribute(String name, AttributeType attributeType, T statType) {
        super(name, attributeType);

        this.statType = statType;
    }

    @Override
    public T getStatType() {
        return statType;
    }

}