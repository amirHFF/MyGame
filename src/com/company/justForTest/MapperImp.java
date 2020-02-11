package com.company.justForTest;

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
                                            destinationField.set(finalDestination, sourceField.get(source));
                                        } catch (IllegalAccessException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    if (sourceField.isAnnotationPresent(Mapper.class)
                                            &&
                                            sourceField.getAnnotation(Mapper.class).value().equals(destinationField.getName())
                                    ){System.out.println(sourceField.getName());

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
}
