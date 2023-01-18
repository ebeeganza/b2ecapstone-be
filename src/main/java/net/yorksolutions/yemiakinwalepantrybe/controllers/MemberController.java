package net.yorksolutions.yemiakinwalepantrybe.controllers;

import net.yorksolutions.yemiakinwalepantrybe.models.Member;
import net.yorksolutions.yemiakinwalepantrybe.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLOutput;

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
    public Member getByNameAndPassword(
            @RequestParam String name,
            @RequestParam String password) {

        final var user= memberService.getByNameAndPassword(name, password);

        if (user == null)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

//        return new ResponseEntity<>(AppUser user, HttpStatus.OK);
        return user;
    }

//    @GetMapping(params = {"name","password"})
//    public Member login(
//            @RequestParam String name,
//            @RequestParam String password) {
//        try {
//            return memberService.login(name, password);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/member")
    public Iterable<Member> getAllMembers() {
        try {
            return memberService.getAllMembers();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public Member modifyMember(@PathVariable Long id, @RequestBody Member member) {
        try {
            return memberService.modifyMember(id, member);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public  void removeMember(@PathVariable Long id) {
        try {
            memberService.removeMember(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}
