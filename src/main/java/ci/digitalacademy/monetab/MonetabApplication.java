package ci.digitalacademy.monetab;

import ci.digitalacademy.monetab.services.*;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Instant;

@SpringBootApplication
public class MonetabApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private AdresseService adresseService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private FicheService ficheService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public MonetabApplication(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(MonetabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String Password = bCryptPasswordEncoder.encode("admin");

		UserDTO user = new UserDTO();
		user.setPseudo("admin");
		user.setPassword(Password);
		user.setCreationdate(Instant.now());
		userService.save(user);

		String Password2 = bCryptPasswordEncoder.encode("user");


		UserDTO user1 = new UserDTO();
		user.setPseudo("user");
		user.setPassword(Password2);
		user.setCreationdate(Instant.now());
		userService.save(user);






	}
}
