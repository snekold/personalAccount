package org.example.testingp.controller;

import org.example.testingp.model.entity.User;
import org.example.testingp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }



    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/reg")
    public String regPost(
            @RequestParam String username,
            @RequestParam String password
    ) {
        if(userService.findUserByUsername(username) == null){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userService.saveUser(user);

            System.out.println("Пользователь зарегистрирован: "
                    + username + ", " + password);

            return "/addUseMessage";
        }else {
            return "/error3";
        }
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model
    ){
        if(userService.findUserByUsername(username).getUsername() != null){
            if(userService.findUserByUsername(username).getPassword().equals(password)){
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                model.addAttribute("user", user);
                return "/test";
            }else {
                return "/error2";
            }
        }else {
            return "/error";
        }
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
