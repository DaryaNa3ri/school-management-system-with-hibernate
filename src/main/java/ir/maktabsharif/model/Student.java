package ir.maktabsharif.model;

import com.sun.xml.bind.v2.model.core.ID;
import ir.maktabsharif.base.model.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(name = "student")
public class Student extends BaseEntity<Long> {


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_code",unique = true)
    private String nationalCode;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private Double gpu;

    @ManyToMany
    @JoinTable(
            name = "j_student_course",
            joinColumns = {@JoinColumn(name = "fk_student")},
            inverseJoinColumns = {@JoinColumn(name = "fk_course")}
    )
    private List<Course> courses = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "j_student_teacher",
            joinColumns = {@JoinColumn(name = "fk_student")},
            inverseJoinColumns = {@JoinColumn(name = "fk_teacher")}
    )
    private List<Teacher> teachers = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "j_student_exam",
            joinColumns = {@JoinColumn(name = "fk_student")},
            inverseJoinColumns = {@JoinColumn(name = "fk_exam")}
    )
    private List<Exam> exams = new ArrayList<>();
}
