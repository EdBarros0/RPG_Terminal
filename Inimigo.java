public class Inimigo implements Pessoa {
    String nome;
    int vida;
    int forca;
    int defesa;
    Arma armaEquipada;
    public Inimigo(String nome, int vida, int forca, int defesa, Arma armaEquipada) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.armaEquipada = armaEquipada;
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
            return "Você usou "+ habilidade.getNome() +". O inimigo recebeu: " + (dano - this.defesa);
        } else {
            return "Você usou"+ habilidade.getNome() +", mas a defesa do inimigo é forte demais! Nenhum dano foi causado.";
        }
    }
    
}
