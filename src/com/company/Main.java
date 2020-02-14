package com.company;

import com.company.justForTest.MapperImp;
import com.company.justForTest.PersonDto;

public class Main {

    public static void main(String[] args) {
        PersonDto person=new PersonDto();
        person.setName22("amir");
        person.setFamily("fooladi");
        person.setFatherNAme("akbar");
        person.setPhone("44657612");
        long before =System.currentTimeMillis();
        MapperImp.Mapper(person, com.company.justForTest.person.class);
//        MapperImp.mapperHandy(person);
        long after=System.currentTimeMillis();
        System.out.println(after-before);
//        MyFrame frame=new MyFrame();
//        frame.setVisible(true);
//        frame.setSize(1350,900);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLocation(250,75);
    }
}
