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
package com.herocraftonline.items.api.storage.value.replacer;

import java.util.regex.Pattern;

/**
 * A replacer that searches for number ranges of the form {@code (min,max,fraction)},<br>
 * replacing them with a value between min and max linearly interpolated by fraction.
 *
 * @author Austin Payne
 */
public class InterpolateReplacer extends Replacer {

    private static final String VALUE = "-?\\d+(\\.\\d+)?";
    private static final Pattern TRIPLE = Pattern.compile("\\((" + VALUE + ",){2}" + VALUE + "\\)");

    public InterpolateReplacer(Replaceable value) {
        super(TRIPLE.matcher(value.getString()), value);
    }

    @Override
    public String getValue(String replace) {
        int firstComma = replace.indexOf(',');
        int lastComma = replace.lastIndexOf(',');

        double min = Double.parseDouble(replace.substring(1, firstComma));
        double max = Double.parseDouble(replace.substring(firstComma + 1, lastComma));
        double fraction = Double.parseDouble(replace.substring(lastComma + 1, replace.length() - 1));
        fraction = Math.max(0, Math.min(fraction, 1));

        double value = min + fraction * (max - min);
        return replace.substring(1, lastComma).contains(".") ? Double.toString(value) : Integer.toString((int) value);
    }

}
