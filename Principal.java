public class Principal {
    
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao RPG Java!");
        Personagem heroi = new Personagem("Arthas", 100, 20, 10);
        Arma espada = new Arma(GeradorDeNomes.gerarNomeArma(0), 15);
        Habilidade corteForte = new Habilidade("Corte Forte", 2);
        espada.adicionarHabilidade(corteForte);
        Inimigo monstro = new Inimigo("Goblin", 80, 15, 5, espada);
        Arma orbe = new Arma(GeradorDeNomes.gerarNomeArma(1), 10);
        Habilidade bolaDeFogo = new Habilidade("Bola de Fogo", 3);
        orbe.adicionarHabilidade(bolaDeFogo);
        heroi.adicionarArma(orbe);
        System.out.println(heroi.getNome() + " enfrenta " + monstro.getNome() + "!");
        int danoCausado = heroi.atacar(monstro, orbe, bolaDeFogo);
        String resultadoDano = monstro.danoRecebido(danoCausado, bolaDeFogo);
        System.out.println(resultadoDano);
        int danoRecebido = monstro.atacar(heroi, espada, corteForte);
        resultadoDano = heroi.danoRecebido(danoRecebido, corteForte);
        System.out.println(resultadoDano);
        heroi.listarArmas();
        heroi.getVida();
        monstro.getVida();
    }
}
