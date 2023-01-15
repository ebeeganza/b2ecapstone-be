package net.yorksolutions.yemiakinwalepantrybe.controllers;

import net.yorksolutions.yemiakinwalepantrybe.services.ItemListService;
import net.yorksolutions.yemiakinwalepantrybe.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Entity;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemListController {

    private final ItemListService itemListService;

@Autowired
    public ItemListController(ItemListService itemListService) {
    this.itemListService = itemListService; }


//    @GetMapping
//    public Iterable<ItemList> getAllItem() {
//        try {
//            return itemListService.getAllItem();
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }




}
