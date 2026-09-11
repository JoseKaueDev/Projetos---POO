public class IngressoCamarote extends Ingresso{
        
    private String setor;

    public IngressoCamarote(String codigo , double valorBase , String comprador , String setor){
        super(codigo, valorBase,  comprador);

        if(setor == null || setor.isEmpty()){
            throw new IllegalArgumentException("O setor nao pode ser vazio");
        }
        this.setor = setor;
    }

    public IngressoCamarote(String codigo , double valorBase){
        this(codigo , valorBase , "SEM_NOME" , "Setor A");
    }


    @Override
    public double calcularValorFinal(double taxa){
        validarTaxa(taxa);
        double valorSemTaxa = valorBase + 100.0;
        return valorSemTaxa * (1 + taxa);
    }

    @Override
    public void imprimirDados(double taxa){
        super.imprimirDados(taxa);
        System.out.println("Setor: " + setor);
    }

    public void mudarSetor(String novoSetor){
        if(novoSetor == null || novoSetor.isEmpty()){
            throw new IllegalArgumentException("Novo setor nao pode ser vazio");
        }
        this.setor = novoSetor;
    }
    @Override
    public String getResumo(double taxa) {
        double valorFinal = calcularValorFinal(taxa);
    return String.format("\nIngresso Camarote [Cód: %s] - Comprador: %s - Valor Final: R$ %.2f - Setor: %s",codigo, comprador, valorFinal, setor);
    }
}
