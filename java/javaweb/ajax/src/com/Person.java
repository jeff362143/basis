package com;

import com.google.gson.Gson;

public class Person {

    private int id;
    private String name;
    public Person(int n,String str) {
        this.id = n ;
        this.name = str ;
    }

    public static void main(String[] args) {
        String str =  "{\"id\":1,\"name\" : \"jeff\"}";
        System.out.println(str);
        Gson gson = new Gson();
        Person test = gson.fromJson(str,Person.class);
        System.out.println(test.id+" "+ test.name);
    }
}
