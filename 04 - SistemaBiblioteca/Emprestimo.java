import java.time.LocalDate;
import java.time.temporal.ChronoUnit;



public class Emprestimo{
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate diaDaDevolucao;
    private boolean finalizado;
    private double multa;


    public boolean criarEmprestimo(Usuario usuario, Livro livro , LocalDate dataEmprestimo){
        if(livro.getDisponivel() && usuario.getEmprestimos() < 3){
            this.usuario = usuario;
            this.livro = livro;
            this.dataEmprestimo = dataEmprestimo;
            this.dataDevolucao = dataEmprestimo.plusDays(14);
            this.multa = 0.0;
            this.finalizado = false;

            livro.setDisponivel(false);
            usuario.incEmprestimos();
            return true;
        }
        else{
            System.out.println("Deu erro pae");
            return false;
        }
    }

    public void devolverLivro(LocalDate diaDaDevolucao){
        this.diaDaDevolucao = diaDaDevolucao;
        this.finalizado = true;
        livro.setDisponivel(true);

        long diasAtraso = ChronoUnit.DAYS.between(dataDevolucao, diaDaDevolucao); 
        if(diasAtraso > 0) {
            this.multa = diasAtraso * 1.50;
        }
        else{
            this.multa = 0.0;
        }
    }
    public double getMulta(){
        return multa;
    }
    public boolean seFinalizou(){
        return finalizado;
    }
    public Livro getLivro(){
        return livro;
    }
    public Usuario getUsuario(){
        return usuario;
    }
}


