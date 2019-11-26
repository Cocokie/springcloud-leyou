package com.lix.common.advice;

import com.lix.common.lyenum.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LyException extends RuntimeException {
    private ExceptionEnum exceptionEnum;
    private ExceptionResult exceptionResult;

    public LyException(String message) {
        super(message);
    }

    public LyException(ExceptionEnum exceptionEnum) {
        exceptionResult = new ExceptionResult();
        exceptionResult.setCode(exceptionEnum.getHttpCode());
        exceptionResult.setMessage(exceptionEnum.getMessage());
        exceptionResult.setTime(System.currentTimeMillis());
    }


}
