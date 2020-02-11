package com.company;

import com.company.justForTest.MapperImp;
import com.company.justForTest.PersonDto;

public class Main {

    public static void main(String[] args) {
        PersonDto person=new PersonDto();
        person.setName22("amir");
        person.setFamily("fooladi");

        MapperImp.Mapper(person, com.company.justForTest.person.class);
//        MyFrame frame=new MyFrame();
//        frame.setVisible(true);
//        frame.setSize(1350,900);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLocation(250,75);
    }
}
