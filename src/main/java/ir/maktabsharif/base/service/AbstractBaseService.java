package ir.maktabsharif.base.service;

import ir.maktabsharif.base.repository.BaseRepository;

import java.util.Optional;

public abstract class AbstractBaseService<T,ID> implements BaseService <T,ID>{

    //private BaseRepository<T,ID> repository;


    @Override
    public void save(T t) {

    }

    public Optional<T> findById(Long id) {

        return Optional.empty();
    }












    /*private BaseRepository<T> repository;

    public AbstractBaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void save(T t) {
        try {
            repository.insert(t);
        }catch (Exception e) {
            System.out.println("data connection failed :( ");
        }
    }*/

}
