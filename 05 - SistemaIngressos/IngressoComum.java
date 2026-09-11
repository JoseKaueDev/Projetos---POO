public class IngressoComum  extends Ingresso {

   private boolean comprovouEstudante;

   public IngressoComum(String codigo , double valorBase, String comprador , boolean comprovouEstudante){
    super(codigo, valorBase , comprador);
    this.comprovouEstudante = comprovouEstudante;

   }

   public IngressoComum(String codigo , double valorBase , boolean comprovouEstudante){
    this(codigo , valorBase , "SEM_NOME", comprovouEstudante);

   }

   public IngressoComum(double valorBase, boolean comprovouEstudante) {
        this("AUTO-" + auxCodigo++ , valorBase , "SEM_NOME" , comprovouEstudante);
    }

    public void aplicarDescontoEstudante(boolean comprovou){
        this.comprovouEstudante = comprovou;
    }

    @Override
    public double calcularValorFinal(double taxa){
        validarTaxa(taxa);
        double valorSemTaxa = getValorSemTaxa();

        if(comprovouEstudante){
            valorSemTaxa = valorBase * 0.5;
        }
        return valorSemTaxa * (1 + taxa);
    }

    @Override
    public void imprimirDados(double taxa){
        super.imprimirDados(taxa);
        System.out.println("Desconto estudante: " + (comprovouEstudante ? "Sim (50%)": "Nao"));
    }
    @Override
    public String getResumo(double taxa){
        double valorFinal = calcularValorFinal(taxa);
        String desconto = comprovouEstudante ? "Sim" : "Nao";
        return String.format("\nIngresso Comum [Cód: %s] - Comprador: %s - Valor Final: R$ %.2f - Desconto Estudante: %s",codigo, comprador, valorFinal, desconto);
    }

}

