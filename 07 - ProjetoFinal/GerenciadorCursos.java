import java.util.ArrayList;
import java.util.List;

public class GerenciadorCursos {
    private List<Curso> cursos = new ArrayList<>();

    public void criarCurso(String nome){
        cursos.add(new Curso(nome));
        System.out.println("Curso criado");
    }

    public void listarCursos(){
        if(cursos.isEmpty()){
            System.out.println("Nenhum curso cadastrado.");
            return;
        }
        for (Curso c: cursos){
            c.exibirResumo();
        }
    }

    public void adicionarModulo(String nomeCurso, String nomeModulo) {
        Curso curso = buscarCurso(nomeCurso);
        if (curso == null) throw new RuntimeException("Curso não encontrado");

        curso.adicionarModulo(new Modulo(nomeModulo));
        System.out.println("Módulo adicionado!");
    }

    public void adicionarAula(String nomeCurso, String nomeModulo, String titulo, int duracao, String complementoAula, boolean pratica) {
        Curso curso = buscarCurso(nomeCurso);
        Aula aula;

        if (curso == null) throw new RuntimeException("Curso não encontrado");

        Modulo modulo = buscarModulo(curso, nomeModulo);
        if (modulo == null) throw new RuntimeException("Módulo não encontrado");

        if (pratica == true) {
            aula = new AulaTeorica(titulo, duracao, complementoAula);
        } 
        else {
            aula = new AulaLab(titulo, duracao, complementoAula);

        }
        
        modulo.adicionarAula(aula);
        System.out.println("Aula adicionada!");
    }

    private Curso buscarCurso(String nome) {
        for (Curso c : cursos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
    
    private Modulo buscarModulo(Curso curso, String nomeModulo) {
        for (Modulo m : curso.getModulos()) {
            if (m.getNome().equalsIgnoreCase(nomeModulo)) {
                return m;
            }
        }
        return null;
    }
}
