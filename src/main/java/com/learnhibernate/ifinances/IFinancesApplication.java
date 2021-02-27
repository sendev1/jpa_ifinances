package com.learnhibernate.ifinances;

import com.learnhibernate.ifinances.entities.Address;
import com.learnhibernate.ifinances.entities.Bank;
import com.learnhibernate.ifinances.entities.Credential;
import com.learnhibernate.ifinances.entities.User;
import com.learnhibernate.ifinances.repository.BankRepository;
import com.learnhibernate.ifinances.repository.CredentialRepository;
import com.learnhibernate.ifinances.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@SpringBootApplication
public class IFinancesApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final BankRepository bankRepository;
	private final CredentialRepository credentialRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public IFinancesApplication(UserRepository userRepository,
								BankRepository bankRepository,
								CredentialRepository credentialRepository) {
		this.userRepository = userRepository;
		this.bankRepository = bankRepository;
		this.credentialRepository = credentialRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(IFinancesApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//User user = createNewUser();
		//userRepository.save(user);

		/*Credential credential = createCredential();
		credential.setUser(user);
		credentialRepository.save(credential);*/

		//findCredential();
		findUser();


		/*Bank bank = createNewBank();
		bankRepository.save(bank);*/
	}

	private void findCredential() {

		List<Credential> credentials = credentialRepository.findByUserName("djoe");
		logger.info("Fetched credentials:"+ credentials);
		Optional<Credential> first = credentials.stream().findFirst();
		logger.info("User:{}", first.get().getUser());
	}

	private void findUser(){
		User user = userRepository.findById(1);
		logger.info("user:{}",user);
		logger.info("credentials: {}",user.getCredential() );
	}

	private Credential createCredential() {
		Credential credential = new Credential();
		credential.setUserName("djoe");
		credential.setPassword("123");
		return credential;
	}


	private Bank createNewBank() {

		Bank bank = new Bank();
		bank.setName("WELLS FARGO");
		bank.setCreatedBy("SYSTEM");
		bank.setLastUpdatedBy("SYSTEM");
		bank.setAddress(createAddress());
		bank.getContacts().add("Marie");
		bank.getContacts().add("John");

		return bank;
	}

	private User createNewUser() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		String dateInString = "7-Jun-2013";
		try {
			user.setBirthDate(formatter.parse(dateInString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setEmailAddress("nobody@gmail.com");
		user.setCreatedBy("SYSTEM");
		user.setLastUpdatedBy("SYSTEM");

		Address address = createAddress();
		user.setAddress(address);

		return user;
	}

	private Address createAddress() {
		Address address = new Address();
		address.setAddressLine1("13880 LOCAL DRIVE");
		address.setAddressLine2("APT 300");
		address.setCity("EDEN PRAIRIE");
		address.setZipCode("55344");
		address.setState("MN");
		return address;
	}


}
