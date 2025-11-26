import java.util.ArrayList;

public class Batalha {
    
    public static void iniciarBatalha(Personagem jogador, Inimigo inimigo) {
        while (true) {
            System.out.println("Sua Vida: " + jogador.getVida() + " | Vida do Inimigo: " + inimigo.getVida());
            System.out.println("Escolha uma habilidade para atacar:");
            ArrayList<Habilidade> habilidades = jogador.inventario.get(jogador.armaEquipada).getHabilidades();
            for (int i = 0; i < habilidades.size(); i++) {
                System.out.println((i + 1) + ". " + habilidades.get(i).getNome());
            }
            int escolhaHabilidade;
            try {
                escolhaHabilidade = Integer.parseInt(System.console().readLine("Digite o número da habilidade escolhida: ")) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                continue;
            }


            int dano = jogador.atacar(inimigo,jogador.inventario.get(jogador.armaEquipada),jogador.inventario.get(jogador.armaEquipada).habilidades.get(escolhaHabilidade));
            String resultadoDano = inimigo.danoRecebido(dano,jogador.inventario.get(jogador.armaEquipada).habilidades.get(escolhaHabilidade));
            System.out.println(resultadoDano);
            if (inimigo.getVida() <= 0) {
                System.out.println("Você derrotou o inimigo " + inimigo.getNome() + "!");
                break;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


            int danoInimigo = inimigo.atacar(jogador,inimigo.armaEquipada,inimigo.armaEquipada.habilidades.get(0));
            String resultadoDanoInimigo = jogador.danoRecebido(danoInimigo,inimigo.armaEquipada.habilidades.get(0));
            System.out.println(resultadoDanoInimigo);
            if (jogador.getVida() <= 0) {
                System.out.println("Você foi derrotado pelo inimigo " + inimigo.getNome() + "...");
                break;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
