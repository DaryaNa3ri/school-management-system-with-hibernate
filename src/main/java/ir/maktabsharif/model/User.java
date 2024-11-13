package ir.maktabsharif.model;

import ir.maktabsharif.model.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@Table(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@PrimaryKeyJoinColumn(name = "id" ,referencedColumnName = "id")
public class User extends BaseEntity<Long> {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_code",unique = true)
    private String nationalCode;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;
}
