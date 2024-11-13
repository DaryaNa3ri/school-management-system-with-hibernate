package ir.maktabsharif.repository.impl;

import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.UserRepository;
import ir.maktabsharif.repository.base.AbstractBaseRepository;

public class UserRepositoryImpl extends AbstractBaseRepository<User,Long> implements UserRepository {
    @Override
    public Class<User> classType() {
        return User.class;
    }

    @Override
    public String tableName() {
        return "users";
    }
}
