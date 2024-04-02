package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Alien a1=new Alien();
        a1.setAid(1);
        a1.setAname("Axel");
        a1.setColor("Blue");


        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

        SessionFactory sf=con.buildSessionFactory();

        Session session=sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(a1);

         tx.commit();
    }




}
