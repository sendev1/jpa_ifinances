package com.learnhibernate.ifinances.util;

import com.learnhibernate.ifinances.entities.*;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Helper {

    public static Credential createCredential() {
        Credential credential = new Credential();
        credential.setUserName("djoe");
        credential.setPassword("123");
        return credential;
    }


    public static Bank createNewBank() {

        Bank bank = new Bank();
        bank.setName("WELLS FARGO");
        bank.setCreatedBy("SYSTEM");
        bank.setLastUpdatedBy("SYSTEM");
        bank.setAddress(createAddress());
        bank.getContacts().add("Marie");
        bank.getContacts().add("John");

        return bank;
    }

    public static User createNewUser() {
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

    public static Address createAddress() {
        Address address = new Address();
        address.setAddressLine1("13880 LOCAL DRIVE");
        address.setAddressLine2("APT 300");
        address.setCity("EDEN PRAIRIE");
        address.setZipCode("55344");
        address.setState("MN");
        return address;
    }

    public static Account createNewAccount(Bank bank){
        Account account = new Account();
        account.setAccountType("Savings");
        account.setBank(bank);
        account.setOpenDate(new Date());
        account.setCloseDate(new Date());
        account.setCreatedBy("SYSTEM");
        account.setCurrentBalance(1200.00);
        account.setInitialBalance(1200.00);
        account.setLastUpdatedBy("SYSTEM");
        account.setName("MY SAVINGS ACCOUNT");
        account.setCloseDate(new Date());
        return account;
    }

    public static Transaction createBeltTransaction(Account account){
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(100.00);
        transaction.setClosingBalance(1100.00);
        transaction.setCreatedBy("SYSTEM");
        transaction.setLastUpdatedBy("SYSTEM");
        transaction.setInitialBalance(1200.00);
        transaction.setNotes("Nice Belt");
        transaction.setTitle("Belt");
        transaction.setTransactionType("Withdrawl");
        return transaction;
    }

    public static Transaction createShoeTransaction(Account account){
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(100.00);
        transaction.setClosingBalance(1000.00);
        transaction.setCreatedBy("SYSTEM");
        transaction.setLastUpdatedBy("SYSTEM");
        transaction.setInitialBalance(1100.00);
        transaction.setNotes("Nice Shoe");
        transaction.setTitle("Shoe");
        transaction.setTransactionType("Withdrawl");
        return transaction;
    }
}
