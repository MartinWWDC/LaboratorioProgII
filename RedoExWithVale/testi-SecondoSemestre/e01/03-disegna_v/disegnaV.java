public class disegnaV {

    public static void drawV(int n) {
        for(int j=0;j<n;j++){
            for(int i=0;i<2*n-1;i++){
                if(i==j || i==2*n-2-j){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
 
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        drawV(5);
    }
}
