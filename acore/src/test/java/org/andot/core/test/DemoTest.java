package org.andot.core.test;

import org.andot.CoreApplication;
import org.andot.core.entity.Demo;
import org.andot.core.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CoreApplication.class)
@WebAppConfiguration
public class DemoTest {

    @Resource
    private TestService testService;

    private Logger log = LoggerFactory.getLogger(DemoTest.class);

    @Test
    @Transient
    public void addTestInfo(){
        for (int i=0; i<10; i++){
            log.error("日志测试==========="+i);
        }
        List<Demo> list = testService.getTestInfoByList();
        Demo demo = new Demo();
        demo.setAge(35);
        demo.setName("hello");
        try {
            testService.addTestInfo(demo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
