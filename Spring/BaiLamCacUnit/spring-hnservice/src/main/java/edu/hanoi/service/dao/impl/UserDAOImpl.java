package edu.hanoi.service.dao.impl;

import edu.hanoi.service.dao.UserDAO;
import edu.hanoi.service.model.User;
import edu.hanoi.service.model.UserFactory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;


@Component(value = "userDAO")
public class UserDAOImpl implements UserDAO {
    private final static Logger lg = Logger.getLogger(UserDAOImpl.class);
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> list() {
        Session session = sessionFactory.getObject().openSession();
        try {
            Query query = session.createQuery("from User order by age desc ");
            return (List<User>) query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public void addBatch() {
        Session session = sessionFactory.getObject().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            for (int i = 0; i < 10; i++) {
                session.save(UserFactory.generate(i + 1));
            }
//            session.flush();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            lg.error(e, e);
        } finally {
            session.close();
        }
    }

    @Override
    public String insert(User user) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            Serializable value = session.save(user);
            session.flush();
            lg.info("Save user " + user.getUsername() + " done!" + value);
            session.getTransaction().commit();
            return value.toString();
        } finally {
            session.close();
        }
    }

    @Override
    public User get(String username) {
        Session session = sessionFactory.getObject().openSession();
        return session.get(User.class, username);
    }

    @Override
    public void delete(String name) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            User user = session.get(User.class, name);
            if (user != null) session.delete(user);
            session.flush();
            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.update(user);
            session.flush();
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
