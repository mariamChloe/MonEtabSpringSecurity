package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="fichenote")
public class FicheNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note",nullable = false)
    private String note;

    @Column(name = "annee",nullable = false)
    private Instant annee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="teacher_id")
    private Teacher teacher;

    @Override
    public String toString() {
        return "FicheNote{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", annee=" + annee +
                ", teacher=" + teacher +
                '}';
    }
}
