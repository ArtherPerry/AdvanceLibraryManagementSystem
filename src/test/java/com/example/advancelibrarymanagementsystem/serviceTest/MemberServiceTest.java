package com.example.advancelibrarymanagementsystem.serviceTest;

import com.example.advancelibrarymanagementsystem.entitites.Member;
import com.example.advancelibrarymanagementsystem.repo.MemberRepository;
import com.example.advancelibrarymanagementsystem.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    private Member member;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        member = new Member();
        member.setId(1L);
        member.setEmail("testmember@example.com");
        member.setPhoneNumber("1234567890");
    }

    @Test
    void saveMember() {
        when(memberRepository.save(member)).thenReturn(member);

        Member savedMember = memberService.saveMember(member);

        assertNotNull(savedMember);
        assertEquals(member.getId(), savedMember.getId());
        verify(memberRepository, times(1)).save(member);
    }

    @Test
    void updateMember() {
        when(memberRepository.save(member)).thenReturn(member);

        Member updatedMember = memberService.updateMember(1L, member);

        assertNotNull(updatedMember);
        assertEquals(1L, updatedMember.getId());
        verify(memberRepository, times(1)).save(member);
    }

    @Test
    void deleteMember() {
        doNothing().when(memberRepository).deleteById(1L);

        memberService.deleteMember(1L);

        verify(memberRepository, times(1)).deleteById(1L);
    }

    @Test
    void findMemberById() {
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));

        Optional<Member> foundMember = memberService.findMemberById(1L);

        assertTrue(foundMember.isPresent());
        assertEquals(member.getId(), foundMember.get().getId());
        verify(memberRepository, times(1)).findById(1L);
    }

    @Test
    void findAllMembers() {
        List<Member> memberList = Arrays.asList(member);
        when(memberRepository.findAll()).thenReturn(memberList);

        List<Member> allMembers = memberService.findAllMembers();

        assertEquals(1, allMembers.size());
        verify(memberRepository, times(1)).findAll();
    }

    @Test
    void findMemberByEmail() {
        when(memberRepository.findByEmail("testmember@example.com")).thenReturn(Optional.of(member));

        Optional<Member> foundMember = memberService.findMemberByEmail("testmember@example.com");

        assertTrue(foundMember.isPresent());
        assertEquals(member.getEmail(), foundMember.get().getEmail());
        verify(memberRepository, times(1)).findByEmail("testmember@example.com");
    }

    @Test
    void findMemberByPhoneNumber() {
        when(memberRepository.findByPhoneNumber("1234567890")).thenReturn(Optional.of(member));

        Optional<Member> foundMember = memberService.findMemberByPhoneNumber("1234567890");

        assertTrue(foundMember.isPresent());
        assertEquals(member.getPhoneNumber(), foundMember.get().getPhoneNumber());
        verify(memberRepository, times(1)).findByPhoneNumber("1234567890");
    }
}