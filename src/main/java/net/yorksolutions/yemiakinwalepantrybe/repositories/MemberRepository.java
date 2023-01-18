package net.yorksolutions.yemiakinwalepantrybe.repositories;


import net.yorksolutions.yemiakinwalepantrybe.models.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

//   public Optional<Member> findMemberByNameAndPassword(String name, String password);

   public Optional<Member> findMemberByNameAndPassword(String name, String password);


}
