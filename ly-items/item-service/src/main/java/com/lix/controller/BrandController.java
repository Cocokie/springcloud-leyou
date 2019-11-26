package com.lix.controller;


import com.lix.common.vo.PagingResult;
import com.lix.item.domain.Brand;
import com.lix.item.domain.Paging;
import com.lix.service.BrandService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping("page")
    public ResponseEntity<PagingResult<Brand>> findBrandList(Paging paging) {
        System.out.println(System.currentTimeMillis());
        PagingResult<Brand> brandList = brandService.findBrandList(paging);

        return ResponseEntity.ok(brandList);
    }
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand,@RequestParam("cids") List<Long> cids){
        brandService.saveBrand(brand,cids);
        return ResponseEntity.ok().build();
    }
    @GetMapping("cid/{id}")
    public ResponseEntity<List<Brand>> queryByCid(@PathVariable("id") Long cid){
        return ResponseEntity.ok(brandService.queryByCid(cid));
    }
}
