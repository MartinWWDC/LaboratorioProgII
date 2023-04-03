
public class test {

    public static void main(String[] args) {
        Mappetta mappetta = new Mappetta();
        mappetta.put("Ester",999999990);
        mappetta.put("Tino",1000);
        System.out.println(mappetta);
        mappetta.remove("Tino");
        System.out.println(mappetta);
    }
}