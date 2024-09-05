package ci.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="appsetting")
@ToString
public class AppSetting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "smtp_Server")
    private String smtpServer;

    @Column(name = "smtp_port")
    private  Integer smtpPort ;

    @Column(name = "smtpUserName")
    private String smtpUserName;

    @Column(name = "smtpPassword")
    private String smtpPassword;

    @OneToOne(mappedBy = "appSetting")
    private School school;


}
