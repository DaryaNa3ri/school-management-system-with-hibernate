package ir.maktabsharif.model;

import ir.maktabsharif.model.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Table(name = "teachers")
public class Teacher extends User{


    @OneToOne
    @JoinColumn(name = "fk_course")
    private Course course;

    @ManyToMany(mappedBy = "teachers")
    private List<Student> students = new ArrayList<>();

}
