package ir.maktabsharif.model;

import ir.maktabsharif.model.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@SuperBuilder
@Table(name = "courses")
public class Course extends BaseEntity<Long> {

    @Column(name = "course_title")
    private String title;

    @Column(name = "course_unit")
    private Integer unit;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Exam> exams = new ArrayList<>();

}
