package net.yorksolutions.yemiakinwalepantrybe.repositories;

import net.yorksolutions.yemiakinwalepantrybe.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

  Optional<Item> findItemByItemName(String itemName);

}
