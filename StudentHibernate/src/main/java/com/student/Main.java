package com.student;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            Student student = new Student(
                    2,
                    "Gethsi",
                    "cde@gmail.com",
                    "B.E ECE"
            );

            session.persist(student);

            transaction.commit();

            System.out.println("Student inserted successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();

        } finally {

            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}