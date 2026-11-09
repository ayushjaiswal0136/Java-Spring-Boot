package com.ayush.journey;

import org.apache.commons.lang3.StringUtils;

public final class TaskTitleFormatter {

    private TaskTitleFormatter() {
    }

    public static String format(String raw) {
        if (StringUtils.isBlank(raw)) {
            throw new IllegalArgumentException("Title cannot be blank");
        }
        return StringUtils.capitalize(StringUtils.normalizeSpace(raw));
    }
}