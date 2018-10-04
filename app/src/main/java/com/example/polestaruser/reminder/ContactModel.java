package com.example.polestaruser.reminder;

import java.io.Serializable;

public class ContactModel implements Serializable {

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public String personName;
    public String personNumber;
}
