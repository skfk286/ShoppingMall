package com.shopping.connection.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.shopping.web.RootConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataSourceConnectionTest {
    
    @Autowired
    private DataSource ds;
    
    @Test
    public void testConnection() throws Exception {
        try(Connection conn = ds.getConnection()) {
            System.out.println("connec : " + conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
