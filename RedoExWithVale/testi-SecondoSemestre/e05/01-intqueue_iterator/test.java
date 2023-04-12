import java.util.Iterator;

public class test {
    public static void main(String[] args) {
        IntQueue c  = new IntQueue(6);

        c.enqueue(0);
        c.enqueue(1);
        c.enqueue(2);
        c.enqueue(3);
        c.enqueue(4);
        c.dequeue();
        System.out.println(c);
        Iterator<Integer> i = c.iterator();
        System.out.println(i.next());
        c.enqueue(0);

        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.next());
        
    }   
}
