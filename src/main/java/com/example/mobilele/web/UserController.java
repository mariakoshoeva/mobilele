package com.example.mobilele.web;

import com.example.mobilele.models.binding.UserLoginBindingModel;
import com.example.mobilele.models.binding.UserRegisterBindingModel;
import com.example.mobilele.models.service.UserLoginServiceModel;
import com.example.mobilele.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userRegisterForm")
    public void initUserRegisterForm(Model model){
        model.addAttribute("userRegisterForm", new UserRegisterBindingModel());
    }

    @ModelAttribute("userLoginBindingModel")
    public void initUserLoginBindingModel(Model model){
        model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register.html";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterForm",userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterForm", bindingResult);
            return "redirect:register";
        }
        userService.register(userRegisterBindingModel);
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if(!model.containsAttribute("loginSuccessful")){
            model.addAttribute("loginSuccessful",true);
        }
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginConfirm(UserLoginBindingModel userLoginBindingModel,RedirectAttributes redirectAttributes) {
        boolean loginSuccessful = userService
                .login(new UserLoginServiceModel()
                        .setUsername(userLoginBindingModel
                                .getUsername())
                        .setPassword(userLoginBindingModel
                                .getPassword()));

        logger.info("User tried to login. User with name {} tried to login. Success = ${}?",
                userLoginBindingModel.getUsername(),
                loginSuccessful);
        if (loginSuccessful) {
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("loginSuccessful",false);
        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }


}
