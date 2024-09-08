package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pseudo",unique = true,nullable = false)
    private String pseudo;

    @Column(name ="password",nullable = false)
    private String password;

    @Column(name = "creationdate",nullable = false)
    private Instant creationdate;
    @Column(name= "status",nullable=true)
    private String status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy ="user")
    private Set<RoleUser> roleUsers;

    @OneToMany(fetch = FetchType.EAGER, mappedBy ="user")
    private Set<Address> addresses;

    @ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @JoinColumn(name ="school_id")
    private School school;

}
