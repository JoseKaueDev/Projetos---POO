import java.time.LocalDate;

public class Instalacao extends Servico implements Notificavel{

    private String equipamento;

    public Instalacao(int numeroSolicitacao , String cliente , LocalDate data , String tipoServico, String equipamento){
        super(numeroSolicitacao , cliente , data , tipoServico);
        this.equipamento = equipamento;
    }

    @Override
    public void executar(){
        validar();
        if(this.equipamento == null || this.equipamento.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        else if(seServicoRealizado()){
            System.err.println("Servico ja realizado");
        }
        else{
            System.err.println("A instalacao do equipamento "+this.equipamento + " foi realizado!!");
        }
    }
//interface notificavel
    @Override
    public void enviarNotificacao(){
        System.out.println("Notificacao: Mandando mensagem para o cliente "+ nomeCliente);
    }

}