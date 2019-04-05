
public class JavaTest {

    public JavaTest(){

        System.out.println("Java Method");

        String myFirstChain = "myChain";
        String mySecondChain = "my Second Chain";

        //fromTo(1900 , 2020);

        leapYear(2019);

        //multiplier(3 , 5);


        Student myStudent= new Student();

        System.out.println(myStudent.fullname());

        Promo classPromo = new Promo();

    }



    public void leapYear(int theYear) {

        if ( (theYear % 4 == 0 && theYear % 100 != 0) || theYear % 400 == 0) {
            System.out.println(theYear);
            System.out.println("It's a Leap Year?!");
        } else {
            System.out.println(theYear);
            System.out.println("Isn't a Leap Year...");
        }
    }

    public void fromTo(int start, int end){
        for(int i = start; i <=end; i++){

            leapYear(i);

        }
    }
/*
    public void multiplier(int amount , int number) {

        for(int i = 0; total <=100; i++){

            int total;

            total=amount*number;

            System.out.println(total);

        }

    }
    */

    public class Student {

        String name;
        String nameF;
        int age;


        public Student(String name, String nameF) {
            this.name = name;
            this.nameF = nameF;


        }

        public Student() {
            this.name = "name";
            this.nameF = "famillyName";


        }

        public String fullname() {
            return name.toUpperCase().substring(0, 1) + name.toLowerCase().substring(1)
                    + " " +
                    nameF.toUpperCase().substring(0, 1) + nameF.toLowerCase().substring(1);
        }



    }
    public class employe{
        String nameF;
        String nameS;
        int salary;

        public employe(String nameF, String nameS, int salary) {
            this.nameF = nameF;
            this.nameS = nameS;
            this.salary = salary;
        }
    }
    public class service{
        String staffList;


        public service(String nameF, String nameS, int salary) {
        }
    }
    public class enterprise{
        int salarySum;
        int salaryAverage;

        public enterprise(String nameF, String nameS, int salary) {
        }
    }

    /*
    public static void Main(String)[] args{
    }
    */

}