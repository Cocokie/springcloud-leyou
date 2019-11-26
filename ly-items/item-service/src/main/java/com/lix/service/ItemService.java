package com.lix.service;

import com.lix.item.domain.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    public Item SaveItem(Item item) {
        return item;
    }
}
