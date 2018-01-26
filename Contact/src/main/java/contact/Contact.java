package contact;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Class contact
 * @author lenovo
 *
 */
@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min=2, max=30)
	private String firstName;
	
	@NotNull
	@Size(min=2, max=30)
	private String lastName;
	
	private String street;	
	private Integer postalCode;
	private String city;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthday;

	public Contact() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {		
		this.birthday =  birthday;
	}

	public Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street
				+ ", postalCode=" + postalCode + ", city=" + city + ", birthday=" + birthday + "]";
	}
}
