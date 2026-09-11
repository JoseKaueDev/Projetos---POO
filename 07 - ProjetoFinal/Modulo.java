import java.util.ArrayList;
import java.util.List;

public class Modulo implements Exibivel{
    private String nome;
    private final List<Aula> aulas = new ArrayList<>();
    
    public Modulo(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }

    public void adicionarAula(Aula a){
        aulas.add(a);
    }

    public List<Aula> getAulas(){
        return aulas;
    }
    @Override
    public void exibirResumo() {
        System.out.println("Módulo: " + nome + " (Aulas: " + aulas.size() + ")");
    }
}
