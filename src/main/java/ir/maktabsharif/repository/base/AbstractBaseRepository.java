package ir.maktabsharif.repository.base;


import ir.maktabsharif.util.ResultWrapper;
import ir.maktabsharif.model.base.BaseEntity;
import ir.maktabsharif.exeption.IdNotFoundException;
import ir.maktabsharif.util.EntityManagerProvider;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractBaseRepository<T extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<T, ID> {

    private EntityManager entityManager = EntityManagerProvider.getEntityManager();

    @Override
    public ResultWrapper<ID> insert(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return ResultWrapper.err(e.getMessage());
        }
        return ResultWrapper.ok(entity.getId());
    }

    @Override
    public Optional<Boolean> update(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return Optional.of(Boolean.TRUE);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return Optional.of(Boolean.FALSE);
        }
    }

    //@SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        String str = "select * from ".concat(tableName());
        Query query = entityManager.createNativeQuery(str, classType());
        //Query query = entityManager.createQuery("SELECT COUNT(s) FROM Student s");
        //
        List<T> resultList = query.getResultList();
        return resultList;
    }


    @Override
    public Optional<T> findById(ID id) {
        entityManager.getTransaction().begin();
        Optional<T> optional = Optional.of(entityManager.find(classType(), id));
        entityManager.getTransaction().commit();
        return optional;
    }


    @Override
    public Optional<Boolean> delete(ID id) throws IdNotFoundException {
        Optional<T> foundObject = this.findById(id);
        Optional<Boolean> isDeleted;
        if (foundObject.isPresent()) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(foundObject.get());
                entityManager.getTransaction().commit();
                isDeleted = Optional.of(true);
                return isDeleted;
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            }
        } else {
            throw new IdNotFoundException("finding id was unsuccessfully");
        }
        isDeleted = Optional.of(false);
        return isDeleted;
    }

    public abstract Class<T> classType();

    public abstract String tableName();
}
