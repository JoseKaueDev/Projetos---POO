

public class JokenpoGame {
    int rodadaAtual;
    int limiteVitorias;
    Player jogador1 , jogador2 , jogador3;
    
    public JokenpoGame(String nome1 , String nome2 , String nome3 , int limiteVit){
        jogador1 = new Player(nome1);
        jogador2 = new Player(nome2);
        jogador3 = new Player(nome3);
        limiteVitorias = limiteVit;
        rodadaAtual = 0;
    }

    public void start(){


        System.out.println("=== Jokenpo ===");
        System.out.println("Alvo = "+ limiteVitorias +" vitorias " );


        while(!alguemGanhou()){
            
            
            rodadaAtual++;
            System.out.println("\nRodada numero: "+ rodadaAtual);

            jogador1.jogadaAleatoria();
            jogador2.jogadaAleatoria();
            jogador3.jogadaAleatoria();

            System.out.println(jogador1.nome + ": " + jogador1.jogadaComoString());
            System.out.println(jogador2.nome + ": " + jogador2.jogadaComoString());
            System.out.println(jogador3.nome + ": " + jogador3.jogadaComoString());


            avaliarJogada();
            System.out.println("Placar: "+ jogador1.nome + "="+ jogador1.numeroVitorias + " | "+ jogador2.nome +"="+ jogador2.numeroVitorias+ " | "+ jogador3.nome +"="+ jogador3.numeroVitorias);
        }
        exibirPlacarFinal();
    }

    private boolean alguemGanhou(){
        return jogador1.saberVitorias() >= limiteVitorias || jogador2.saberVitorias() >= limiteVitorias || jogador3.saberVitorias() >= limiteVitorias;
    }

    public void avaliarJogada(){
        int jogadaPlayer1 = jogador1.jogadaAtual;
        int  jogadaPlayer2 = jogador2.jogadaAtual;
        int  jogadaPlayer3 = jogador3.jogadaAtual;
        
        //deu empate;
        if(jogadaPlayer1 == jogadaPlayer2 && jogadaPlayer2 == jogadaPlayer3){
            System.out.println("Deu empate ai viu");
            return;
        }


        //tudo diferente;
        if(jogadaPlayer1 != jogadaPlayer2 && jogadaPlayer2 != jogadaPlayer3 && jogadaPlayer1 != jogadaPlayer3){
            System.out.println("Deu empate ai viu");
            return;
        }

        int jogadaVencedora = -1;

        //saber as jogadas que aparece, tipo 01 02 12;
        int a = Math.min(jogadaPlayer1 , Math.min(jogadaPlayer2 , jogadaPlayer3));
        int b = Math.max(jogadaPlayer1 , Math.max(jogadaPlayer2 , jogadaPlayer3));
        String quemGanha = "" + a + b;

        //esqueci de muita coisa sobre o switch
        switch (quemGanha){
            case "02":
                jogadaVencedora = 0;
                break;
            case "01":
                jogadaVencedora = 1;
                break;
            case "12":
                jogadaVencedora = 2;
                break;
        }   
           
        switch (jogador1.jogadaAtual){
            case 0: if(jogadaVencedora == 0){
                jogador1.numeroVitorias++;
                System.out.println("Vencendor(es): " + jogador1.nome);
            }
                break;
             case 1: if(jogadaVencedora == 1){
                jogador1.numeroVitorias++;
                System.out.println("Vencendor(es): " + jogador1.nome);
             }
                break;
             case 2: if(jogadaVencedora == 2){
                jogador1.numeroVitorias++;
                System.out.println("Vencendor(es): " + jogador1.nome);
             }
                break;
        }

            switch (jogador2.jogadaAtual){
            case 0: if(jogadaVencedora == 0){
                jogador2.numeroVitorias++;
                System.out.println("Vencendor(es): " + jogador2.nome);
            }
                break;
             case 1: if(jogadaVencedora == 1){
                jogador2.numeroVitorias++;
                System.out.println("Vencendor(es): " + jogador2.nome);
             }
                break;
             case 2: if(jogadaVencedora == 2){
                jogador2.numeroVitorias++;
                System.out.println("Vencendor(es): " + jogador2.nome);
             }
                break;
            }

            switch (jogador3.jogadaAtual){
            case 0: if(jogadaVencedora == 0){
                jogador3.numeroVitorias++;
                System.out.println("Vencendor(es): " + jogador3.nome);
            }
                break;
             case 1: if(jogadaVencedora == 1){
                jogador3.numeroVitorias++;
                System.out.println("Vencendor(es): " + jogador3.nome);
             }
                break;
             case 2: if(jogadaVencedora == 2){
                jogador3.numeroVitorias++;
                System.out.println("Vencendor(es): " + jogador3.nome);
             }
                break;
        }
    }
    public void exibirPlacarFinal(){
        System.out.println("\n\n=== Fim do jogo ===");
        System.out.println("Numero de rodadas = " + rodadaAtual);
        System.out.println("Placar final: "+ jogador1.nome + "="+ jogador1.numeroVitorias + " | "+ jogador2.nome +"="+ jogador2.numeroVitorias+ " | "+ jogador3.nome +"="+ jogador3.numeroVitorias);

        if(jogador1.numeroVitorias > jogador2.numeroVitorias && jogador1.numeroVitorias > jogador3.numeroVitorias){
            System.out.println("Vencedor(a): " + jogador1.nome);
            return;
        }
        if(jogador2.numeroVitorias > jogador1.numeroVitorias && jogador2.numeroVitorias > jogador3.numeroVitorias){
            System.out.println("Vencedor(a): " + jogador2.nome);
            return;
        }
        else{
            System.out.println("Vencedor(a): " + jogador3.nome);
            return;
        }
    }
}