package com.company;

public class Human {
    public int age;
    public String firstName;
    public String lastName;
    public String birthDay;

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public int getWeight() {
        return weight;
    }

    public int weight;

    Human(int age, String firstName, String lastName, String birthDay, int weight){
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.weight = weight;
    }
    public int sorted(){
        return age + weight;
    }

    public void print(){
        System.out.println(this.firstName + " " + this.lastName);
    }

    public void print_name(){
        System.out.print(this.firstName);
    }
}
