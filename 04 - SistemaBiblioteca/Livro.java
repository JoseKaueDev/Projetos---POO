public class Livro{
    private String titulo;
    private String autor;
    private int isbn;
    private boolean disponivel;

    public Livro(String titulo, String autor , int isbn){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true;
    }

public void setDisponivel(boolean disponivel){
    this.disponivel = disponivel;
}

    public String getAutor(){
        return autor;
    }
     public int getIsbn(){
        return isbn;
    }
     public String getTitulo(){
        return titulo;
    }
    public boolean getDisponivel(){
        return disponivel;
    }

}