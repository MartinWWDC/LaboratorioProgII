import javax.script.ScriptContext;

public class test {
    public static void main(String[] args) throws IllegalAccessException {
        Pacco pc1=new Pacco("A", 10);
        Pacco pc2=new Pacco("B", 10);
        Pacco pc3=new Pacco("C", 10);
        Scaffalatura sc=new Scaffalatura();
        Scaffalatura scP=new Scaffalatura();
        sc.aggiungi(pc1);
        sc.aggiungi(pc2);
        sc.aggiungi(pc3);
        System.out.println(sc);
        System.out.println(scP);
        System.out.println("-------");

        //Pacco p=sc.rimuovi();
        //System.out.println(sc);

        //Robot rb= new ExtraRobot();
        Robot rb= new CautoRobot(10);
        System.out.println(rb.sposta(sc, scP, 2));
        System.out.println(sc);  
        System.out.println(scP);


        
    }
}
