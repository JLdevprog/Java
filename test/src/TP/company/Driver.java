package TP.company;

public class Driver extends Staff{

    private String license;

    public Driver (String license,String name, String surname, int salary)
    {
        super(name,surname,salary);
        this.license = license;

        System.out.println(license);
    }
    public String getLicense() {
        return license;
    }

    public void printDetails() {
        super.setName(name);
    }
}
