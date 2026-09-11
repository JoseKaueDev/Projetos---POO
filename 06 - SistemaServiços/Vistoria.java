import java.time.LocalDate;

public class Vistoria extends Servico{
    
    private String relatorio;

    public Vistoria(int numeroSolicitacao , String cliente , LocalDate data , String tipoServico , String relatorio ){
        super(numeroSolicitacao , cliente , data, tipoServico);
        this.relatorio = relatorio;
    }

    @Override
    public void executar(){
        validar();
        if(this.relatorio == null || this.relatorio.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        else if(seServicoRealizado()){
            System.err.println("Vistoria feita");
        }
        else{
            System.out.println("A vistoria ja foi realizada!!");;
        }
    }

}