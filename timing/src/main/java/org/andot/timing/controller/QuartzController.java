package org.andot.timing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Configuration
@Component
@EnableScheduling
public class QuartzController {

    private static Logger log = LoggerFactory.getLogger(QuartzController.class);

    public void sayHello(){
        log.debug("hello quartz");
    }

}
