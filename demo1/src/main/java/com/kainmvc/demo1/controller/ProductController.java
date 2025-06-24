package com.kainmvc.demo1.controller;


import com.kainmvc.demo1.entity.Product;
import com.kainmvc.demo1.service.IProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/index";
    }

    @GetMapping("/{id}/view")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/view";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","Create Successful!!");
        productService.add(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String update (@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/update";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","Update successfully!!");
        productService.add(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","Delete success");
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword , Model model){
        List<Product> products =productService.findProductByName(keyword);
        model.addAttribute("products",products);
        model.addAttribute("keyword",keyword);
        return "product/index";
    }
}
