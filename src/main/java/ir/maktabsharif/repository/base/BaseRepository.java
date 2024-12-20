package ir.maktabsharif.repository.base;

import ir.maktabsharif.util.ResultWrapper;
import ir.maktabsharif.model.base.BaseEntity;
import ir.maktabsharif.exeption.IdNotFoundException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository <T extends BaseEntity<ID>,ID extends Serializable> {

    ResultWrapper<ID> insert(T entity) ;

    Optional<Boolean> update(T entity) ;

    Optional<Boolean> delete(ID id) throws IdNotFoundException;

    Optional<T> findById(ID id) ;

    List<T> findAll() ;

}
