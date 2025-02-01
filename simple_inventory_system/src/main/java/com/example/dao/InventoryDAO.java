package com.example.dao;


import com.example.inventory.model.InventoryItem;
import com.example.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class InventoryDAO {
    public List<InventoryItem> getAllItems() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM InventoryItem", InventoryItem.class).list();
        }
    }

    public void addItem(InventoryItem item) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        }
    }

    public void deleteItem(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            InventoryItem item = session.get(InventoryItem.class, id);
            if (item != null) {
                session.delete(item);
                transaction.commit();
            }
        }
    }
}
