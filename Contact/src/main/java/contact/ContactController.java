package contact;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class ContactController extends WebMvcConfigurerAdapter{
	@Autowired
	ContactRepository repository;
	
	
	@RequestMapping("/")
	public String contacts( Model model) {
		System.out.println("afficher la liste");
		List<Contact> liste=(List<Contact>) repository.findAll();
		System.out.println("liste: "+liste.size());
		model.addAttribute("liste",liste);
		return "contacts";
	}
	
	@GetMapping("/ajouter-un-contact")
	public String ajoutercontact(Model model){
		model.addAttribute("contact",new Contact());
		return "contactform";
	}

	@PostMapping("/enregistrer-un-contact")
	public String checkContactInfo(@Valid Contact contact,BindingResult bindingResult,HttpServletResponse response) {
		
		if (bindingResult.hasErrors()) {
			return "contactform";
		}
			
		repository.save(contact);
		
		return "redirect:/";
	}
	
	@GetMapping("/fiche-contact/{id}")
	public String afficherContact(Model model,@PathVariable("id") Long id){
		System.out.println("id="+id);
		Contact c=repository.findOne(id);
		
		if (c==null)
			return "redirect:/";
		else
			model.addAttribute("contact", c);
		
		return "contactform";
	}
	
	
	
}
