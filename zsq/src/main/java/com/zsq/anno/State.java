package com.zsq.anno;

import com.zsq.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented//元注解
@Target({ElementType.FIELD})//元注解
@Retention(RetentionPolicy.RUNTIME)//元注解
@Constraint(
        validatedBy = {StateValidation.class}
)

public @interface State {
    //提供校验失败后的提示信息
    String message() default "state属性的值只能是“已发布”或“草稿”";
    //指定分组
    Class<?>[] groups() default {};
    //负载，获取State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
