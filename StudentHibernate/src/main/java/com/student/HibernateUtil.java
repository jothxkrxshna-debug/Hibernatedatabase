package com.student;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {

            Configuration configuration = new Configuration();

            Properties properties = new Properties();

            properties.put("hibernate.connection.driver_class",
                    "com.mysql.cj.jdbc.Driver");

            properties.put("hibernate.connection.url",
                    "jdbc:mysql://db01.dbhost.dev:5051/db_455a3c4zu");

            properties.put("hibernate.connection.username",
                    "user_455a3c4zu");

            properties.put("hibernate.connection.password",
                    "p455a3c4zu");

            properties.put("hibernate.dialect",
                    "org.hibernate.dialect.MySQLDialect");

            properties.put("hibernate.hbm2ddl.auto",
                    "update");

            properties.put("hibernate.show_sql",
                    "true");

            configuration.setProperties(properties);

            configuration.addAnnotatedClass(Student.class);

            sessionFactory = configuration.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}