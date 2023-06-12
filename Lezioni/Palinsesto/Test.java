import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Trasmissione> p = new ArrayList<>();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] argomenti = line.split(" ");
            switch (argomenti[0]) {
                case "SEMPLICE":
                    String[] oreminuti = argomenti[1].split(":");
                    Betaorario b = new Betaorario(Integer.parseInt(oreminuti[0]), Integer.parseInt(oreminuti[1]));
                    FasciaBetaoraria f = new FasciaBetaoraria(b, Integer.parseInt(argomenti[2]));
                    String nome = "";
                    int i;
                    for (i = 3; i < argomenti.length-1; i++) {
                        nome += argomenti[i]+" ";
                    }
                    nome += argomenti[i];
                    Trasmissione t = new TrasmissioneSemplice(nome, f);
                    p.add(t);
                break;
                case "RADIOGIORNALE":
                    int durata = Integer.parseInt(argomenti[1]);
                    String nomer = "";
                    int j;
                    for (j = 2; j < argomenti.length-1; j++) {
                        nomer += argomenti[j]+" ";
                    }
                    nomer += argomenti[j];
                    Trasmissione t1 = new Radiogiornale(nomer, durata);
                    p.add(t1);

                break;
                case "PERIODICA":
                    String[] oreminutip = argomenti[1].split(":");
                    Betaorario bp = new Betaorario(Integer.parseInt(oreminutip[0]), Integer.parseInt(oreminutip[1]));
                    FasciaBetaoraria fp = new FasciaBetaoraria(bp, Integer.parseInt(argomenti[2]));
                    int n = Integer.parseInt(argomenti[3]);
                    int d = Integer.parseInt(argomenti[4]);
                    String nomep = "";
                    int k;
                    for (k = 5; k < argomenti.length-1; k++) {
                        nomep += argomenti[k]+" ";
                    }
                    nomep += argomenti[k];
                    Trasmissione t2 = new TrasmissionePeriodica(nomep, fp, n, d);
                    p.add(t2);
            }
        }

        Palinsesto pali = new Palinsesto(p);
        System.out.println(pali.toString());
    }
}