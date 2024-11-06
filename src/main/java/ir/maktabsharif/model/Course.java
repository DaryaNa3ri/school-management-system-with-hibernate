package ir.maktabsharif.model;

import com.sun.xml.bind.v2.model.core.ID;
import ir.maktabsharif.base.model.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString

@AllArgsConstructor
@SuperBuilder
@Table(name = "course")
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
