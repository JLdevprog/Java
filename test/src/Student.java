public class Student {

    String name;
    String nameF;
    int age;


    public Student(String name, String nameF){
        this.name=name;
        this.nameF=nameF;


    }
    public Student(){
        this.name="name";
        this.nameF="famillyName";


    }

    public String fullname(){
        return  name.toUpperCase().substring(0,1)+name.toLowerCase().substring(1)
                +" "+
                nameF.toUpperCase().substring(0,1)+nameF.toLowerCase().substring(1);
    }
}
