package com.company.justForTest;

import java.util.List;

public class PersonDto {

    private int id;
    @Mapper(value = "name")
    private String name22;

    private String family;


    private String nationalCode;
    private List<String> contacts;

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName22() {
        return name22;
    }

    public void setName22(String name22) {
        this.name22 = name22;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Override
    public String toString() {
        return "name22 : " + name22 + " family : " + family + "nationalCode: " + nationalCode;
    }
}
