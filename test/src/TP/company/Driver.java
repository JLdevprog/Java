package TP.company;

public class Driver extends Staff{

    public String license;

    public Driver (String license,String name, String surname, int salary)
    {
        super(name,surname,salary);
        this.license = license;

        System.out.println(license);
    }

}
