package contact;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Class controller
 * @author lenovo
 *
 */
@Controller
public class ContactController extends WebMvcConfigurerAdapter{
	@Autowired
	ContactRepository repository;
	
	/**
	 * Redirection vers la page principale: affiche la liste des contacts
	 * @param model
	 * @return String
	 */
	@RequestMapping("/")
	public String contacts( Model model) {	
		List<Contact> liste=(List<Contact>) repository.findAll();	
		model.addAttribute("liste",liste);
		return "contacts";
	}
	
	/**
	 * Redirection vers le formulaire d'ajout d'un contact
	 * @param model
	 * @return String
	 */
	@GetMapping("/ajouter-un-contact")
	public String ajoutercontact(Model model){
		model.addAttribute("contact",new Contact());
		return "contactform";
	}

	/**
	 * Redirection vers l'enregistrement d'un nouveau contact 
	 * ou une modification d'un contact
	 * @param contact
	 * @param bindingResult
	 * @return String
	 */
	@PostMapping("/enregistrer-un-contact")
	public String checkContactInfo(@Valid Contact contact,BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "contactform";
		}
		
		repository.save(contact);
		
		return "redirect:/";
	}
	
	/**
	 * Redirection vers le formulaire d'un contact existant 
	 * ou une modification d'un contact
	 * @param contact
	 * @param bindingResult
	 * @return String
	 */
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
	
	/**
	 * Redirection vers la suppression d'un contact
	 * @param contact
	 * @param bindingResult
	 * @return String
	 */
	@GetMapping("/supprimer-contact/{id}")
	public String supprimerContact(Model model,@PathVariable("id") Long id){
		System.out.println("id="+id);
		Contact c=repository.findOne(id);
		
		if (c==null)
			return "contactform";
		else
		{
			repository.delete(c);
		}	
		
		return "redirect:/";
	}
}
