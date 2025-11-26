public interface Pessoa {
    String getNome();
    void setNome(String nome);
    int getVida();
    void setVida(int vida);
    int getForca();
    void setForca(int forca);
    int getDefesa();
    void setDefesa(int defesa);
    int atacar(Pessoa alvo, Arma arma, Habilidade habilidade);
    String danoRecebido(int dano, Habilidade habilidade);
}
