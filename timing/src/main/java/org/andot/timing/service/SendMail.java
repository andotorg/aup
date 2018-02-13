package org.andot.timing.service;

import java.util.Map;
import javax.mail.Session;

public interface SendMail {

    /**
     * 连接邮件服务器
     *
     *
     * */
    public Map<String, Object> conTen();

    /**
     * 发送邮件
     *
     *
     * */
    public void send(Session session, String person, String headStr, String conStr);
}
