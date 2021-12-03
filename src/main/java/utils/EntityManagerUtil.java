package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Reunion");
        // redundant
        //EntityManager manager = factory.createEntityManager();
        return factory.createEntityManager();
    }

}
