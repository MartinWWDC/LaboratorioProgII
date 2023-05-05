public class PiastrellaRettangolare extends Piastrella {
    private int base,altezza;
    

    public PiastrellaRettangolare(int costo, int base, int altezza) throws IllegalArgumentException {
        super(costo);
        if(base <=0 || altezza<=0 ) throw new IllegalArgumentException("la base e l'altezza non possono essere minore di 0");

        this.base = base;
        this.altezza = altezza;
    }


    @Override
    public int superfice() {
        return base*altezza;
    }
    
}
