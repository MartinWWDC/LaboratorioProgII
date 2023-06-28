import java.math.BigDecimal;

public class test {
    public static void main(String[] args) {
        Valuta valuta = Valuta.DOLLARO;
        Valuta yen = Valuta.YEN;
        System.out.println(valuta.getSimbolo()); // Output: $
        Importo im=new Importo(valuta);
        Importo i=new Importo(new BigDecimal(6.00),yen);
        Importo i2=new Importo(new BigDecimal(6.00),valuta);

        //System.out.println(im.somma(i));
        //System.out.println(im.compareTo(i));
        
        Cassa cs=new Cassa();
        cs.prelievo(i);
        System.out.println(cs);
        //TassoDiCambio ts=new TassoDiCambio(i2, i);
        //System.out.println(ts);

    }
}
