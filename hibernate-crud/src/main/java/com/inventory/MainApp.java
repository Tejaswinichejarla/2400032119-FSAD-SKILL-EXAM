package com.inventory;

import com.inventory.dao.ProductDAO;

public class MainApp {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        dao.insertProduct();
        dao.getProduct(1);
        dao.updateProduct(1,60000);
        dao.deleteProduct(1);

    }
}