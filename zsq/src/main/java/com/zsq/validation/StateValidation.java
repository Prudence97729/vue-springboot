package com.zsq.validation;

import com.zsq.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State,String> {
    /*
    *   value:将来要校验的数据
    *   如果返回false，表示校验不通过
    * */

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //提供校验规则
        if(value == null){
            return false;
        }
        if(value.equals("已发布")||value.equals("草稿")){
            return true;
        }
        return false;
    }
}