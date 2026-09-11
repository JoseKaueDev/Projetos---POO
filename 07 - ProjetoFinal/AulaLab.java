public class AulaLab extends Aula{
    private String exercicio;

    public AulaLab(String titulo, int duracao, String exercicio) {
        super(titulo, duracao);
        this.exercicio = exercicio;
    }
    public AulaLab(String titulo, int duracao) {
        super(titulo, duracao);
        this.exercicio = "Sem exercicios";
    }
    
    @Override
    public void exibirConteudo(){
        System.out.println("Aula de laboratório. O exercicio é: " + exercicio);
    }

}
