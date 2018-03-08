package org.andot.core.service.impl;

import org.andot.core.entity.Demo;
import org.andot.core.mapper.mysql.TestMapper;
import org.andot.core.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(value = "transactionManagerMySqlOne",
        propagation = Propagation.REQUIRED,
        isolation = Isolation.DEFAULT,
        timeout=36000,
        rollbackFor=Exception.class)
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    /**
     *
     * readOnly=true该方法不使用事务
     *
     * */
    @Override
    public Integer addTestInfo(Demo demo) throws Exception {
        int a = 0;
        for (int i=0; i<5; i++){
            if(i == 3){
                throw new Exception("自定义虚拟异常，判断失误回滚");
            }
            a = testMapper.addTestInfo(demo.getName(), demo.getAge());
        }
        return a;
    }

    @Transactional(readOnly=true)
    @Override
    public List<Demo> getTestInfoByList() {
        return testMapper.getTestInfoByList();
    }
}
