import java.util.ArrayList;

public class Arma {
    String nome;
    int dano;
    ArrayList<Habilidade> habilidades = new ArrayList<>();

    public Arma(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        habilidades.add(habilidade);
    }
    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }
    public int DanoTotal(Habilidade habilidade) {
        return getDano() * habilidade.poderEfeito();
    }
}
