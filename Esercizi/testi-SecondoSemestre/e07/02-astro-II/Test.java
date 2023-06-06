import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println(args[0]);
        SistemaAstronomico sis = new SistemaAstronomico();
        Scanner s = new Scanner(System.in);
        CorpoCeleste p;
        while (s.hasNext()) {
            char check = s.next().charAt(0);
            String name = s.next();
            int x = s.nextInt();
            int y = s.nextInt();
            int z = s.nextInt();
            if (check == 'P') {
                p = new Pianeta(name, x, y, z);
            } else {
                p = new StellaFissa(name, x, y, z);

            }
            sis.add(p);
        }
        System.out.println(sis);
        sis.simula(Integer.parseInt(args[0]));
        System.out.println(sis);

    }

}
