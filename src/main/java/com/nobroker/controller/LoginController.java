package com.nobroker.controller;
import com.nobroker.service.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private EmailVerificationService emailVerificationService;

    //http://localhost:8080/api/send-otp-for-login?email=akkijai145@gmail.com
    @PostMapping("/send-otp-for-login")
    public Map<String, String> sendOtpForLogin(@RequestParam String email) {
        return emailVerificationService.sendOtpForLogin(email);
    }


    //http://localhost:8080/api/verify-otp-for-login?email=akkijai145@gmail.com&446711


    @PostMapping("/verify-otp-for-login")
    public Map<String, String> verifyOtpForLogin(@RequestParam String email, @RequestParam String otp) {
        return emailVerificationService.verifyOtpForLogin(email, otp);
    }
}
