package net.yorksolutions.yemiakinwalepantrybe.controllers;

import net.yorksolutions.yemiakinwalepantrybe.models.Item;
import net.yorksolutions.yemiakinwalepantrybe.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Iterable<Item> getAllItems (Item item) {
        try {
            return itemService.getAllItems(item);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Item stockItem(@RequestBody Item item) {
        try {
            return itemService.stockItem(item);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        try {
           return itemService.updateItem(id, item);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            itemService.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
