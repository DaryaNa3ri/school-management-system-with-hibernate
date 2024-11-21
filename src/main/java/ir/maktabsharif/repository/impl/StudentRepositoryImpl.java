package ir.maktabsharif.repository.impl;

import ir.maktabsharif.repository.base.AbstractBaseRepository;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.StudentRepository;
import ir.maktabsharif.util.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class StudentRepositoryImpl extends AbstractBaseRepository<Student,Long> implements StudentRepository {

private EntityManager entityManager = EntityManagerProvider.getEntityManager();

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


    public List<Student> findStudentByFirstNameAndLastName(String firstName, String lastName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);

        Predicate predicate =
                cb.and(cb.equal(root.get("firstName"), firstName),
                cb.equal(root.get("lastName"), lastName));

        cq.where(predicate);

        return this.entityManager.createQuery(cq).getResultList();
    }

    @Override
    public String tableName() {
        return "students";
    }

    @Override
    public Class<Student> classType() {
        return Student.class;
    }

}
