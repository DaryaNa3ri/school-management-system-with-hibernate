package ir.maktabsharif.repository.impl;

import ir.maktabsharif.base.repository.AbstractBaseRepository;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.StudentRepository;

public class StudentRepositoryImpl extends AbstractBaseRepository<Student,Long> implements StudentRepository {



    @Override
    public String tableName() {
        return "student";
    }

    @Override
    public Class<Student> classType() {
        return Student.class;
    }

}
