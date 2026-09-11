import java.time.LocalDate;

abstract class Servico implements IServico{
    
    protected int numeroSolicitacao;
    protected String nomeCliente;
    protected LocalDate data;
    protected boolean servicoRealizado = false;
    protected String tipoServico;


    public Servico(int numeroSolicitacao , String nomeCliente , LocalDate data , String tipoServico){
            this.numeroSolicitacao = numeroSolicitacao;
            this.nomeCliente = nomeCliente;
            this.data = data;
            this.tipoServico = tipoServico;
    }

    @Override
    public void exibirResumo(){
        System.out.println("Numero de solicitacao: " + this.numeroSolicitacao);
        System.out.println("Nome do cliente: "+ this.nomeCliente);
        System.out.println("Data do pedido: "+this.data);
        System.out.println("Tipo do servico: "+this.tipoServico);
        System.out.println("");
    }

    protected boolean seServicoRealizado(){
        if(this.servicoRealizado){
            return true;
        }
        else{
            this.servicoRealizado = true;
            return false;
        }
    }
    @Override
    public void validar(){
        if(numeroSolicitacao <= 0){
            throw new IllegalArgumentException("Numero Invalido");
        }
        if(nomeCliente == null || nomeCliente.trim().isEmpty()){
            throw new IllegalArgumentException("Cliente obrigatorio");
        }
        if(data == null){
            throw new IllegalArgumentException("Data invalida");
        }
    }
    @Override
    public abstract void executar();
}
