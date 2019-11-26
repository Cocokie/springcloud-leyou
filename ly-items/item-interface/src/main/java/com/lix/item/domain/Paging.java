package com.lix.item.domain;


import lombok.Data;

@Data
public class Paging {
    private String key;
    private Integer page = 1;
    private Integer rows = 5;
    private String sortBy;
    private Boolean desc = false;
}
