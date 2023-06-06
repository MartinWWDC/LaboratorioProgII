public class test {
    public static void main(String[] args) {
        Giocattolo tino = new Giocattolo("Tino", "cioccolato");
        Giocattolo ester = new Giocattolo("Ester", "cuteness");
        Giocattolo vale = new Giocattolo("Vale", "cuscino");
        Inventario i = new Inventario();

        i.aggiungi(tino, 7);
        i.aggiungi(tino, 1);

        i.aggiungi(ester, 10);
        i.aggiungi(vale, 9);

        i.rimuovi(ester, 2);

        System.out.println(i.numeroGiocattoli(ester));
    }
}
