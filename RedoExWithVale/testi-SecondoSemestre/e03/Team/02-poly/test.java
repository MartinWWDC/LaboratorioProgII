public class test {
    public static void main(String[] args) {
        Poly pol = new Poly(1,1);
        System.out.println(pol.toString());
        Poly pol1 = new Poly(5,1);
        System.out.println(pol.sub(pol1).toString());
        System.out.println(pol.sum(pol1).toString());
    }    
}
