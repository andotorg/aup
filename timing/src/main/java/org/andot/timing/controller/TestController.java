package org.andot.timing.controller;

import org.andot.timing.service.SendMail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.Session;
import java.util.Map;

@RestController
public class TestController {

    @Resource
    private SendMail sendMail;

    @GetMapping("/test")
    public String test(){
        Map<String, Object> map = sendMail.conTen();
        sendMail.send((Session)map.get("session"), "yanfront@qq.com", "测试邮箱发送", "收到邮件了吗");
        return "你好";
    }
}
