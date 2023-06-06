public class test {
    public static void main(String[] args) {
        IntSet set = new IntSet();
        set.Insert(3);
        set.Insert(4);
        set.Insert(6);
        System.out.println(set.toString());
        set.remove(3);
        System.out.println(set.choose());
    }

}
