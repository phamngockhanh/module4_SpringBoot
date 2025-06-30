package com.kainmvc.cart_ban_hoa.controller;


import com.kainmvc.cart_ban_hoa.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController {
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/candy-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("views/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
}
