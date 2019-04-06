package TP.company;

import java.util.ArrayList;

public class Staff {
    private String name;
    private String surname;
    private int salary;

    public Staff(String name, String surname, int salary) {

        this.name = name;
        this.surname = surname;
        this.salary = salary;

    }
    public String detail(){

        return this.name+" "+this.surname+" "+this.salary;

    }

    public String fullname(){
        return  name.toUpperCase().substring(0,1)+name.toLowerCase().substring(1)
                +" "+
                surname.toUpperCase().substring(0,1)+surname.toLowerCase().substring(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
