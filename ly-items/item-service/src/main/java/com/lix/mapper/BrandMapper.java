package com.lix.mapper;

import com.lix.item.domain.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {
    @Insert("insert into tb_category_brand values(#{cid},#{bid})")
    int saveCids(@Param("cid") Long cid, @Param("bid") Long bid);
    @Select("SELECT b.* FROM tb_brand b,tb_category_brand cb WHERE b.`id`=cb.`brand_id` AND cb.`category_id`=#{cid}")
    List<Brand> queryBrandByCid(@Param("cid") Long cid);
}
