package com.kainmvc.user_thuc_hanh.controller;

import com.kainmvc.user_thuc_hanh.model.User;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.Cookie;
@Controller
@SessionAttributes("user")
public class LoginController {

    /*add user in model attribute*/
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("/login")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        model.addAttribute("cookieValue", setUser);
        return "/views/login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("user") User user, Model model,
                          @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        // implement business logic
        if (user.getEmail().equals("admin@gmail.com")
                && user.getPassword().equals("123456")) {
            if (user.getEmail() != null) {
                setUser = user.getEmail();
            }

            // create cookie and set it in response
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            // get all cookies
            Cookie[] cookies = request.getCookies();
            // iterate each cookie
            for (Cookie ck : cookies) {
                // display only the cookie with the name 'setUser'
                if (!ck.getName().equals("setUser")) {
                    ck.setValue("");
                }
                model.addAttribute("cookieValue", ck.getValue());
            }
            model.addAttribute("message", "Login success. Welcome!");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "/views/login";
    }
}