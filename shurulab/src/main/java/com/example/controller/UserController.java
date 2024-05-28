package com.example.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService; // UserService 주입

    @GetMapping("/user/signup")
    public String signup(Model model) {
        model.addAttribute("userCreateDTO", new UserCreateDTO());
        return "sign";
    }

    @PostMapping("/user/signup/")
    public String postSignup(@Valid UserCreateDTO userCreateDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "sign";
        }

        userService.create(userCreateDTO.getUsername(), userCreateDTO.getPassword(), userCreateDTO.getNickname());
        return "redirect:/";
    }

    @GetMapping("/user/login")
    public String login(Model model) {
        model.addAttribute("userLoginDTO", new UserLoginDTO());
        return "login";
    }

    @PostMapping("/user/login")
    public String postLogin(@Valid UserLoginDTO userLoginDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        try {
            userService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword());
            return "redirect:/"; // 로그인 성공 시 홈으로 리다이렉트
        } catch (Exception e) {
            bindingResult.reject("loginFail", "Invalid username or password");
            return "login"; // 로그인 실패 시 로그인 페이지로 이동
        }
    }
}
