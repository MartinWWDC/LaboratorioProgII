public class lychrel {
    public static int getLychrel(int i) {
        String iStr=Integer.toString(i);
        String biStr=getReverse(iStr);

        return i+Integer.parseInt(biStr);
    }

    public static String getReverse(String str){
        String back="";
        for(int i=str.length()-1;i>=0;i--){
            back+=str.charAt(i);
        }
        return back;
    }

    public static boolean isNumPalindrom(int i) {
        String str=Integer.toString(i);
        for(int j=0;j<str.length();j++){
            if(!(str.charAt(j)==str.charAt(str.length()-j-1))){
               return false;
           }
        }
        return true;
        
    }
    public static int esFunc(int i) {
        int n=i;
        while(!isNumPalindrom(n)){
            //System.out.println(n+"+"+getLychrel(n));

            n=getLychrel(n);

        }        
        return n;
    }
   public static void main(String[] args) {
        System.out.println(esFunc(1709));
    }
}
