package ir.maktabsharif.repository.impl;

import ir.maktabsharif.repository.base.AbstractBaseRepository;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.StudentRepository;


public class StudentRepositoryImpl extends AbstractBaseRepository<Student,Long> implements StudentRepository {



    /*public List<Student> findByFirstName(String firstName) {
        TypedQuery<Student> studentTypedQuery = this.em.createNamedQuery("Student.findByFirstName", Student.class);
        studentTypedQuery.setParameter(1, firstName);
        //or
        //Query query = this.em.createNamedQuery("Student.findByFirstName");
        //query.setParameter(1, firstName);
        return studentTypedQuery.getResultList();
    }*/

    /*public int getUserCount(){
        Query query = this.em.createQuery("SELECT COUNT(s) FROM Student s");
        int result = (int) query.getSingleResult();
        return result;
    }*/

    @Override
    public String tableName() {
        return "students";
    }

    @Override
    public Class<Student> classType() {
        return Student.class;
    }

}
