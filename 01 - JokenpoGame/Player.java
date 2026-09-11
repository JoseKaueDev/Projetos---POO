

//meu import tava errado, fui ver tava until e nao util   ai dento
import java.util.Random;


 public class Player{
    Random rng = new Random();
    String nome;
    int jogadaAtual;
    int numeroVitorias;

    //nome dos caba
    public Player(String nomeReceber){
    this.nome = nomeReceber;
    this.numeroVitorias = 0;
    }

// escolher pedra ou papel ou tesoura;

    public void jogadaAleatoria(){
        jogadaAtual = rng.nextInt(3);
    }

// ver se e pedra ou papel ou tesoura ;

public int saberVitorias(){
    return numeroVitorias;
}

 public String jogadaComoString() {
    if(jogadaAtual == 0){
        return ("Pedra");}
    if(jogadaAtual == 1){
        return ("Papel");}
    return ("Tesoura");
    }
    }

 

