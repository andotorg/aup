package org.andot.timing.service.impl;

import com.sun.mail.util.MailSSLSocketFactory;
import org.andot.timing.service.SendMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service("sendMail")
public class SendMailImpl implements SendMail{

    private static Logger log = LoggerFactory.getLogger(SendMailImpl.class);

    /**
     * 连接邮件服务器
     *
     *
     * */
    @Override
    public Map<String, Object> conTen(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Properties props = new Properties();

            // 开启debug调试
            props.setProperty("mail.debug", "true");
            // 发送服务器需要身份验证
            props.setProperty("mail.smtp.auth", "true");
            // 设置邮件服务器主机名
            props.setProperty("mail.host", "smtp.qq.com");
            // 发送邮件协议名称
            props.setProperty("mail.transport.protocol", "smtp");

            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);

            Session session = Session.getInstance(props);
            map.put("flag", true);
            map.put("session", session);
        }catch (Exception e){
            log.error("邮件服务器连接异常，异常信息为："+e.getMessage());
            map.put("flag", false);
            map.put("session", "邮件服务器连接异常，异常信息为："+e.getMessage());
        }
        return map;

    }

    /**
     * 发送邮件
     *
     *
     * */
    @Override
    public void send(Session session, String person, String headStr, String conStr){
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        try {


            Message msg = new MimeMessage(session);
            msg.setSubject(headStr);
            StringBuilder builder = new StringBuilder();
            builder.append(conStr);
            builder.append("\n 发生时间： " + sdf.format(new Date()));
            msg.setText(builder.toString());
            msg.setFrom(new InternetAddress("407049765@qq.com"));

            Transport transport = session.getTransport();
            transport.connect("smtp.qq.com", "407049765@qq.com", "nqadyoyjomdfbiid");

            transport.sendMessage(msg, new Address[] { new InternetAddress(person) });
            transport.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
