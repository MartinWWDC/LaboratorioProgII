import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
       
        List<Double> arr=new ArrayList<Double>();
        Scanner reader = new Scanner(new FileReader("input-1.txt"));
        while (reader.hasNextDouble()) {
            double valore = reader.nextDouble();
            arr.add(valore);
            
        }
        Statistica st2=new DuePassate(arr);
        System.out.println("Due Passate:");

        System.out.println(st2.getN()+","+st2.media()+", "+st2.varianza());
  
        Statistica st=new UnaPassata(arr);
        System.out.println("Una Passate:");
        System.out.println(st.getN()+","+st.media()+", "+st.varianza());


      

        Statistica ind=new Induttiva(arr);
        System.out.println("Induttiv:");
        System.out.println(ind.getN()+","+ind.media()+", "+ind.varianza());

    }   
}
