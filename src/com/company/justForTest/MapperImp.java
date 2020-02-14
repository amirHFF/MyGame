package com.company.justForTest;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class MapperImp {

    public static Object Mapper(Object source, Class C) {
        Object destination = null;

        try {
            destination = C.newInstance();
            Object finalDestination = destination;
            Arrays.stream(C.getDeclaredFields())
                    .forEach(destinationField -> {
                        destinationField.setAccessible(true);
                        Arrays.stream(source.getClass().getDeclaredFields())
                                .forEach(sourceField -> {
                                    sourceField.setAccessible(true);
                                    if (sourceField.getName().equals(destinationField.getName())) {
                                        try {
                                            System.out.println(11);
                                            destinationField.set(finalDestination, sourceField.get(source));
                                        } catch (IllegalAccessException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (sourceField.isAnnotationPresent(Mapper.class)
                                            &&
                                            sourceField.getAnnotation(Mapper.class).value().equals(destinationField.getName())
                                    ) {
                                        System.out.println(sourceField.getName());

                                        try {
                                            destinationField.set(finalDestination, sourceField.get(source));
                                        } catch (IllegalAccessException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                });
                    });


        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("dest : " + destination.toString());
        System.out.println("source :" + source.toString());
        return null;
    }

    public static person mapperHandy(PersonDto dto) {
        person p = new person();
        p.setName(dto.getName22());
        p.setFamily(dto.getFamily());
        p.setAddress(dto.getAddress());
//        p.setContacts(dto.getContacts());
        p.setFatherNAme(dto.getFatherNAme());
        p.setNationalCode(dto.getNationalCode());
        p.setId(dto.getId());
        p.setPhone(dto.getPhone());
        System.out.println("dest : " + p.toString());
        System.out.println("source :" + dto.toString());
        return p;
    }

    public static Object classicMapper(Object source, Class C) {
        Object finalDestination = null;
        try {
            finalDestination = C.newInstance();
            Field[] sourceFields = source.getClass().getDeclaredFields();
            Field[] destinationField = C.getDeclaredFields();
            for (int i = 0; i < sourceFields.length; i++) {
                sourceFields[i].setAccessible(true);
                for (int j = 0; j < destinationField.length; j++) {
                    destinationField[j].setAccessible(true);
                    if (sourceFields[i].getName().equals(destinationField[j].getName())) {
                        System.out.println("11");
                        try {
                            destinationField[j].set(finalDestination, sourceFields[i].get(source));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    if (sourceFields[i].isAnnotationPresent(Mapper.class)
                            &&
                            sourceFields[i].getAnnotation(Mapper.class).value().equals(destinationField[j].getName())
                    ) {
                        System.out.println(sourceFields[i].getName());

                        try {
                            destinationField[j].set(finalDestination, sourceFields[i].get(source));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
            System.out.println("dest : " + finalDestination.toString());
            System.out.println("source :" + source.toString());

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return finalDestination;
    }
}
