import java.time.LocalDate;

public class Manutencao extends Servico implements Notificavel{

    private String defeito;
    private boolean concluido = false;

    public Manutencao(int numeroSolicitacao , String nomeCliente , LocalDate data , String tipoServico , String defeito){
        super(numeroSolicitacao , nomeCliente , data , tipoServico);
        this.defeito = defeito;
    }
    @Override
    public void executar(){
        validar();
        if(this.defeito == null || this.defeito.trim().isEmpty()){
            throw new IllegalArgumentException("Tem nada no defeito.");
        }
        else if (seServicoRealizado()) {
            System.err.println("Manutenção já realizada");
        }
        else{
            System.out.println("A manutencao foi realizada!!");
            this.concluido = true;
        }
    }
    @Override
    public void enviarNotificacao(){
        System.out.println("Notificacao: Mandando mensagem para o cliente "+ nomeCliente);
    }
}
