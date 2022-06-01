package com.violetbeach.junitex;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StudyTest {

    @Test
    @DisplayName("스터디 만들기 😲")
    void create() {
        Study study = new Study(10);
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                        () -> "스터디를 처음 만들면 상태값이 DRAFT이어야 한다."),
                () -> assertTrue(study.getLimit() > 0,
                        () -> "스터 디 최대 참석 가능 인원은 0보다 커야 한다.")
        );

    }

    @Test
    @DisplayName("limit은 0보다 커야 한다.")
    void create_new_study() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        assertEquals("limit은 0보다 커야 한다.", exception.getMessage());
    }

    @Test
    void create_new_study_timeout() {
        assertTimeout(Duration.ofSeconds(10), () -> new Study(10));
    }

    @Test
    void create_new_study_timeoutPt() {
        // 해당 시간이 지나면 즉시 테스트 실패
        // 별도의 스레드에서 테스트하기 때문에 주의필요!
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> new Study(10));
    }

    @Test
    @Disabled
    @DisplayName("보수 중")
    void create1() {
        System.out.println("test");
    }

}
