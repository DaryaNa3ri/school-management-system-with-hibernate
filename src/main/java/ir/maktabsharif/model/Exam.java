package ir.maktabsharif.model;

import ir.maktabsharif.model.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@Table(name = "exams")
public class Exam extends BaseEntity<Long> {

    @Column(name = "exam_title")
    private String title;

    @Column(name = "exam_unit")
    private Integer unit;

    @Temporal(TemporalType.DATE)
    @Column(name = "exam_date")
    private Date date;

    @Column(name = "total_grade")
    private Double totalGrade;

    @ManyToOne
    @JoinColumn(name = "fk_course")
    private Course course;

    @ManyToMany(mappedBy = "exams")
    private List<Student> students = new ArrayList<>();


}
