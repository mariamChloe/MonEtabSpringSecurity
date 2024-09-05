package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "student_cards")
public class StudentCards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference")
    private Date reference;

    @Column(name = "issue_date")
    private Date issue_date;

    @Column(name = "expiration_number")
    private Date expiration_dater;

    @OneToOne(mappedBy = "studentCards")
    private Student student;


}
