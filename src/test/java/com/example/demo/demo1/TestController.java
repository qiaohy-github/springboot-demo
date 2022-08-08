package com.example.demo.demo1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;


public class TestController {


    public Object test (HttpServletRequest request,
                        HttpServletResponse response) throws Exception {

        ResponseCookie cookie = ResponseCookie.from("myCookie", "myCookieValue") // key & value
                .httpOnly(true)		// 禁止js读取
                .secure(false)		// 在http下也传输
                .domain("localhost")// 域名
                .path("/")			// path
                .maxAge(Duration.ofHours(1))	// 1个小时候过期
                .sameSite("Lax")	// 大多数情况也是不发送第三方 Cookie，但是导航到目标网址的 Get 请求除外
                .build()
                ;

        // 设置Cookie Header
        response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());

        return "ok";
    }
}

