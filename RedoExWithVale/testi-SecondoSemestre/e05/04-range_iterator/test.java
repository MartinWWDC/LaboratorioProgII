import java.util.Iterator;

public class test {
    public static void main(String[] args) {
        Range range = new Range(0, 10, 2);
        Iterator<Integer> iter = range.Iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
