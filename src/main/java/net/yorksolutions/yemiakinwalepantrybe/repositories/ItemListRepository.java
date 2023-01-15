package net.yorksolutions.yemiakinwalepantrybe.repositories;

import net.yorksolutions.yemiakinwalepantrybe.models.ItemList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemListRepository extends CrudRepository<ItemList, Long> {


}
