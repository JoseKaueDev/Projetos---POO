public class Usuario {
    private String nome;
    private int matricula;
    private int emprestimos;

    public Usuario(String nome , int matricula){
        this.nome = nome;
        this.matricula = matricula;
        this.emprestimos = 0;
    }
    
    public String getNome(){
        return nome;
    }
    public int getMatricula(){
        return matricula;
    }
    public int getEmprestimos(){
        return emprestimos;
    }
    public void incEmprestimos(){
        this.emprestimos++;
    }
    public void decEmprestimos(){
        if(emprestimos > 0) this.emprestimos--;
    }
}
