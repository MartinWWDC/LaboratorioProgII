
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test {
  public static void main(String[] args) {
    Set<RationalNumber> l = new HashSet<>();
    RationalNumber s, p, d;
    int n = 1;

    try (Scanner in = new Scanner(System.in)) {
      RationalNumber r = new RationalNumber(in.nextInt(), in.nextInt());

      l.add(r);
      s = p = d = r;

      while (in.hasNextInt()) {
        n++;
        r = new RationalNumber(in.nextInt(), in.nextInt());
        l.add(r);

        s = s.add(r);
        p = p.mul(r);
        d = d.div(r);
      }
    }

    System.out.println(s);
    System.out.println(p);
    System.out.println(d);
    System.out.println(n - l.size());
  }
}