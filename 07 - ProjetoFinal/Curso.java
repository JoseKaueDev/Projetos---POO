import java.util.ArrayList;
import java.util.List;

public class Curso implements Exibivel{
    private String nome;
    private final List<Modulo> modulos = new ArrayList<>();
    private final List<Aluno> alunos = new ArrayList<>();

    public Curso(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void adicionarModulo(Modulo m){
        modulos.add(m);
    }

    public List<Modulo> getModulos() {
    return modulos;
    }

    public List<Aluno> getAlunos() {
    return alunos;
    }

    public void matricularAluno(Aluno a){
    alunos.add(a);
    }

    @Override
    public void exibirResumo(){
        System.out.println("Curso: " + nome + " (Módulos: " + modulos.size() + ")");
    }
}
