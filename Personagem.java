import java.util.ArrayList;

public class Personagem implements Pessoa {
    String nome;
    int vida;
    int forca;
    int defesa;
    int armaEquipada;
    ArrayList<Arma> inventario = new ArrayList<>();

    public Personagem(String nome, int vida, int forca, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
    }

    @Override
    public String getNome() {
        return nome;
    }
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public int getVida() {
        return vida;
    }
    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }
    @Override
    public int getForca() {
        return forca;
    }
    @Override
    public void setForca(int forca) {
        this.forca = forca;
    }
    @Override
    public int getDefesa() {
        return defesa;
    }
    @Override
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    @Override
    public int atacar(Pessoa alvo, Arma arma, Habilidade habilidade) {
        int danoCausado = arma.DanoTotal(habilidade) + this.forca;
        return danoCausado;
    }
    @Override
    public String danoRecebido(int dano,Habilidade habilidade) {
        if(dano - this.defesa >= 0) {
            this.vida -= (dano - this.defesa);
            return "O inimigo usou "+ habilidade.getNome() +". Dano recebido: " + (dano - this.defesa);
        } else {
            return "O inimigo usou "+ habilidade.getNome() +", mas sua defesa bloqueou todo o dano!";
        }
    }
    

    
}
