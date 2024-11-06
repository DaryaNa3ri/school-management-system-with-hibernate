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


    //basic  base repository implementation
    /*@Override
    public void insert(T t) {

        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(t);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }finally {
            entityManager.close();
        }

        *//*EntityTransaction transaction = null;
        try (EntityManager entityManager = entityManagerProvider.getEntityManager()){
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(t);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }*//*

    }

    @Override
    public void update(T object, Integer id) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

    }

    @Override
    public void delete(Integer id) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

    }

    @Override
    public Optional<T> findById(Integer id) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Integer i = entityManager.find(Integer.class, id);
        transaction.commit();
        return null;
    }

    @Override
    public Optional<List<T>> findAll() {
        return Collections.emptySet();
    }*/
}
