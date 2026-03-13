package com.inventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class ProductDAO {

    // Insert Product
    public void insertProduct() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p1 = new Product("Laptop","Dell Laptop",55000,10);
        Product p2 = new Product("Mouse","Wireless Mouse",500,50);

        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();

        System.out.println("Products Inserted Successfully");
    }

    // Retrieve Product
    public void getProduct(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Product p = session.get(Product.class,id);

        System.out.println("Product Name: " + p.getName());
        System.out.println("Price: " + p.getPrice());

        session.close();
    }

    // Update Product
    public void updateProduct(int id,double price) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class,id);
        p.setPrice(price);

        session.update(p);

        tx.commit();
        session.close();

        System.out.println("Product Updated");
    }

    // Delete Product
    public void deleteProduct(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class,id);

        session.delete(p);

        tx.commit();
        session.close();

        System.out.println("Product Deleted");
    }
}