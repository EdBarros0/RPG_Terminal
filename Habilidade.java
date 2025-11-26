public class Habilidade {
    String nome;
    int multiplicador;

    public Habilidade(String nome, int multiplicador) {
        this.nome = nome;
        this.multiplicador = multiplicador;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getMultiplicador() {
        return multiplicador;
    }
    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public int poderEfeito() {
        return getMultiplicador();
    }
}
