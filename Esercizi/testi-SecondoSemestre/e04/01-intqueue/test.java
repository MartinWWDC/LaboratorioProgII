public class test {
    public static void main(String[] args) {
        IntQueue intQ = new IntQueue(4);
        intQ.enqueue(4);
        intQ.enqueue(5);
        // intQ.Enqueue(8);
        // int n = intQ.Dequeue();

        System.out.println(intQ);
    }
}
