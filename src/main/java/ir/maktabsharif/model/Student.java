package ir.maktabsharif.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
//@NamedQuery(name = "Student.findByFirstName",query = "FROM Student WHERE firstName = ?1")
@Table(name = "students")
public class Student extends User{

    private Double gpu;

    @ManyToMany
    @JoinTable(
            name = "j_student_course",
            joinColumns = {@JoinColumn(name = "fk_student")},
            inverseJoinColumns = {@JoinColumn(name = "fk_course")}
    )
    private final List<Course> courses = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "j_student_teacher",
            joinColumns = {@JoinColumn(name = "fk_student")},
            inverseJoinColumns = {@JoinColumn(name = "fk_teacher")}
    )
    private final List<Teacher> teachers = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "j_student_exam",
            joinColumns = {@JoinColumn(name = "fk_student")},
            inverseJoinColumns = {@JoinColumn(name = "fk_exam")}
    )
    private final List<Exam> exams = new ArrayList<>();
}
