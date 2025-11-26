import java.util.Random;

public class Principal {
    
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao RPG Java!");
        System.out.println("Pressione ENTER para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {}
        while (true) {
            System.out.println("Vamos começar a aventura!");
            System.out.println("Escolha seu personagem:");
            System.out.println("1. Guerreiro");
            System.out.println("2. Mago");
            System.out.println("3. Arqueiro");
            int escolhaPersonagem;
            try {
                escolhaPersonagem = Integer.parseInt(System.console().readLine("Digite o número do personagem escolhido: "));
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                continue;
            }
            Personagem jogador;
            switch (escolhaPersonagem) {
                case 1:
                    jogador = new Personagem("Guerreiro", 150, 20, 10);
                    break;
                case 2:
                    jogador = new Personagem("Mago", 100, 30, 5);
                    break;
                case 3:
                    jogador = new Personagem("Arqueiro", 120, 25, 8);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }
            System.out.println("Você escolheu: " + jogador.getNome());
            jogador.inventario.add(new Arma(GeradorDeNomes.gerarNomeArma(escolhaPersonagem-1), 15));
            switch (escolhaPersonagem) {
                case 1:
                    jogador.inventario.get(0).adicionarHabilidade(new Habilidade("Corte Rápido Básico", 1));
                    break;
                case 2:
                    jogador.inventario.get(0).adicionarHabilidade(new Habilidade("Raio Sutil Básico", 1));
                    break;
                case 3:
                    jogador.inventario.get(0).adicionarHabilidade(new Habilidade("Impacto Rápido Básico", 1));
                    break;
            }

            Inimigo inimigo1 = new Inimigo("Goblin", 80, 15, 5);
            inimigo1.equiparArma(new Arma(GeradorDeNomes.gerarNomeArma(0), 10));
            inimigo1.armaEquipada.adicionarHabilidade(new Habilidade(GeradorHabilidade.gerarNomeHabilidade(0), 1));

            Inimigo inimigo2 = new Inimigo("Orc", 120, 25, 15);
            inimigo2.equiparArma(new Arma(GeradorDeNomes.gerarNomeArma(2), 20));
            inimigo2.armaEquipada.adicionarHabilidade(new Habilidade(GeradorHabilidade.gerarNomeHabilidade(2), 2));

            Inimigo inimigo3 = new Inimigo("Troll", 200, 30, 30);
            inimigo3.equiparArma(new Arma(GeradorDeNomes.gerarNomeArma(1), 30));
            inimigo3.armaEquipada.adicionarHabilidade(new Habilidade(GeradorHabilidade.gerarNomeHabilidade(1), 4));

            int contagemInimigos = 0;
            int vitoria = 0;

            while (true) {
                Random rand = new Random();
                Menu menu = new Menu();
                menu.executar();
                if(menu.escolha == 1) {
                    switch (contagemInimigos) {
                        case 0:
                            Batalha.iniciarBatalha(jogador, inimigo1);
                            if (jogador.getVida() <= 0) {
                                System.out.println("Game Over!");
                                vitoria = -1;
                            }else{
                                contagemInimigos++;
                                System.out.println("Parabéns! Você ganhou a primeira batalha. Tome uma nova arma como recompensa.");
                                Arma Arma1 = new Arma(GeradorDeNomes.gerarNomeArma(escolhaPersonagem-1), 15 + rand.nextInt(21));
                                Arma1.adicionarHabilidade(new Habilidade(GeradorHabilidade.gerarNomeHabilidade(escolhaPersonagem-1), 1 + rand.nextInt(2)));
                                Arma1.adicionarHabilidade(new Habilidade(GeradorHabilidade.gerarNomeHabilidade(escolhaPersonagem-1), 1 + rand.nextInt(3)));
                                jogador.adicionarArma(Arma1);
                                System.out.println("Você recebeu a arma: " + Arma1.getNome());
                                jogador.armaEquipada = jogador.inventario.size() - 1;  
                                try {
                                    Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }   
                            }
                            break;
                        case 1:
                            Batalha.iniciarBatalha(jogador, inimigo2);
                            if (jogador.getVida() <= 0) {
                                System.out.println("Game Over!");
                                vitoria = -1;
                                try {
                                    Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }else{
                                contagemInimigos++;
                                System.out.println("Parabéns! Você ganhou a segunda batalha. Tome uma nova arma como recompensa.");
                                Arma Arma2 = new Arma(GeradorDeNomes.gerarNomeArma(escolhaPersonagem-1), 25 + rand.nextInt(26));
                                Arma2.adicionarHabilidade(new Habilidade(GeradorHabilidade.gerarNomeHabilidade(escolhaPersonagem-1), 2 + rand.nextInt(3)));
                                Arma2.adicionarHabilidade(new Habilidade(GeradorHabilidade.gerarNomeHabilidade(escolhaPersonagem-1), 2 + rand.nextInt(4)));
                                Arma2.adicionarHabilidade(new Habilidade(GeradorHabilidade.gerarNomeHabilidade(escolhaPersonagem-1), 2 + rand.nextInt(5)));
                                Arma2.adicionarHabilidade(new Habilidade(GeradorHabilidade.gerarNomeHabilidade(escolhaPersonagem-1), 3 + rand.nextInt(3)));
                                jogador.adicionarArma(Arma2);
                                System.out.println("Você recebeu a arma: " + Arma2.getNome());
                                jogador.armaEquipada = jogador.inventario.size() - 1;
                                try {
                                    Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                            break;
                        case 2:
                            Batalha.iniciarBatalha(jogador, inimigo3);
                            if (jogador.getVida() <= 0) {
                                System.out.println("Game Over!");
                                vitoria = -1;
                                try {
                                    Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }else{
                                contagemInimigos++;
                                vitoria = 1;
                            }
                            break;
                    }
                    if(vitoria == -1) {
                        System.out.println("Você perdeu toda a sua vida. Tente novamente!");
                        System.out.println("Voce seja reiniciar o jogo? (S/N)");
                        String resposta = System.console().readLine().toUpperCase();
                        if(resposta.equals("S")) {
                            break;
                        } else
                            System.exit(0);

                        break;
                    } else if(vitoria == 1) {
                        System.out.println("Parabéns! Você derrotou todos os inimigos!");
                        System.out.println("Voce seja reiniciar o jogo? (S/N)");
                        String resposta = System.console().readLine().toUpperCase();
                        if(resposta.equals("S")) {
                            break;
                        } else
                            System.exit(0);
                        break;
                    }
                } else if(menu.escolha == 2) {
                    jogador.listarArmas();
                    System.out.println("Escolha o número da arma que deseja equipar:");
                    int escolhaArma;
                    try {
                        escolhaArma = Integer.parseInt(System.console().readLine("Número da arma: ")) - 1;
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número.");
                        continue;
                    }
                    if (escolhaArma < 0 || escolhaArma >= jogador.inventario.size()) {
                        System.out.println("Número de arma inválido. Tente novamente.");
                    } else {
                        jogador.armaEquipada = escolhaArma;
                        System.out.println("Você equipou a arma: " + jogador.inventario.get(escolhaArma).getNome());
                    }
                } else if(menu.escolha == 3) {
                    System.out.println("Saindo do jogo. Até a próxima!");
                    System.exit(0);
                }
            }
        }
        
    }
}
