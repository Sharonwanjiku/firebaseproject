package com.example.emobilis.firebaseproject;

/**
 * Created by emobilis on 7/27/18.
 */

public class User {
    private String names,emails,ages;

    public User(String names, String emails, String ages) {
        this.names = names;
        this.emails = emails;
        this.ages = ages;
    }

    public User() {
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }
}
