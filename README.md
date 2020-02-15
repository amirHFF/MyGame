# MyGame

package com.MyMapper.common;

import com.MyMapper.model.Person;
import com.MyMapper.model.PersonDTO;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MapperUtil {

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
                                    if (sourceField.getName().equals(destinationField.getName())&& sourceField.getAnnotation(Mapper.class)==null) {
                                        if (sourceField.getType()!= List.class && sourceField.getType()!= Set.class && sourceField.getType().getName()!=null) {
                                            try {
                                                destinationField.set(finalDestination, sourceField.get(source));
                                            } catch (IllegalAccessException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        else {
                                            ParameterizedType type= (ParameterizedType) sourceField.getGenericType();
                                            try {
                                                Mapper(sourceField.get(source),type.getActualTypeArguments().getClass());
                                            } catch (IllegalAccessException e) {
                                                e.printStackTrace();
                                            }
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
                                    if (sourceField.isAnnotationPresent(Mapper.class) && sourceField.getAnnotation(Mapper.class).value()!=null){
                                        System.out.println(sourceField.getName());
                                        try {
                                            Mapper(sourceField.get(source),sourceField.getAnnotation(Mapper.class).type());
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

    public static Person mapperHandy(PersonDTO dto) {
        Person p = new Person();
        p.setName(dto.getName22());
        p.setFamily(dto.getFamily());
        p.setAddress(dto.getAddress());
//        p.setContacts(dto.getContacts());
        p.setFatherName(dto.getFatherName());
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
