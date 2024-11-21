package ir.maktabsharif.repository;

import ir.maktabsharif.repository.base.BaseRepository;
import ir.maktabsharif.model.Student;

import java.util.List;

public interface StudentRepository extends BaseRepository<Student,Long> {
    //List<Student> findByFirstName(String firstName);


    List<Student> findStudentByFirstNameAndLastName(String firstName, String lastName);
}
