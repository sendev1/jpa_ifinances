package com.learnhibernate.ifinances;

import com.learnhibernate.ifinances.entities.*;
import com.learnhibernate.ifinances.repository.AccountRepository;
import com.learnhibernate.ifinances.repository.BankRepository;
import com.learnhibernate.ifinances.repository.CredentialRepository;
import com.learnhibernate.ifinances.repository.UserRepository;
import com.learnhibernate.ifinances.util.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class IFinancesApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final BankRepository bankRepository;
	private final CredentialRepository credentialRepository;
	private final AccountRepository accountRepository;
	private final EntityManager entityManager;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public IFinancesApplication(UserRepository userRepository,
								BankRepository bankRepository,
								CredentialRepository credentialRepository, AccountRepository accountRepository, EntityManager entityManager) {
		this.userRepository = userRepository;
		this.bankRepository = bankRepository;
		this.credentialRepository = credentialRepository;
		this.accountRepository = accountRepository;
		this.entityManager = entityManager;
	}

	public static void main(String[] args) {
		SpringApplication.run(IFinancesApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//User user = Helper.createNewUser();
		//userRepository.save(user);

		/*Credential credential = Helper.createCredential();
		credential.setUser(user);
		credentialRepository.save(credential);*/
		//user.setCredential(credential);

		//findCredential();
		//findUser();

		/*Bank bank = Helper.createNewBank();
		bankRepository.save(bank);*/

		/*Bank bank = findBank();
		Account account = Helper.createNewAccount(bank);
		Transaction beltTransaction = Helper.createBeltTransaction(account);
		Transaction shoeTransaction = Helper.createShoeTransaction(account);
		account.getTransactions().add(beltTransaction);
		account.getTransactions().add(shoeTransaction);
		Budget budget = Helper.createNewBudget(account.getTransactions());
		entityManager.persist(budget);*/
		//accountRepository.save(account);
		//entityManager.persist(beltTransaction);

		/*Transaction transaction = entityManager.find(Transaction.class, account.getTransactions().get(0).getTransactionId());
		logger.info("Fetched account type:{}", transaction.getAccount().getAccountType());*/
		//Budget budget1 = entityManager.find(Budget.class, budget.getBudgetId());
		//logger.info("Fetched account type:{}", budget1.getTransactions().get(0).getAccount().getAccountType());

		// Testing Many to Many
		Bank bank = findBank();
		Account account = Helper.createNewAccount(bank);
		Account account2 = Helper.createNewAccount(bank);
		User user = Helper.createNewUser();
		User user2 = Helper.createNewUser();
		account.getUsers().add(user);
		account2.getUsers().add(user);
		account.getUsers().add(user2);
		account2.getUsers().add(user2);

		// Managing both side of relationship
		user.getAccounts().add(account);
		user2.getAccounts().add(account);
		user2.getAccounts().add(account2);
		user.getAccounts().add(account2);

		accountRepository.save(account);
		accountRepository.save(account2);


	}

	private void findCredential() {

		List<Credential> credentials = credentialRepository.findByUserName("djoe");
		logger.info("Fetched credentials:" + credentials);
		Optional<Credential> first = credentials.stream().findFirst();
		logger.info("User:{}", first.get().getUser());
	}

	private void findUser() {
		User user = userRepository.findById(1);
		logger.info("user:{}", user);
		logger.info("credentials: {}", user.getCredential());
	}

	private Bank findBank(){
		return bankRepository.findById(1);
	}
}
