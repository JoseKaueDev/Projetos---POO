public class IngressoVip extends Ingresso {

    private boolean acessoVip;

    public IngressoVip(String codigo , double valorBase , String comprador , boolean acessoVip){
        super(codigo , valorBase , comprador);
        this.acessoVip = acessoVip;
    }

    public IngressoVip(String codigo , double valorBase){
        this(codigo , valorBase , "SEM_NOME" , true);
    }

    @Override
    public double calcularValorFinal(double taxa){
        validarTaxa(taxa);
        double valorSemTaxa = valorBase * 2.0;
        return valorSemTaxa * (1 + taxa);
    }

    @Override
    public void imprimirDados(double taxa){
        super.imprimirDados(taxa);
        System.out.println("Acesso VIP: " + (acessoVip ? "Sim" : "Nao"));
    }

    public String infoAcessoVip(){
        return "Acesso VIP"+ (acessoVip ? "sim" : "nao");
    }

    @Override
    public String getResumo(double taxa){
        double valorFinal = calcularValorFinal(taxa);
        String acesso = acessoVip ? "Sim" : "Não";
    return String.format("\nIngresso VIP [Cód: %s] - Comprador: %s - Valor Final: R$ %.2f - Acesso VIP: %s",codigo, comprador, valorFinal, acesso);
    }
}
