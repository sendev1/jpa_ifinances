package com.learnhibernate.ifinances.util;

import com.learnhibernate.ifinances.entities.Address;
import com.learnhibernate.ifinances.entities.Bank;
import com.learnhibernate.ifinances.entities.Credential;
import com.learnhibernate.ifinances.entities.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
