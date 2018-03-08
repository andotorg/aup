package org.andot.core.service;

import org.andot.core.entity.Demo;

import java.util.List;

public interface TestService {

    Integer addTestInfo(Demo demo) throws Exception;

    List<Demo> getTestInfoByList();

}
