package ir.maktabsharif.base.repository;


import ir.maktabsharif.util.ResultWrapper;
import ir.maktabsharif.base.model.BaseEntity;
import ir.maktabsharif.exeption.IdNotFoundException;
import ir.maktabsharif.util.EntityManagerProvider;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractBaseRepository<T extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<T, ID> {

    private EntityManager entityManager = EntityManagerProvider.getEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public ResultWrapper<ID> insert(T entity) {
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            return ResultWrapper.err(e.getMessage());
        }
        return ResultWrapper.ok(entity.getId());
    }

    @Override
    public Optional<Boolean> update(T entity) {
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
            return Optional.of(Boolean.TRUE);
        } catch (Exception e) {
            transaction.rollback();
            return Optional.of(Boolean.FALSE);
        }
    }

    //@SuppressWarnings("unchecked")
    @Override
    public Optional<List<T>> findAll() {
        String str = "select * from ".concat(tableName());
        Query query = entityManager.createNativeQuery(str, classType());
        List<T> resultList = query.getResultList();
        return Optional.of(resultList);
    }


    @Override
    public Optional<T> findById(ID id) {
        transaction.begin();
        Optional<T> optional = Optional.of(entityManager.find(classType(), id));
        transaction.commit();
        return optional;
    }


    @Override
    public Optional<Boolean> delete(ID id) throws IdNotFoundException {
        Optional<T> byId = this.findById(id);
        Optional<Boolean> isDeleted;
        if (byId.isPresent()) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(byId.get());
                entityManager.getTransaction().commit();
                isDeleted = Optional.of(true);
                return isDeleted;
            } catch (Exception e) {
                transaction.rollback();
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
