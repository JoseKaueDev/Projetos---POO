public class App {
    public static void main(String[] args) {
    
        Curso cursoJava = new Curso("Java Completo");

        Modulo moduloPoo = new Modulo("POO");
        Modulo moduloColecoes = new Modulo("Coleções");

        cursoJava.adicionarModulo(moduloPoo);
        cursoJava.adicionarModulo(moduloColecoes);

        Aula a1 = new AulaTeorica("Introdução a Java", 50, "Codecademy");
        Aula a2 = new AulaLab("Exercícios sobre Classes", 100, "Capaties 1");
        Aula a3 = new AulaTeorica("Herança e Polimorfismo", 100, "Slides");
        Aula a4 = new AulaLab("Interface", 100);


        moduloPoo.adicionarAula(a1);
        moduloPoo.adicionarAula(a2);
        moduloPoo.adicionarAula(a3);
        moduloPoo.adicionarAula(a4);

        moduloColecoes.adicionarAula(new AulaLab("ArrayList na prática", 50, "Capaties 2"));
        moduloColecoes.adicionarAula(new AulaTeorica("Map e Set", 50, "Apostila 1"));
        
        Aluno joao = new Aluno("João Pedro", "joao@gmail.com");
        Aluno maria = new Aluno("Maria Silva");

        cursoJava.matricularAluno(joao);
        cursoJava.matricularAluno(maria);

        Exibivel e1 = cursoJava;
        Exibivel e2 = moduloPoo;

        e1.exibirResumo();
        e2.exibirResumo();
    
        VizualizadorCurso vis = new VizualizadorCurso();
        vis.mostrarCursoCompleto(cursoJava);
    }
}
