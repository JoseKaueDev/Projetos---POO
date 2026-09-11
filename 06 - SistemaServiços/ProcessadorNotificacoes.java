
import java.util.List;

public class ProcessadorNotificacoes {
    
    public void notificarCliente(List<Notificavel> listaNotificavel){
        System.out.println(" Sistema de notificacao: ");
        for(Notificavel notificavel : listaNotificavel){
            notificavel.enviarNotificacao();
        }
    }
}
