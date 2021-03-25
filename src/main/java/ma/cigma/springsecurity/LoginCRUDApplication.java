package ma.cigma.springsecurity;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.cigma.springsecurity.domaine.ArtVo;
import ma.cigma.springsecurity.domaine.RoleVo;
import ma.cigma.springsecurity.domaine.UserVo;
import ma.cigma.springsecurity.service.IArtService;
import ma.cigma.springsecurity.service.IUserService;

@SpringBootApplication
public class LoginCRUDApplication implements CommandLineRunner {

	@Autowired
	private IUserService userService;
	@Autowired
	private IArtService artService;

	public static void main(String[] args) {
		SpringApplication.run(LoginCRUDApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	public void run(String... args) throws Exception {
		userService.cleanDataBase();
		userService.save(new RoleVo("ADMIN"));
		userService.save(new RoleVo("CLIENT"));

		RoleVo roleAdmin = userService.getRoleByName("ADMIN");
		RoleVo roleClient = userService.getRoleByName("CLIENT");
		UserVo admin1 = new UserVo("admin1", "admin1", Arrays.asList(roleAdmin));
		UserVo client1 = new UserVo("client1", "client1", Arrays.asList(roleClient));
		userService.save(admin1);
		userService.save(client1);

		// *************
		artService.save(new ArtVo("ref1", "Fonction1" , 15d));
		artService.save(new ArtVo("ref2", "Fonction2" , 15d));
		artService.save(new ArtVo("ref3", "Fonction3" , 15d));
		artService.save(new ArtVo("ref4", "Fonction4" , 15d));
		artService.save(new ArtVo("ref5", "Fonction5" , 15d));
		artService.save(new ArtVo("ref6", "Fonction6" , 15d));

	}

}
