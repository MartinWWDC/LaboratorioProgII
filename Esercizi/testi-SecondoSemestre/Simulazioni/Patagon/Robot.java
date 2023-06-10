/**
 * Quest'interfaccia permette di implemntare la struttura di un robot
 */
public interface Robot {
   /**
    * sposta permette di spostare n pacchi da a a b restituiendo il numero di viaggi che ha dovuto compiere
    * @param a primo scaffale
    * @param b secondo scaffale
    * @param n numero di elementi da spostare
    * @return numero di spostamenti 
    * @throws IllegalAccessException se a ha un numero di pacchi minore di n
    * @throws IllegalArgumentException se n è minore o uguale a 0
    * @throws NullPointerException se a o b sono null
    */

    public int sposta(Scaffalatura a,Scaffalatura b,int n)throws IllegalAccessException,IllegalArgumentException,NullPointerException; 


}
