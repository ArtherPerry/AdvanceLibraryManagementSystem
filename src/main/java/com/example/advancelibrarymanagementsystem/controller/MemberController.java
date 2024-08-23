package com.example.advancelibrarymanagementsystem.controller;

import com.example.advancelibrarymanagementsystem.entitites.Member;
import com.example.advancelibrarymanagementsystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member savedMember = memberService.saveMember(member);
        return ResponseEntity.ok(savedMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        Member updatedMember = memberService.updateMember(id, member);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Member>> getMemberById(@PathVariable Long id) {
        Optional<Member> member = memberService.findMemberById(id);
        return ResponseEntity.ok(member);
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.findAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Member>> getMemberByEmail(@PathVariable String email) {
        Optional<Member> member = memberService.findMemberByEmail(email);
        return ResponseEntity.ok(member);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<Optional<Member>> getMemberByPhoneNumber(@PathVariable String phone) {
        Optional<Member> member = memberService.findMemberByPhoneNumber(phone);
        return ResponseEntity.ok(member);
    }
}