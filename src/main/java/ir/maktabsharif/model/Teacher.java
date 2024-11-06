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

@SuperBuilder
@Table(name = "teacher")
public class Teacher extends BaseEntity<Long>{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_code")
    private String nationalCode;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date dob;

    @OneToOne
    @JoinColumn(name = "fk_course")
    private Course course;

    @ManyToMany(mappedBy = "teachers")
    private List<Student> students = new ArrayList<>();

}
