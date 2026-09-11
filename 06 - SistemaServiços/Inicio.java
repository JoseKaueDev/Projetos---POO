import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Inicio{

    public static void main(String[] args){

      List<IServico> listaServicos = new ArrayList<>();


      Instalacao instalacao = new Instalacao(0001, "Carlos", LocalDate.now(), "Instalação", "placa de video");
      Manutencao manutencao = new Manutencao(0002, "Querino", LocalDate.now(), "Manutenção", "computador");
      Vistoria vistoria = new Vistoria(0003, "guilerme", LocalDate.now(), "Vistoria", "processador");
      Limpeza limpeza = new Limpeza(0004, "Bruno", LocalDate.now(), "Limpeza", "casa de kafe");

      listaServicos.add(instalacao);
      listaServicos.add(manutencao);
      listaServicos.add(vistoria);
      listaServicos.add(limpeza);

      ProcessadorSolicitacoes processadorServicos = new ProcessadorSolicitacoes();
      processadorServicos.realizarServico(listaServicos);

      List<Notificavel> listaNotificaveis = new ArrayList<>();

      listaNotificaveis.add(instalacao);
      listaNotificaveis.add(manutencao);

      ProcessadorNotificacoes processadorNotificacao = new ProcessadorNotificacoes();
      processadorNotificacao.notificarCliente(listaNotificaveis);
}
}