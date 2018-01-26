package contact;

import java.time.LocalDate;

public class ContactForm {
		private String firstName;
		private String lastName;		
		private String street;	
		private Integer postalCode;
		private String city;
		private LocalDate birthday;

		public ContactForm() {
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
			this.birthday = birthday;
		}

		public String getStringBirthday() {
			return DateUtil.format(this.birthday);
		}

		public ContactForm(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}


		@Override
		public String toString() {
			return "ContactForm [firstName=" + firstName + ", lastName=" + lastName + ", street=" + street
					+ ", postalCode=" + postalCode + ", city=" + city + ", birthday=" + birthday + "]";
		}
}
