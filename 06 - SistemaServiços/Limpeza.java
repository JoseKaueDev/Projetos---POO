import java.time.LocalDate;

public class Limpeza extends Servico{
    
    private String localLimpar;
    
    public Limpeza(int numeroSolicitacao , String cliente , LocalDate data , String tipoServico , String localLimpeza){
        super(numeroSolicitacao , cliente , data , tipoServico);
        this.localLimpar = localLimpeza;
    }

    @Override
    public void executar(){
        validar();
        if(this.localLimpar == null || this.localLimpar.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        else if(seServicoRealizado()){
            System.err.println("Limpeza feita");
        }
        else{
            System.err.println("Limpeza ja feita no local "+ this.localLimpar);
        }
    }
}