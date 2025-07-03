package com.kainmvc.validationinforuser.controller;

import com.kainmvc.validationinforuser.dto.UserRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("user", new UserRequestDto());
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidation (@Validated @ModelAttribute("user") UserRequestDto userRequestDto, BindingResult bindingResult){
        new UserRequestDto().validate(userRequestDto,bindingResult);
        if(bindingResult.hasErrors()){
            return new ModelAndView("/index");
        }
        return new ModelAndView("/result");
    }
}
