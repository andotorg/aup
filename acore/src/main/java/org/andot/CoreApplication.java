package org.andot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@ComponentScan("org.andot")
public class CoreApplication {

    private static Logger log = LoggerFactory.getLogger(CoreApplication.class);

    public static void main(String[] args) {
        if(args.length > 0){
            for (int i=0; i<args.length; i++){
                log.info("param "+ i +": "+args[i]);
            }
        }else
            log.error("not write param");
        SpringApplication.run(CoreApplication.class, args);
    }
}
