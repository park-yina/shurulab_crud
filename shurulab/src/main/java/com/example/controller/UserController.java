package com.example.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.UserCreateDTO;
import com.example.dto.UserLoginDTO;
import com.example.dto.UserMypageDTO;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService; // UserService 주입
    private final MypageService mypageService;

    @GetMapping("/user/signup")
    public String signup(Model model) {
        model.addAttribute("userCreateDTO", new UserCreateDTO());
        return "sign";
    }

    @PostMapping("/user/signup")
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
    public String postLogin(@Valid UserLoginDTO userLoginDTO, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        try {
            userService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword());
            session.setAttribute("username", userLoginDTO.getUsername());
            return "redirect:/"; // 로그인 성공 시 홈으로 리다이렉트
        } catch (Exception e) {
            bindingResult.reject("loginFail", "Invalid username or password");
            return "login"; // 로그인 실패 시 로그인 페이지로 이동
        }
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 로그아웃 시 세션 무효화
        return "redirect:/user/login?logout=true";
    }

    @GetMapping("/user/mypage")
    public String getMypage(HttpSession session, Model model) {
        Object username = session.getAttribute("username");

        if (username != null) {
            UserMypageDTO userMypageDTO = mypageService.getUserMypageInfo(String.valueOf(username));
            model.addAttribute("userMypageDTO", userMypageDTO);
            return "mypage";
        } else {
            return "redirect:/user/login";
        }
    }
    
}


