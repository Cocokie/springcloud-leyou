package com.lix.common.vo;

import lombok.Data;

import java.util.List;


@Data
public class PagingResult<T> {
    List<T> items;
    Integer totalPage;
    Long total;

    public PagingResult(List<T> items, Long total) {
        this.items = items;
        this.total = total;
    }

    public PagingResult(List<T> items, Integer totalPage, Long total) {
        this.items = items;
        this.totalPage = totalPage;
        this.total = total;
    }
}
