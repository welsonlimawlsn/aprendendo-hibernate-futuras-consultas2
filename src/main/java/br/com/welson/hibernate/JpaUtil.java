package br.com.welson.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    public static EntityManager getEntityManger() {
        return entityManagerFactory.createEntityManager();
    }

    public static void close () {
        entityManagerFactory.close();
    }
}
