package com.lix.item.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: cuzz
 * @Date: 2018/11/5 13:47
 * @Description:
 */
@Table(name = "tb_spec_group")
@Data
public class SpecGroup {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long cid;

    private String name;

    /*@Transient
    private List<SpecParam> params; // 该组下的所有规格参数集合*/
}
