import java.util.Objects;

public class Giocattolo{
    /**owerview
     * questa classe implementa il tipo giocattolo, caratterizzato da un nome (comune) e un materiale
     */
    //Campi
    private String nome;
    private String materiale;
    
    public Giocattolo(String nome, String materiale)throws IllegalArgumentException {
        if(nome.isEmpty() || materiale.isEmpty()){
            throw new IllegalArgumentException(":(");
        }
        this.nome = nome;
        this.materiale = materiale;
    }


    public String getNome() {
        return nome;
    }

    public String getMateriale() {
        return materiale;
    }

    @Override
    public int hashCode() {
       
        return Objects.hash(nome,materiale);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Giocattolo)) return false;
        Giocattolo other = (Giocattolo) obj;
        return nome.equals(other.nome) && materiale.equals(other.materiale);
    }

    @Override
    public String toString() {
        return "Giocattolo: [Nome=" + this.nome + ", Materiale=" + this.materiale + "]";
    }

    
}