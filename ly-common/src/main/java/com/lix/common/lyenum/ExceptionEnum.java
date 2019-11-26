package com.lix.common.lyenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ExceptionEnum {
    NOT_FOUND(400,"查询不存在"),
    CATEGORY_NOT_FOUND(400,"查询不存在"),
    BRAND_NOT_FOUND(400,"查询不存在"),
    SAVE_BRAND_FAILED(400,"保存品牌失败"),
    UPLOAD_IMAGE_FAILED(400,"上传失败")
    ;
    //public static final ExceptionEnum BRAND_NOT_FOUND = ;
    private Integer httpCode;
    private String message;
}
