package util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("SessionFactory creation failed :( " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}