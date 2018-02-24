package org.andot.core.controller;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/aup/ais/loginController")
public class LoginController {
    @RequestMapping("/login")
    public String loginAis(){
        JSONObject json = new JSONObject();
        json.put("data", "");
        json.put("msg", "success");
        json.put("flag", true);
        return json.toString();
    }
}
