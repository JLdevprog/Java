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

        System.out.println("Company jlW Service:");
        System.out.println(jlW.getServiceList());
        System.out.println("Web Staff List:");
        System.out.println(web.getName());
        System.out.println("Dev Staff List:");
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
        System.out.println("jlW Web Service Salary Pay :");
        System.out.println(web.sumTotal());
        System.out.println("jlW Dev Service Salary Pay :");
        System.out.println(dev.sumTotal());
        System.out.println("jlW Web Service Salary Average :");
        System.out.println(web.sumAverage());
        System.out.println("jlW Dev Service Salary Average :");
        System.out.println(dev.sumAverage());

    }
}
