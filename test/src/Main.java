import TP.company.Driver;
import TP.company.Enterprise;
import TP.company.Service;
import TP.company.Staff;

public class Main {

    public static void main(String[] args) {
        //new JavaTest();

        Enterprise jlW = new Enterprise();

        Service web = new Service("JL web");
        Service dev = new Service("JL dev");

        Staff johnL = new Staff("John", "Le",2500);
        Staff franckI = new Staff("Franck", "Ins",5000);
        Staff herveP = new Staff("Herve", "Pad",10000);


        jlW.getServiceList().add(web);
        jlW.getServiceList().add(dev);

        web.getStaffList().add(johnL);
        web.getStaffList().add(franckI);

        dev.getStaffList().add(johnL);
        dev.getStaffList().add(herveP);

        System.out.println(jlW.getServiceList().size());
        //System.out.println(jlDp.serviceList.size());

        System.out.println("Company jlW TP.company.Service:");
        System.out.println(jlW.getServiceList());
        System.out.println("Web TP.company.Staff List:");
        System.out.println(web.getName());
        System.out.println("Dev TP.company.Staff List:");
        System.out.println(dev.getStaffList());
        System.out.println(johnL.detail());
        System.out.println(johnL.fullname());
        System.out.println(johnL.getSalary());
        System.out.println("Average Salary");
        System.out.println(web.getStaffList());

        System.out.println("jlW Salary Total Pay:");
        System.out.println(jlW.sumSalary());
        System.out.println("jlW Salary Average :");
        System.out.println(jlW.sumAverage());
        System.out.println("jlW Web TP.company.Service Salary Pay :");
        System.out.println(web.sumTotal());
        System.out.println("jlW Dev TP.company.Service Salary Pay :");
        System.out.println(dev.sumTotal());
        System.out.println("jlW Web TP.company.Service Salary Average :");
        System.out.println(web.sumAverage());
        System.out.println("jlW Dev TP.company.Service Salary Average :");
        System.out.println(dev.sumAverage());


        Driver Toto = new Driver("A","Toto","Titi",2000);

        System.out.println(Toto.getName()+Toto.getSurname()+Toto.getSalary()+Toto.license);

    }
}
