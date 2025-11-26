public class Menu {
    int escolha;

    public void exibirMenu() {
        System.out.println("Menu de Opções:");
        System.out.println("1. Batalhar");
        System.out.println("2. Inventario");
        System.out.println("3. Sair");
    }

    public void selecionarOpcao() {
        int escolha;
        try {
            escolha = Integer.parseInt(System.console().readLine("Escolha uma opção: "));
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            return;
        }
        this.escolha = escolha;
        switch (escolha) {
            case 1:
                System.out.println("Iniciando batalha...");
                break;
            case 2:
                System.out.println("Abrindo inventário...");
                break;
            case 3:
                System.out.println("Saindo do jogo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void executar() {
        exibirMenu();
        selecionarOpcao();
    }

}
