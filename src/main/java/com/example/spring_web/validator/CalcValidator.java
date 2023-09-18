package com.example.spring_web.validator;

import com.example.spring_web.form.CalcForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class CalcValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // 인수로 전달받은 Form이 입력 체크의 대상인지를 논리값으로 돌려줍니다.
        return CalcForm.class.isAssignableFrom(clazz);
    }


    @Override
    public void validate(Object target,Errors errors) {
        // 대상 Form을 취득
        CalcForm calcForm = (CalcForm) target;

        // 값이 입력되어 있는 지 판단
        if(calcForm.getLeftNum() == null) {
            errors.rejectValue("leftNum", "not_Lempty", "왼쪽을 입력 하세요.");
        }
        if(calcForm.getRightNum() == null){
            errors.rejectValue("rightNum", "not_Rempty", "오른쪽을 입력 하세요.");
        }

        if(calcForm.getLeftNum() != null && calcForm.getRightNum() != null) {
            if(!(calcForm.getLeftNum() % 2 == 1) &&(calcForm.getRightNum() % 2 == 0)){
                errors.reject("com.example.spring_web.Validator.CalcValidator.message");
            }
        }

    }

}

