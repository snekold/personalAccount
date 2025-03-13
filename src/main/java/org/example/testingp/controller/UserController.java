package org.example.testingp.controller;

import org.example.testingp.model.entity.User;
import org.example.testingp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/test")
    public String test() {
        return "test";
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
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.saveUser(user);

        System.out.println("Пользователь зарегистрирован: "
                + username + ", " + password);

        return "/addUseMessage";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password
    ){
        if(userService.findUserByUsername(username).getUsername() != null){
            if(userService.findUserByUsername(username).getPassword().equals(password)){
                return "redirect:/test";
            }else {
                return "error";
            }
        }else {
            return "redirect:/error";
        }
    }

}
