public class VizualizadorCurso {
    
    public void mostrarCursoCompleto(Curso curso) {
        System.out.println("");
        System.out.println("Curso: " + curso.getNome());

        System.out.println("\nAlunos matriculados:");
        for(Aluno a : curso.getAlunos()){
            System.out.println(" - " + a.getNome());
    }
        for (Modulo modulo : curso.getModulos()) {
            System.out.println("-Módulo: " + modulo.getNome());

            for (Aula aula : modulo.getAulas()) {
                System.out.println("--Aula: " + aula.getTitulo() + " (" + aula.getClass().getSimpleName() + ")");
            }
        }
    }
}
