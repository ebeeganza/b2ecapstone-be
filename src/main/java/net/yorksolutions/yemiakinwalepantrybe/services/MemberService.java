package net.yorksolutions.yemiakinwalepantrybe.services;


import net.yorksolutions.yemiakinwalepantrybe.models.Member;

import net.yorksolutions.yemiakinwalepantrybe.repositories.ItemRepository;
import net.yorksolutions.yemiakinwalepantrybe.repositories.MemberRepository;
import net.yorksolutions.yemiakinwalepantrybe.repositories.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final ItemRepository itemRepository;



    private final RecipeRepository recipeRepository;

    public MemberService(MemberRepository memberRepository, ItemRepository itemRepository,
                          RecipeRepository recipeRepository) {
        this.memberRepository = memberRepository;
        this.itemRepository = itemRepository;
        this.recipeRepository = recipeRepository;
    }

    public void register(Member member) throws Exception {
        if (member.name == null) {
            throw new Exception();
        }
        if (!member.password.equals(member.passwordRepeat)) {
            throw new Exception();
        }

        memberRepository.save(member);
    }

    public Member login(String name, String password) {
        return memberRepository
                .findMemberByNameAndPassword(name, password)
                .orElse(null);
    }

    public Iterable<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member modifyMember(Long id, Member member) throws Exception {
        if (memberRepository.findById(id).isEmpty())
            throw new Exception();
        final var modifiedMember = memberRepository.findById(id).orElseThrow();
        modifiedMember.name = member.name;
        modifiedMember.password = member.password;
        modifiedMember.passwordRepeat = member.passwordRepeat;

        return memberRepository.save(modifiedMember);
    }

    public void removeMember(Long id) throws Exception {
        Optional<Member> memberToRemove = this.memberRepository.findById(id);
        if (memberToRemove.isEmpty()) {
            throw new Exception();
        }
        memberRepository.deleteById(id);
    }

}
