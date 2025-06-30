package com.kainmvc.cart_ban_hoa.controller;


import com.kainmvc.cart_ban_hoa.entity.Candy;
import com.kainmvc.cart_ban_hoa.entity.Cart;
import com.kainmvc.cart_ban_hoa.service.ICandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class CandyController {
    @Autowired
    private ICandyService iCandyService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return  new Cart();
    }

    @GetMapping("/index")
    public ModelAndView showShop(){
        ModelAndView modelAndView= new ModelAndView("/views/index");
        modelAndView.addObject("candies",iCandyService.findAll());
        return modelAndView;
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam(name="action") String action){
        Optional<Candy> candyOptional = iCandyService.findById(id);
        if(candyOptional.isEmpty()){
            return "/views/error";
        }
        switch (action) {
            case "show" -> {
                cart.addCandy(candyOptional.get());
                return "redirect:/candy-cart";
            }
            case "minus" -> {
                cart.minusCandy(candyOptional.get());
                return "redirect:/candy-cart";
            }
            case "delete" -> {
                cart.deleteCandy(candyOptional.get());
                return "redirect:/candy-cart";
            }
        }

        cart.addCandy(candyOptional.get());
        return "redirect:/index";
    }



}
