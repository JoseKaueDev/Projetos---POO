
public class Ingresso {

    protected  static int auxCodigo = 1;

    protected String codigo;
    protected double valorBase;
    protected String comprador;

    public Ingresso(String codigo , double valorBase , String comprador){
        if(codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("O codigo esta vazio");
        }
        if(valorBase < 0){
            throw new IllegalArgumentException("Valor negativo");
        }
        if(comprador == null || codigo.trim().isEmpty()){
            comprador = "SEM_NOME";
        }
        this.codigo = codigo.trim();
        this.valorBase = valorBase;
        this.comprador = comprador.trim();
    }

    public Ingresso(String codigo , double valorBase){
       
       this(codigo , valorBase , "SEM_NOME");
    }

    public Ingresso(double valorBase){
        this("AUTO-" + auxCodigo++, valorBase , "SEM_NOME");
    }

    protected double getValorSemTaxa(){
        return this.valorBase;
    }

    public double calcularValorFinal(double taxa) {
        validarTaxa(taxa);
        return valorBase * (1 + taxa);
    }

    protected void validarTaxa(double taxa) {
        if (taxa < 0.0 || taxa > 0.20) {
            throw new IllegalArgumentException("Taxa deve estar entre 0.0 e 0.20");
        }
    }


    public void imprimirDados(double taxa){

        double valorFinal = calcularValorFinal(taxa);

        System.out.println("--- Ingresso: " + this.getClass().getSimpleName() + " ---");
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Comprador: "+ this.comprador);
        System.out.printf("Valor Base: R$ %.2f%n", this.valorBase);
     System.out.printf("Valor Final (Taxa %.0f%%): R$ %.2f%n", (taxa * 100), valorFinal);
    }


    public String getResumo(double taxa) {

        double valorFinal = calcularValorFinal(taxa);

        return String.format("\n%s [Cód: %s] - Comprador: %s - Valor Final: R$ %.2f", this.getClass().getSimpleName(), this.codigo, this.comprador, valorFinal);
    }
}
