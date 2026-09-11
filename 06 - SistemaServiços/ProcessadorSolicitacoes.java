import java.util.List;

public class ProcessadorSolicitacoes{
        public void realizarServico(List<IServico> listaDosServicos){
            for(IServico servico : listaDosServicos){
                servico.executar();
                servico.exibirResumo();
            }
        }
}
