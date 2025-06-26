package com.kainmvc.registerform.controller;


import com.kainmvc.registerform.dto.UserRequestDto;
import com.kainmvc.registerform.entity.User;
import com.kainmvc.registerform.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping("/register")
    public String add(Model model){
        model.addAttribute("userRequestDto",new UserRequestDto());
        return "/user/register";
    }

    @PostMapping("/register")
    public String validateAdd(@Validated @ModelAttribute("userRequestDto") UserRequestDto userRequestDto, BindingResult bindingResult){
        User user = new User();
        new UserRequestDto().validate(userRequestDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "user/register";
        }
        BeanUtils.copyProperties(userRequestDto,user);
        iUserService.add(user);
        return "user/homepage";
    }
}
