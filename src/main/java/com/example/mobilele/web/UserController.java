package com.example.mobilele.web;

import com.example.mobilele.models.binding.UserLoginBindingModel;
import com.example.mobilele.models.binding.UserRegisterBindingModel;
import com.example.mobilele.models.service.UserLoginServiceModel;
import com.example.mobilele.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userRegisterForm",new UserRegisterBindingModel());
        return "auth-register.html";
    }

    @PostMapping("/register")
    public String registerConfirm(UserRegisterBindingModel userRegisterBindingModel){
//        model.addAttribute("userRegisterForm",userRegisterBindingModel);
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginConfirm(UserLoginBindingModel userLoginBindingModel){
        boolean loginSuccessful =  userService
                .login(new UserLoginServiceModel()
                        .setUsername(userLoginBindingModel
                                .getUsername())
                        .setPassword(userLoginBindingModel
                                .getPassword()));

        logger.info("User tried to login. User with name {} tried to login. Success = ${}?",
                userLoginBindingModel.getUsername(),
                loginSuccessful);
        if (loginSuccessful){
            return "redirect:/";
        }

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }


}
