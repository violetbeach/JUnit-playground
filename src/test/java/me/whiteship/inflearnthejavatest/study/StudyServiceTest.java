package me.whiteship.inflearnthejavatest.study;

import me.whiteship.inflearnthejavatest.member.MemberService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class StudyServiceTest {


    @Test
    void createStudyService() {
        MemberService memberService = mock(MemberService.class);
        StudyRepository studyRepository = mock(StudyRepository.class)

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }
}
