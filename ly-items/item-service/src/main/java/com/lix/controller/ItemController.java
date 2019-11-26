package com.lix.controller;

import com.lix.common.advice.LyException;
import com.lix.common.lyenum.ExceptionEnum;
import com.lix.item.domain.Item;
import com.lix.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @PostMapping("")
    public ResponseEntity<Item> SaveItem(Item item){
        Item it = itemService.SaveItem(item);
        if(it.getId()==0)
            throw new LyException(ExceptionEnum.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.OK).body(it);
    }
}
