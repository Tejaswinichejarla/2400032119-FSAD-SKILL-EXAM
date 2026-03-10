package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        Inventory inv = new Inventory("Laptop","Dell Laptop",new Date(),"Available");

        session.save(inv);

        tx.commit();

        System.out.println("Record Inserted Successfully with ID: "+inv.getId());

       /* Transaction tx2 = session.beginTransaction();

        Inventory obj = session.get(Inventory.class,inv.getId());

        if(obj!=null)
        {
            session.delete(obj);
            System.out.println("Record Deleted Successfully");
        }

        tx2.commit();*/  

        session.close();
        sf.close();
    }
}