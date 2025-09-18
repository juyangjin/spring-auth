package com.sparta.springauth.controller;

import com.sparta.springauth.dto.ProductRequestDto;
import com.sparta.springauth.entity.User;
import com.sparta.springauth.security.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/products")
    public String getProducts(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        User user = userDetails.getUser();
        System.out.println("user.getUsername() = " + user.getUsername()); //단축키 .soutv 기억해두기
        System.out.println("user.getEmail() = " + user.getEmail());

        return "redirect:/";
    }
    /**
     * TODO 관리자용 예외처리 들어가야 하는 부분, 에러 나서 제외됨 예외 페이지도 html로 resources.static에 들어가야함
     **/
    @PostMapping("/validation")
    @ResponseBody
    public ProductRequestDto testValid(@RequestBody @Valid ProductRequestDto requestDto) {
        return requestDto;
    }
}