package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConfig {
    public static BasicDataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/northwind");
        ds.setUsername("root");
        ds.setPassword("121617");

        return ds;
    }
}
