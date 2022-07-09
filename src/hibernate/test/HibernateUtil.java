package hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final String urlHibernateCfg = "/META-INF/hibernate.cfg.xml";
    
    private static final SessionFactory sessionFactory;    

    static {
        try {
            sessionFactory = new Configuration()
                    .configure(urlHibernateCfg)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public static void shutdown() {
        sessionFactory.close();
    }
}
