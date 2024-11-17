package stu.cn.ua.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import stu.cn.ua.domain.Product;
import stu.cn.ua.domain.Seller;

public class HibernateDAOFactory {
    private static HibernateDAOFactory instance = null;
    private SessionFactory sessionFactory;

    public static synchronized HibernateDAOFactory getInstance() {
        if (null == instance)
            instance = new HibernateDAOFactory();
        return instance;
    }

    private HibernateDAOFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperty(AvailableSettings.DRIVER, "org.postgresql.Driver");
        configuration.setProperty(AvailableSettings.URL, "jdbc:postgresql://localhost:5432/shop");
        configuration.setProperty(AvailableSettings.USER, "postgres");
        configuration.setProperty(AvailableSettings.PASS, "1204");
        configuration.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        configuration.setProperty(AvailableSettings.SHOW_SQL, "true");
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Seller.class);
        configuration.setProperty
                ("hibernate.current_session_context_class", "thread");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public ProductDAO getProductDAO() {
        return new ProductDAO();
    }

    public SellerDAO getSellerDAO() {
        return new SellerDAO();
    }

}