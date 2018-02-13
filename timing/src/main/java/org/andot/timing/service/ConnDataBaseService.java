package org.andot.timing.service;

public interface ConnDataBaseService {
    public Integer conn(String ip, Integer point, String dbName, String uname, String upwd, Integer dbType);
}
