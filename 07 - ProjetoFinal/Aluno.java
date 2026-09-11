
public class Aluno {
    private String nome;
    private String email;

    public Aluno(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    
    public Aluno(String nome){
        this.nome = nome;
        this.email = nome + "@gmail.com";
    }
    
    public String getNome(){ return nome; }
    public String getEmail(){ return email; }


}
