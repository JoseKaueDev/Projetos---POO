
public class Jogador{
    private String nome;
    private int tentativasRestantes;

    public Jogador(String nome , int tentativasIniciais){

        this.nome = nome;
        this.tentativasRestantes = tentativasIniciais;
    }

    public String getNome(){
        return nome;
    }

    public int getTentativasRestantes(){
        return tentativasRestantes;
    }

    public void diminuirTentativas(){
        if(tentativasRestantes > 0){
            tentativasRestantes--;
        }
    }
}