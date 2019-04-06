package TP.company;

import java.util.ArrayList;

public class Service {
    private String name;
    private ArrayList<Staff> staffList = new ArrayList<>();

    public Service(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }

    public int sumTotal(){
        int amoutTotal = 0;

        for(int i=0; i < staffList.size();i++){

            Staff tempStaff = staffList.get(i);

            amoutTotal += tempStaff.getSalary();

        }

        return amoutTotal;
    }
    public int sumAverage(){
        int amoutTotal = 0;
        int amoutAverage= 0;
        for(int i=0; i < staffList.size();i++) {

            Staff tempService = staffList.get(i);
            Staff tempStaff = staffList.get(i);

            amoutTotal += tempStaff.getSalary();
            amoutAverage = amoutTotal / staffList.size();

        }
        return amoutAverage;
    }
    
}
