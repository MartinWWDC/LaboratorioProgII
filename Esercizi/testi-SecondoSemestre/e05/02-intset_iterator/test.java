import java.util.Iterator;

public class test {
    public static void main(String[] args) {
        IntSet i = new IntSet();
        i.Insert(0);
        i.Insert(1);
        i.Insert(2);
        i.Insert(3);

        Iterator<Integer> it = i.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        i.Insert(4);
        System.out.println(it.next());

    }

}
