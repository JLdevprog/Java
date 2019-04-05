import java.util.ArrayList;

public class Promo {

        ArrayList<Student> st = new ArrayList();

    public Promo(){

        st.add(new Student("John","L"));
        st.add(new Student("Roger","Alp"));
        st.add(new Student("Toto","S"));

        System.out.println(st);

        for (int i = 0; i < st.size(); i++) {
            System.out.println(st.get(i).fullname());
        }

    }

}
