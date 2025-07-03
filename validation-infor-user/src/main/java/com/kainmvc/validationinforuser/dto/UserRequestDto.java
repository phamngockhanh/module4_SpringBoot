package com.kainmvc.validationinforuser.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto implements Validator {
    private String name;

    private int age;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRequestDto userRequestDto = (UserRequestDto) target;
        if(userRequestDto.getName().isEmpty()){
            errors.rejectValue("name","NullValue","Không được để trống");
        }else if(userRequestDto.getName().matches("^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$")){
            errors.rejectValue("name","FormatName","Vui lòng nhập đúng định dạng. VD: Nguyen Van A");
        }

        if(userRequestDto.getAge()<20){
            errors.rejectValue("age","AgeEqualZero","Tuổi không dược nhỏ hơn 20");
        }
    }
}
