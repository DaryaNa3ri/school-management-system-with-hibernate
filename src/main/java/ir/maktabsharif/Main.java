package ir.maktabsharif;

import ir.maktabsharif.exeption.IdNotFoundException;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.StudentRepository;
import ir.maktabsharif.repository.impl.StudentRepositoryImpl;
import ir.maktabsharif.thread.TwoMSThread;
import ir.maktabsharif.util.EntityManagerProvider;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IdNotFoundException {
/*
        Course course = Course
                .builder()
                .title("java")
                .unit(1000)
                .build();*/

        //BaseService<Course> baseService = new AbstractBaseService<>(new AbstractBaseRepository<Course>(new EntityManagerProvider()));
        //baseService.save(course);

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc-postgres");
        EntityManager em = emf.createEntityManager();
        emf.close();*/


        StudentRepository studentRepository = new StudentRepositoryImpl();
        /*System.out.println(studentRepository.insert(Student.builder()
                .firstName("Ali")
                .lastName("Najafi")
                .nationalCode("11")
                .build()));
        System.out.println(studentRepository.insert(Student.builder()
                .firstName("Ali")
                .lastName("Moradi")
                .nationalCode("12")
                .build()));
        System.out.println(studentRepository.insert(Student.builder()
                .firstName("Reza")
                .lastName("Alizade")
                .nationalCode("13")
                .build()));
        System.out.println(studentRepository.findById(1L));
*/

       /* Optional<List<Student>> list = studentRepository.findAll();
        if (list.isPresent()) {
            for (Student student : list.get()) {
                System.out.println(student.getFirstName());
            }
        }*/

        //list.ifPresent(System.out::println);






        Optional<List<Student>> all = studentRepository.findAll();

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
            }
        }

    }

}
