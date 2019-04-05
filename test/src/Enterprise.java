import java.util.ArrayList;

public class Enterprise {
    private ArrayList<Service> serviceList = new ArrayList<>();

    public Enterprise(){

    }

    public ArrayList<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(ArrayList<Service> serviceList) {
        this.serviceList = serviceList;
    }


    public int sumSalary(){

        int amoutTotal = 0;

        for(int i=0; i < serviceList.size();i++) {

            Service tempService = serviceList.get(i);

            amoutTotal += tempService.sumTotal();


        }
        return amoutTotal;
    }
    public int sumAverage(){
        int amoutTotal = 0;
        int amoutAverage= 0;
        for(int i=0; i < serviceList.size();i++) {

            Service tempService = serviceList.get(i);

            for(int j=0; j < tempService.getStaffList().size();j++){

                Staff tempStaff = tempService.getStaffList().get(j);

                amoutTotal += tempStaff.getSalary();
                amoutAverage = amoutTotal / tempService.getStaffList().size();

            }

        }
        return amoutAverage;
    }
}
