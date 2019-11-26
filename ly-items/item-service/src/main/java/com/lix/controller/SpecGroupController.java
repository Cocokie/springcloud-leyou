package com.lix.controller;


import com.lix.item.domain.SpecGroup;
import com.lix.service.SpecGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecGroupController {
    @Autowired
    SpecGroupService specGroupService;
    @GetMapping("groups/{id}")
    public ResponseEntity<List<SpecGroup>> findByCid(@PathVariable("id") Long cid){
       return  ResponseEntity.ok(specGroupService.findByCid(cid));
    }
}
