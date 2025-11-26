import java.util.Random;

public class GeradorHabilidade {
    public static String gerarNomeHabilidade(int tipoHabilidade) {
        String[] tipos = {"Corte","Raio", "Impacto"};
        String[] adjetivos = {"Rápido", "Poderoso", "Devastador", "Sutil", "Brutal"};
        String[] sufixos = {"Supremo", "Avançado", "Básico", "Épico", "Lendário"};

        Random rand = new Random();

        String tipo = tipos[tipoHabilidade];
        String adj = adjetivos[rand.nextInt(adjetivos.length)];
        String suf = sufixos[rand.nextInt(sufixos.length)];

        return adj + " " + tipo + " " + suf;
    }
}
