package com.lix.controller;


import com.lix.item.domain.SpecParam;
import com.lix.service.SpecParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecParamController {
    @Autowired
    SpecParamService specParamService;

    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> findByGid(Long gid){
        return ResponseEntity.ok(specParamService.findByGid(gid));
    }
}
