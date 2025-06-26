package com.kainmvc.registerform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto implements Validator{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRequestDto userRequestDto = (UserRequestDto) target;
        if(userRequestDto.getFirstName().isEmpty()){
            errors.rejectValue("firstName","Empty","Không được để trống");
        }else if(!userRequestDto.getFirstName().matches("^.{5,45}$")){
            errors.rejectValue("firstName","KeywordNotEnough","Nhập đủ từ 5- 45 ký tự");
        }

        if(userRequestDto.getLastName().isEmpty()){
            errors.rejectValue("lastName","Empty","Không được để trống");
        }else if(!userRequestDto.getLastName().matches("^.{5,45}$")){
            errors.rejectValue("lastName","KeywordNotEnough","Nhập đủ từ 5- 45 ký tự");
        }

        if(userRequestDto.getPhoneNumber().isEmpty()){
            errors.rejectValue("phoneNumber","Empty","Không được để trống");
        }else if(!userRequestDto.getPhoneNumber().matches("^0[0-9]{9,10}$")){
            errors.rejectValue("phoneNumber","PhoneNumber","Nhập đúng định dạng. VD: 0878788788");
        }

        if(userRequestDto.getAge()<18){
            errors.rejectValue("age","AgeNotEnough","Vui lòng nhập số tuổi >=18");
        }

        if(userRequestDto.getEmail().isEmpty()){
            errors.rejectValue("email","Empty","Không được để trống");
        }else if(!userRequestDto.getEmail().matches("^[a-z0-9._%+-]+@+[a-z0-9.-]+\\.+[a-z]{2,}$")){
            errors.rejectValue("email","EmailWrongType","Không nhập đúng định dạng email. VD: ngockhanh@gmail.com");
        }
    }
}
