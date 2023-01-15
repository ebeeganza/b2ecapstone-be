package net.yorksolutions.yemiakinwalepantrybe.services;

import net.yorksolutions.yemiakinwalepantrybe.models.Item;

import net.yorksolutions.yemiakinwalepantrybe.repositories.ItemRepository;
import net.yorksolutions.yemiakinwalepantrybe.repositories.MemberRepository;
import net.yorksolutions.yemiakinwalepantrybe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    private final MemberRepository memberRepository;

    private final ItemRepository itemRepository;



    private final RecipeRepository recipeRepository;

    public ItemService(MemberRepository memberRepository, ItemRepository itemRepository,
                          RecipeRepository recipeRepository) {
        this.memberRepository = memberRepository;
        this.itemRepository = itemRepository;
        this.recipeRepository = recipeRepository;
    }

    public Iterable<Item> getAllItems(Item item) {
        return itemRepository.findAll();
    }

    public Item stockItem(Item item) throws Exception {
        if (itemRepository.findItemByItemName(item.itemName).isPresent())
            throw new Exception();

        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item item) throws Exception {
        if (itemRepository.findItemByItemName(item.itemName).isEmpty())
            throw new Exception();

        final var updatedItem = itemRepository.findItemByItemName(item.itemName).orElseThrow();
        updatedItem.itemName = item.itemName;
        updatedItem.itemUnit = item.itemUnit;
        updatedItem.itemImg = item.itemImg;

        return itemRepository.save(updatedItem);
    }

    public void deleteById(Long id) throws Exception {
        Optional <Item> itemToDelete = this.itemRepository.findById(id);
        if (itemToDelete.isEmpty()) {
            throw new Exception();
        }

        itemRepository.deleteById(id);
    }








}



