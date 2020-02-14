package com.company.justForTest;

import java.util.List;

public class person {

    private int id;
    private String name;
    private String family;
    private String nationalCode;
    private List<String> contacts;
    private String phone;
    private String address;
    private String fatherNAme;

    public List<String> getContacts() {
        return contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFatherNAme() {
        return fatherNAme;
    }

    public void setFatherNAme(String fatherNAme) {
        this.fatherNAme = fatherNAme;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "name : " + name + " family : " + family + " nationalCode: " + nationalCode;
    }
}
