package com.lix.controller;


import com.lix.common.vo.PagingResult;
import com.lix.item.domain.Spu;
import com.lix.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("spu")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @GetMapping("page")
    public ResponseEntity<PagingResult<Spu>> querySpuByPageAndSort(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "saleable", required = false) Boolean saleable,
            @RequestParam(value = "key", required = false) String key) {
        return ResponseEntity.ok(goodsService.querySpuByPageAndSort(page, rows, saleable, key));

    }
}
