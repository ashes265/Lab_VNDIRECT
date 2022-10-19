package edu.hanoi.jazz.dao.impl;

import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.dao.model.Group;
import edu.hanoi.jazz.dao.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {
    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
    private final static int SIZE_OF_PAGE=2;

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void insert(User user) {
        Session session = sessionFactory.getObject().openSession();
        session.getTransaction().begin();
        session.save(user);
        session.flush();
        session.getTransaction().commit();
        LOGGER.info("Save user " + user.getUsername() + " done!");
        session.close();
    }

    @Override
    public List<User> list() {
        Session session = sessionFactory.getObject().openSession();
        Query query = session.createQuery("from User order by age desc");
        try {
            return (List<User>) query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> listFilter(Integer id) {
        Session session = sessionFactory.getObject().openSession();
        Query query = session.createQuery("from User");
        try {
            if (id == null || id < 0) {
                query = session.createQuery("from User");
                return (List<User>) query.list();
            }
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("groupId", id));
            return new ArrayList<User>(criteria.list());
        } finally {
            session.close();
        }
    }

    @Override
    public User get(String name) {
        Session session = sessionFactory.getObject().openSession();
        return session.get(User.class, name);
    }

    @Override
    public void delete(String name) {
        Session session = sessionFactory.getObject().openSession();
        String hql = "delete from User where username like :name";
        Query query = session.createQuery(hql);
        session.getTransaction().begin();
        query.setParameter("name", name);
        int rs = query.executeUpdate();
        session.getTransaction().commit();
        LOGGER.info("Rows affected: " + rs + "\n\n");
        session.close();
    }

    @Override
    public List<User> listOlder() {
        Session session = sessionFactory.getObject().openSession();
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.gt("age", 50));
        return (List<User>) cr.list();
    }

    @Override
    public int avarageAge() {
        Session session = sessionFactory.getObject().openSession();
        Criteria cr = session.createCriteria(User.class);
        cr.setProjection(Projections.avg("age"));
        List avgAge = cr.list();
        return ((Double) avgAge.get(0)).intValue();
    }

    @Override
    public List<User> page(int page) {
        Session session = sessionFactory.getObject().openSession();
        Criteria cr = session.createCriteria(User.class);
        int start=(page-1)*SIZE_OF_PAGE;
        cr.setFirstResult(start);
        cr.setMaxResults(SIZE_OF_PAGE);
        return (List<User>) cr.list();
    }

    @Override
    public List<User> listUserByNativeSQL() {
        Session session = sessionFactory.getObject().openSession();
        String sql="select * from hn_user where age< :value";
        NativeQuery query=session.createSQLQuery(sql);
        query.setParameter("value",50);
        query.addEntity(User.class);
        return query.list();
    }

    @Override
    public void addBatch() {
        Session session = sessionFactory.getObject().openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            for (int i = 0; i < 10; i++) {
                session.save(UserFactory.generate(i+1));
            }
            session.flush();
            tx.commit();
        }catch (HibernateException e){
//            if(tx!=null)tx.rollback();
            LOGGER.error(e,e);
        }finally {
            session.close();
        }
    }
}
