
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {


        int limiteErros = 6;
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Bem vindo ao jogo da Forca --- ");
        System.out.println("Tema: Personagens de Anime");
        System.out.print("Digite o seu nome: ");
        String nomeJogador = scanner.nextLine();

        Jogador jogador = new Jogador(nomeJogador, limiteErros);
        JogoDaForca jogo = new JogoDaForca(jogador);

        jogo.mostrarEstado();

        while(!jogo.jogoAcabou()){

            System.out.print("\nPalpite: ");
            String entrada = scanner.nextLine();

            if(entrada.length() == 1 && Character.isLetter(entrada.charAt(0))){
                char palpite = entrada.charAt(0);
                jogo.adivinhaLetra(palpite);

                if(!jogo.jogoAcabou()){

                    System.out.println("Palavra: ");
                        for(char c : jogo.getPalavraAdivinhada()){
                            System.out.print(c + " ");
                        }
                    System.out.println();

                    System.out.print("Usadas: ");
                    for(char c : jogo.getLetraUsada()){
                        System.out.print(c + " ");
                    }
                System.out.println();
                System.out.println("(Erros: " + jogo.getErros() + "/"+ limiteErros + ")");
                }
            }else{
                System.out.println("Entrada invalida, tenta de novo ai pae");
            }
        }

    System.out.println("=== GAME OVER ===");

    if(jogo.jogoGanho()){
        System.out.println("Parabéns "+ jogador.getNome());
        System.out.println("Você Venceu!");
    }else{
        System.out.println("Não foi dessa vez "+ jogador.getNome());
        System.out.println("Você Perdeu!");
    }
    System.out.println("Palavra: "+ jogo.getPalavraSecreta());
    System.out.println("Erros: "+ jogo.getErros());
    System.out.println("Rodadas: "+ jogo.getRodadas());

    System.out.print("Usadas: ");
    for(char c : jogo.getLetraUsada()){
         System.out.print(c + " ");
    }
    System.out.println();
    scanner.close();
    }
}

