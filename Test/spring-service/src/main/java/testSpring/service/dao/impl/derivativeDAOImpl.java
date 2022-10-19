package testSpring.service.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import testSpring.service.dao.DerivativeDAO;
import testSpring.service.model.Derivative;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component(value = "derivativeDAO")
public class derivativeDAOImpl implements DerivativeDAO {

    private final static Logger lg = Logger.getLogger(derivativeDAOImpl.class);

    private LocalSessionFactoryBean sessionFactory;
    private static JdbcTemplate jdbcTemplate;
    private static DataSource dataSource;

    private final static int size = 2;


    public LocalSessionFactoryBean getSessionFactory() {
        return sessionFactory;
    }

    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        derivativeDAOImpl.jdbcTemplate = jdbcTemplate;
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
//    @Qualifier("dtSource")
    public void setDataSource(DataSource dataSource) {
        derivativeDAOImpl.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Autowired
    private PlatformTransactionManager transactionManager;

    private final static class DerivativeRowMapper implements RowMapper<Derivative> {
        @Override
        public Derivative mapRow(ResultSet rs, int i) throws SQLException {
            try {
                Derivative deri = new Derivative();
                deri.setDeri_composite_code(rs.getString(1));
                deri.setDerivative_code(rs.getString(2));
                deri.setEffective_date(rs.getDate(3));
                deri.setExpiration_date(rs.getDate(4));
                deri.setCreated_date(rs.getDate(5));
                deri.setCreated_by(rs.getString(6));
                deri.setModified_date(rs.getDate(7));
                deri.setModified_by(rs.getString(8));
                deri.setUnderlying_type(rs.getString(9));
                return deri;
            } catch (Exception exp) {
                lg.error(exp);
                return null;
            }
        }
    }

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insert(String compositeCode, String deriCode, Date effDate, Date expi, Date dateCreated, String createBy, Date modified, String modifieBy, String underlying) {
    }

    @Override
    public List<Derivative> list(Integer page, Integer size, String sort, String filter
    ) {
        Session session = sessionFactory.getObject().openSession();
        try {
            String sql = "from Derivative where 1=1";

            if(filter!=null){

                String forFill[]=filter.split(":");
                String forAtt=forFill[0];
                String forFilter[]=forFill[1].split(",");

                sql+=" and "+forAtt+" in(";
                for (int i = 0; i < forFilter.length; i++) {
                    sql+="'"+forFilter[i]+"',";
                }
                if (sql.endsWith(",")) {
                    sql = sql.substring(0, sql.length() - 1);
                }
                sql += ")";
            }
            if (sort != null) {
                switch (sort) {
                    case "deriCode:desc": {
                        sql += " order by deri_composite_code desc";
                        break;
                    }
                    case "deriCode:asc": {
                        sql += " order by deri_composite_code asc";
                        break;
                    }
                }
            }
            Query query = session.createQuery(sql);
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
            return (List<Derivative>) query.list();
        } finally {
            session.close();
        }

//        return jdbcTemplate.query("SELECT * FROM derivative", new DerivativeRowMapper());

//        Session session = sessionFactory.getObject().openSession();
//        Criteria cr = session.createCriteria(Derivative.class);
//        int start=(page-1)*size;
//        cr.setFirstResult(start);
//        cr.setMaxResults(size);
//
//        return (List<Derivative>) cr.list();
    }

}
