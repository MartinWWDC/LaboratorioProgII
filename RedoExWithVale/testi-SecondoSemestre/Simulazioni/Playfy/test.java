import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> tit= new ArrayList<String>();
        List<Durata> dur= new ArrayList<Durata>();
        tit.add("miao");
        dur.add(new Durata(5));
        tit.add("prova");
        dur.add(new Durata(1115));
        tit.add("the slpa");
        dur.add(new Durata(500));
    
        Album al= new Album("suca", tit, dur);
        System.out.println(al);

    }    
}
