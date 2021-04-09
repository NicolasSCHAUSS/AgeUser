package web.atrio.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import web.atrio.thymeleaf.controller.UserController;
import web.atrio.thymeleaf.model.User;

@SpringBootApplication
public class ThymeleafApplication implements CommandLineRunner{

	@Autowired
	private UserController userCrtl;
	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//Init H2 dataBase & thymeleaf attribute (users) with userCtrl bean
		userCrtl.addUser(new User("Bill", "Gates", "1955-10-28"));
		userCrtl.addUser(new User("Steve", "Jobs", "1955-02-24"));
	}


	
}
