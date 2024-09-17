package ci.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
//Generation d'une seule table
@DiscriminatorValue(value = "student")
public class Student extends Person {


    @Column(name = "matricule",unique = true,nullable = false)
    private String matricule;

    @Column(name= "phone_number_father")
    private String phone_number_father;

    @OneToMany(fetch = FetchType.EAGER, mappedBy ="student")
    private Set<Absence> absences;

    @OneToOne
    private StudentCards studentCards;

    @OneToOne
    private Person person;



    private Integer calculateAge(LocalDate birthday) {
        if (birthday == null) {
            return null;
        }
        return Period.between(birthday, LocalDate.now()).getYears();
    }


}
