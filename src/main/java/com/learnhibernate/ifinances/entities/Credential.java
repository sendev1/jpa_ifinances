package com.learnhibernate.ifinances.entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "find_by_userName", query = "select c from Credential c where userName=:userName")
})
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int credentialId;

    @Column(name = "USERNAME")
    private String userName;

    @Column
    private String password;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Credential() {
    }

    public int getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(int credentialId) {
        this.credentialId = credentialId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "credentialId=" + credentialId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", user=" + user +
                '}';
    }
}
