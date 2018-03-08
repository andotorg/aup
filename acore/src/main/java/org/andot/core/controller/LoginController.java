package org.andot.core.controller;

import net.sf.json.JSONObject;
import org.andot.core.entity.Demo;
import org.andot.core.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/rest/aup/core/loginController")
public class LoginController {

    @Resource
    private TestService testService;

    @RequestMapping("/login")
    public String loginAis() throws Exception {
        Demo demo = new Demo();
        demo.setAge(35);
        demo.setName("hello");
        testService.addTestInfo(demo);
        JSONObject json = new JSONObject();
        json.put("data", "");
        json.put("msg", "success");
        json.put("flag", true);
        return json.toString();
    }
}
