import java.util.Objects;

public abstract class Entry {
    // campi
    private final String nome;

    protected Entry(String nome) {
        if (Objects.requireNonNull(nome, "Il nome non può essere null.").isEmpty())
            throw new IllegalArgumentException("Il nome non può essere vuoto.");
        this.nome = nome;

    }

    // SOF: methods
    /**
     * Consente di sapere se una <em>entry</em> è una <em>directory</em>.
     *
     * @return {@code true} sse l'entry è una directory.
     */
    public abstract boolean isDir();

    /**
     * Restituisce la dimensione dell'<em>entry</em>.
     *
     * @return la dimensione.
     */
    public abstract int size();

}
