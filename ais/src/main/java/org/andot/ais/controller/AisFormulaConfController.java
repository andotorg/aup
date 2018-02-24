package org.andot.ais.controller;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 配置灌溉费用计算公式
 *
 * */
@RestController
@RequestMapping("/rest/ais/aisFormulaConfController")
public class AisFormulaConfController {

    @RequestMapping("/setFormulaParam")
    public String setFormulaParam(){
        JSONObject json = new JSONObject();
        json.put("msg", "设置成功");
        json.put("flag", true);
        return json.toString();
    }

    @RequestMapping("/setFormulaCode")
    public String setFormulaCode(){
        JSONObject json = new JSONObject();
        json.put("msg", "设置成功");
        json.put("flag", true);
        return json.toString();
    }

}
