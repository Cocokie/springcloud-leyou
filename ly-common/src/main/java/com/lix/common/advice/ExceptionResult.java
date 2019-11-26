package com.lix.common.advice;

import lombok.Data;

@Data
public class ExceptionResult {
    private Long time;
    private String message;
    private Integer code;
}
