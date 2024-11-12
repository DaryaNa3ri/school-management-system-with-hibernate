package ir.maktabsharif.repository.impl;

import ir.maktabsharif.repository.base.AbstractBaseRepository;
import ir.maktabsharif.model.Course;
import ir.maktabsharif.repository.CourseRepository;

public class CourseRepositoryImpl extends AbstractBaseRepository<Course,Long> implements CourseRepository {
    @Override
    public Class<Course> classType() {
        return Course.class;
    }

    @Override
    public String tableName() {
        return "courses";
    }
}
