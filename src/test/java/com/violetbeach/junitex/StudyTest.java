package com.violetbeach.junitex;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StudyTest {

    @Test
    @DisplayName("스터디 만들기 😲")
    void create() {
        Study study = new Study();
        assertNotNull(study);
    }

    @Test
    @Disabled
    @DisplayName("보수 중")
    void create1() {
        System.out.println("test");
    }

}
