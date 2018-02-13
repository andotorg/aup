package org.andot.timing.service.impl;

import org.andot.timing.dao.ConnDataBase;
import org.andot.timing.service.ConnDataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service("connDataBaseService")
public class ConnDataBaseServiceImpl implements ConnDataBaseService {

    @Autowired
    private ConnDataBase connDataBase;

    @Override
    public Integer conn(String ip, Integer point, String dbName, String uname, String upwd, Integer dbType) {
        int count = 0;
        try {
            count = connDataBase.conMysql(ip, point, dbName, uname, upwd, dbType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
