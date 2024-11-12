package ir.maktabsharif.repository.impl;

import ir.maktabsharif.repository.base.AbstractBaseRepository;
import ir.maktabsharif.model.Exam;
import ir.maktabsharif.repository.ExamRepository;

public class ExamRepositoryImpl extends AbstractBaseRepository<Exam,Long> implements ExamRepository {
    @Override
    public Class<Exam> classType() {
        return Exam.class;
    }

    @Override
    public String tableName() {
        return "exams";
    }
}
