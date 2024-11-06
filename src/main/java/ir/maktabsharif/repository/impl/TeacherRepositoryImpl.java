package ir.maktabsharif.repository.impl;

import ir.maktabsharif.base.repository.AbstractBaseRepository;
import ir.maktabsharif.model.Teacher;
import ir.maktabsharif.repository.TeacherRepository;

public class TeacherRepositoryImpl extends AbstractBaseRepository<Teacher,Long> implements TeacherRepository {

    @Override
    public Class<Teacher> classType() {
        return Teacher.class;
    }

    @Override
    public String tableName() {
        return "teacher";
    }
}
