package ir.maktabsharif;

import ir.maktabsharif.exeption.IdNotFoundException;
import ir.maktabsharif.model.*;
import ir.maktabsharif.repository.StudentRepository;
import ir.maktabsharif.repository.TeacherRepository;
import ir.maktabsharif.repository.UserRepository;
import ir.maktabsharif.repository.impl.StudentRepositoryImpl;
import ir.maktabsharif.repository.impl.TeacherRepositoryImpl;
import ir.maktabsharif.repository.impl.UserRepositoryImpl;
import ir.maktabsharif.thread.TwoMSThread;
import ir.maktabsharif.util.EntityManagerProvider;
import ir.maktabsharif.util.ResultWrapper;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IdNotFoundException {

        StudentRepository studentRepository = new StudentRepositoryImpl();
        TeacherRepository teacherRepository = new TeacherRepositoryImpl();
        UserRepository userRepository = new UserRepositoryImpl();


        ResultWrapper<Long> john = studentRepository.insert(Student
                .builder()
                .firstName("John")
                        .lastName("Doe")
                .gpu(12.2)
                .gender(Gender.MALE)
                .build());




        //System.out.println(john);

        List<Student> list = studentRepository.findStudentByFirstNameAndLastName("John", "Doe");
        System.out.println(list);
    }


}




















/*Optional<List<Student>> all = studentRepository.findAll();

        if (all.isPresent()) {
            for (Student student : all.get()) {
                TwoMSThread twoMSThread = new TwoMSThread();
                twoMSThread.start();
                    System.out.println(student);
                try {
                    twoMSThread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }*/