package ir.maktabsharif.repository.impl;

import ir.maktabsharif.base.repository.AbstractBaseRepository;
import ir.maktabsharif.model.Exam;
import ir.maktabsharif.repository.ExamRepository;

public class ExamRepositoryImpl extends AbstractBaseRepository<Exam,Long> implements ExamRepository {
    @Override
    public Class<Exam> classType() {
        return Exam.class;
    }

    @Override
    public String tableName() {
        return "exam";
    }
}
