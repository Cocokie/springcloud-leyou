package com.lix.item.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: cuzz
 * @Date: 2018/11/5 16:20
 * @Description:
 */
@Data
@Table(name = "tb_spec_param")
public class SpecParam {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long cid;
    private Long groupId;
    private String name;
    @Column(name = "`numeric`")  // numeric是关键字，反引号是转义为字符串
    private Boolean numeric;
    private String unit;
    private Boolean generic;
    private Boolean searching;
    private String segments;

}
