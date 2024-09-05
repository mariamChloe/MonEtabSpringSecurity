package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
//Generation de table partagée table
@Inheritance(strategy = InheritanceType.JOINED)
//Generation d'une seule table
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
@Table(name = "Person")
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname",nullable = false)
    private String nom;

    @Column(name = "lastname",nullable = false)
    private String prenom;

    @Column(name = "tel",nullable = false)
    private String telephone;

    @Column(name = "city",nullable = false)
    private String ville;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "genre",nullable = false)
    private String genre;

    @OneToOne(mappedBy = "person")
    private Student student;

    @OneToOne(mappedBy = "person")
    private Teacher teacher;
}
