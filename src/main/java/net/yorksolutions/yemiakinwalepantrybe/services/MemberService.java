package net.yorksolutions.yemiakinwalepantrybe.services;


import net.yorksolutions.yemiakinwalepantrybe.models.Member;
import net.yorksolutions.yemiakinwalepantrybe.repositories.ItemListRepository;
import net.yorksolutions.yemiakinwalepantrybe.repositories.ItemRepository;
import net.yorksolutions.yemiakinwalepantrybe.repositories.MemberRepository;
import net.yorksolutions.yemiakinwalepantrybe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final ItemRepository itemRepository;

    private final ItemListRepository itemListRepository;

    private final RecipeRepository recipeRepository;

    public MemberService(MemberRepository memberRepository, ItemRepository itemRepository,
                         ItemListRepository itemListRepository, RecipeRepository recipeRepository) {
        this.memberRepository = memberRepository;
        this.itemRepository = itemRepository;
        this.itemListRepository = itemListRepository;
        this.recipeRepository = recipeRepository;
    }

    public void register(Member member) throws Exception {
        if (member.password != member.passwordRepeat) {
            throw new Exception();
        }

        memberRepository.save(member);
    }

    public Member login(String name, String password) {
        return memberRepository.findMemberByNameAndPassword(name, password).orElseThrow();
    }

    public Iterable<Member> getAllMembers() {
        return memberRepository.findAll();
    }

}
