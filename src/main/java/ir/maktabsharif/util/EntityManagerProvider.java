package ir.maktabsharif.util;

import lombok.Getter;
import lombok.experimental.UtilityClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@UtilityClass
public class EntityManagerProvider {

    @Getter
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc-postgres");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
