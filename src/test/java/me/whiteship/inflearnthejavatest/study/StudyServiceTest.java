package me.whiteship.inflearnthejavatest.study;

import me.whiteship.inflearnthejavatest.domain.Member;
import me.whiteship.inflearnthejavatest.domain.Study;
import me.whiteship.inflearnthejavatest.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudyServiceTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createStudyService() {
        StudyService studyService = new StudyService(memberService, studyRepository);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("keesun@gmail.com");

        when(memberService.findById(any())).thenReturn(Optional.of(member));
        Study study = new Study(10, "java");

        Optional<Member> findById = memberService.findById(1L);

        Study newStudy = studyService.createNewStudy(1L, study);

        when(memberService.findById(any())).thenThrow(new IllegalArgumentException());
        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);

        when(memberService.findById(any()))
                .thenReturn(Optional.of(member))
                        .thenThrow(new RuntimeException())
                                .thenReturn(Optional.empty());

        assertNotNull(studyService);

        verify(memberService, times(1)).findById(1L);
        verify(memberService, never()).findById(1L).
    }
}
