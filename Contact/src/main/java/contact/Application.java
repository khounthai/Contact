package contact;

import java.time.LocalDate;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import contact.Contact;
import contact.ContactRepository;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
	        SpringApplication.run(Application.class);
	    }
	
	@Bean
	public CommandLineRunner demo(ContactRepository repository) {
		return (args) -> {
			log.info("Crée un jeux d'essai de contacts :");
		
			Contact c= new Contact("firstName1", "lastName1");
			c.setBirthday(LocalDate.of(1972, 3, 21));
			repository.save(c);
			
			c = new Contact("firstName3", "lastName3");
			c.setBirthday(LocalDate.of(1983, 5, 2));
			repository.save(c);
			c = new Contact("firstName2", "lastName2");
			c.setBirthday(LocalDate.of(1980, 4, 3));
			repository.save(c);
			c = new Contact("firstName8", "lastName8");
			c.setBirthday(LocalDate.of(2015, 3, 16));
			repository.save(c);
			c = new Contact("firstName5", "lastName5");
			c.setBirthday(LocalDate.of(1989, 6, 4));
			repository.save(c);
			c = new Contact("firstName6", "lastName6");
			c.setBirthday(LocalDate.of(1995, 9, 30));
			repository.save(c);
			c = new Contact("firstName4", "lastName4");
			c.setBirthday(LocalDate.of(1986, 1, 2));
			repository.save(c);
			c = new Contact("firstName7", "lastName7");
			c.setBirthday(LocalDate.of(2006, 12, 8));
			repository.save(c);	
					
			log.info("");
		};
	}	
}
