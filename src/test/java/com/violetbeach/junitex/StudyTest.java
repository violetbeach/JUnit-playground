package com.violetbeach.junitex;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudyTest {

    @Test
    void create() {
        Study study = new Study();
        assertNotNull(study);
    }

    @Test
    @Disabled
    void create1() {
        System.out.println("test");
    }

}
