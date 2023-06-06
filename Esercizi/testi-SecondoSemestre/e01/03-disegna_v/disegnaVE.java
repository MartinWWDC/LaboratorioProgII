public class disegnaVE {
    public static void main(String[] args) {
        int n = 6;
        for(int r = 0; r<n; r++){

            for(int c = 0; c<2*n-1; c++){

                if(c==r || c+r == 2*n -2){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}
