package org.andot.timing.controller;

import org.andot.timing.common.ReadYml;
import org.andot.timing.service.ConnDataBaseService;
import org.andot.timing.service.SendMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.Session;
import java.net.SocketPermission;
import java.util.Map;

@Configuration
@Component
@EnableScheduling
public class QuartzController {

    @Resource
    private SendMail sendMail;
    @Resource
    private ConnDataBaseService connDataBaseService;
    @Autowired
    private ReadYml readYml;


    private static Logger log = LoggerFactory.getLogger(QuartzController.class);

    public void sayHello(){
        log.debug("======>  定时器启动了 。。。。。。");
        Map<String, Object> map = sendMail.conTen();

        String ip = "192.168.0.9";
        System.out.println(ip);
        Integer point = 3306;
        String dbName = "pms";
        String uname = "root";
        String upwd = "iesapp";

        int count = connDataBaseService.conn(ip, point, dbName, uname, upwd, 1);
        sendMail.conTen();
        sendMail.send((Session)map.get("session"), "yanfront@qq.com", "数据库连接数通知-积成能源邮件通知小助手", "目标主机IP："+ip+"的现在连接数为："+count);
        sendMail.send((Session)map.get("session"), "sbfyx103@qq.com", "数据库连接数通知-积成能源邮件通知小助手", "目标主机IP："+ip+"的现在连接数为："+count);

    }

}
