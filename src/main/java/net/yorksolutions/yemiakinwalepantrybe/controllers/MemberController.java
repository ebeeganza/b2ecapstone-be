package net.yorksolutions.yemiakinwalepantrybe.controllers;

import net.yorksolutions.yemiakinwalepantrybe.models.Member;
import net.yorksolutions.yemiakinwalepantrybe.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/member")
@CrossOrigin
public class MemberController {

    private final MemberService memberService;

@Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public void register(@RequestBody Member member) {
        try {
            memberService.register(member);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping
    public Member login(
            @RequestParam String name,
            @RequestParam String password) {
        try {
            return memberService.login(name, password);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public Iterable<Member> getAllMembers() {
        try {
            return memberService.getAllMembers();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
