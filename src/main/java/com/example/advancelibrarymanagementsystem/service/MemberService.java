package com.example.advancelibrarymanagementsystem.service;

import com.example.advancelibrarymanagementsystem.entitites.Member;
import com.example.advancelibrarymanagementsystem.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public Member updateMember(Long id,Member member){
        member.setId(id);
        return memberRepository.save(member);
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }

    public Optional<Member> findMemberById(Long id){
        return memberRepository.findById(id);
    }

    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findMemberByEmail(String email){
        return memberRepository.findByEmail(email);
    }

    public Optional<Member> findMemberByPhoneNumber(String phoneNumber){
        return memberRepository.findByPhoneNumber(phoneNumber);
    }



}
