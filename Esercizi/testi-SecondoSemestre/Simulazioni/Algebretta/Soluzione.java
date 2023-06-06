public class Soluzione {
    public static void main(String[] args) {
        VettoreNullo v= new VettoreNullo(5);
        System.out.println(v);
        int[] arr={1,1,2,3};
        Vettore vo=new VettoreDenso(arr);
        System.out.println(vo);
        System.out.println(vo.per(5));
        int[][] matr={{0,1,2},{3,4,5},{6,7,8}};
        MatriceDensa ma=new MatriceDensa(matr);
        System.out.println(ma);
    }
}
 