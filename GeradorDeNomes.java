import java.util.Random;

public class GeradorDeNomes {
    
    public static String gerarNomeArma(int tipoArma) {
        String[] tipos = {"Espada", "Orbe", "Besta"};
        String[] adjetivos = {"Vorpal", "Sombria", "Flamejante", "Sagrada", "Enferrujada"};
        String[] sufixos = {"do Caos", "da Justiça", "do Dragão", "Universal", "Infinita"};

        Random rand = new Random();
        
        String tipo = tipos[tipoArma];
        String adj = adjetivos[rand.nextInt(adjetivos.length)];
        String suf = sufixos[rand.nextInt(sufixos.length)];

        return tipo + " " + adj + " " + suf;
    }
}
