package com.ayush.journey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TaskTitleFormatterTest {

    @Test
    void trimsCollapsesSpacesAndCapitalizes() {
        assertEquals("Design the login API",
                TaskTitleFormatter.format("   design   the   login API   "));
    }

    @Test
    void keepsAlreadyCleanTitleUnchanged() {
        assertEquals("Write tests", TaskTitleFormatter.format("Write tests"));
    }

    @Test
    void rejectsBlankTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> TaskTitleFormatter.format("   "));
    }
}