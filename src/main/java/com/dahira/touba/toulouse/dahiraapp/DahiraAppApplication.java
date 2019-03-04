package com.dahira.touba.toulouse.dahiraapp;

import com.dahira.touba.toulouse.dahiraapp.Utils.AppUserForm;
import com.dahira.touba.toulouse.dahiraapp.metier.AppRole;
import com.dahira.touba.toulouse.dahiraapp.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class DahiraAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DahiraAppApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AccountService accountService){
		return  args -> {
			accountService.saveRole(new AppRole(null, "USER"));
			accountService.saveRole(new AppRole(null, "ADMIN"));
			/*Stream.of("user1", "user2", "user3", "admin").forEach(un->{
				accountService.saveUser(un, "1234", "1234");
			});*/
			accountService.saveUser(new AppUserForm("admin","admin", "Homme", "05 050 50","Toulouse", "admin@gmail.com","admin", "admin"));
			accountService.addRoleToUser("admin@gmail.com", "ADMIN");
		};
	}
	@Bean
	BCryptPasswordEncoder getBCPE(){
		return  new BCryptPasswordEncoder();
	}
}

