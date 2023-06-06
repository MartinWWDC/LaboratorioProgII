
import java.util.Objects;

/**
 * Lo scopo dell'esercizio è progettare e implementare una gerarchia di oggetti
 * utili a rappresentare *numeri razionali
 */
public class RationalNumber {
    //Campi
    int numerator;
    int denominator;

    

    /**
     * AF:denominatore deve essere diverso da 0
     *
     * IR:l'oggetto risultante di questa classe è il numero razionale rappresentato dalla 
     *      divisione tra numeratore e denominatore
     * */

     public RationalNumber(int num, int den) {
        if (den == 0)
          throw new ArithmeticException(
              "Illegal rational number. The denominator must be a non-zero integer. Given: " + den);
    
        if (den < 0) {
          numerator= -num;
          den = -den;
        }
    
        int cd = gcd(Math.abs(num), den);
        numerator = numerator/ cd;
        denominator = den / cd;
    
        assert repOK();
      }
    /**
     * Restituisce il RationalNumber this + o.
     * Solleva un'eccezione di tipo NullPointerException se o è null.
     * @param o
     * @return
    */
    public RationalNumber add(RationalNumber o) {
        Objects.requireNonNull(o);
        return new RationalNumber(
            numerator * o.denominator + o.numerator * denominator, denominator * o.denominator);
      }
    /**
     * Restituisce il RationalNumber -this.
     * @return
     */
    public RationalNumber minus() {
        return new RationalNumber(-numerator, denominator);
    }
    /**
     * Restituisce il RationalNumber this - o.
     * Solleva un'eccezione di tipo NullPointerException se o è null.
     * @param o
     * @return
     */
    public RationalNumber sub(RationalNumber o) {
      Objects.requireNonNull(o);
      return add(o.minus());
      
    }
    /**
     * 
     * @param o
     * @return
     */
    public RationalNumber mul(RationalNumber o) {
      Objects.requireNonNull(o);
      return new RationalNumber(numerator*o.numerator,denominator*o.denominator);

      
    }
    /**
     * Restituisce il RationalNumber 1/this.
     * Solleva un'eccezione di tipo ArithmeticException se this == 0.
     * @param o
     * @return
     */
    public RationalNumber reciproco(RationalNumber o) {
      Objects.requireNonNull(o);
      return new RationalNumber(denominator, numerator);
    }
    /**
     * Restituisce il RationalNumber this/o.
     * Solleva un'eccezione di tipo NullPointerException se o è null
     * e un'eccezione di tipo ArithmeticException se o == 0.
     * @param o
     * @return
     */
    public RationalNumber div(RationalNumber o) {
      Objects.requireNonNull(o);
      return mul(reciproco(o));
      
    }

   /**
    * Post-condizioni: Restituisce il minimo massimo comun divisore tra a e b.
    *                  Solleva un'eccezione di tipo IllegalArgumentException se uno dei due termini è negativo.
    * @param a
    * @param b
    * @return
    */
  private static int gcd(int a, int b) {
    if (a < 0 || b < 0) throw new IllegalArgumentException("Arguments must be positive integers.");

    while (b != 0) {
      int tmp = b;
      b = a % b;
      a = tmp;
    }

    return a;
  }
  private boolean repOK() {
    return denominator > 0 && gcd(numerator, denominator) == 1;
  }
  @Override
  public int hashCode() {
    
    return Objects.hash(numerator,denominator);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if(!(obj instanceof RationalNumber)) return false;
    RationalNumber rt = (RationalNumber) obj;
    return numerator==rt.numerator && denominator==rt.denominator;
    
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(numerator);
    if (denominator != 1) sb.append('/').append(denominator);
    return sb.toString();
  }
  
    
    
    
    




}
