package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
public class Address {
    private String country;
    private String city;
    private String street;
    private String zipCode;
}
