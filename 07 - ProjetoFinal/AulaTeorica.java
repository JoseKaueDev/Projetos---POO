public class AulaTeorica extends Aula{
    private String material;

    public AulaTeorica(String titulo, int duracao, String material) {
        super(titulo, duracao);
        this.material = material;
    }

    @Override
    public void exibirConteudo(){
        System.out.println("Essa é uma aula teórica, o assunto é: " + material);
    }

}
