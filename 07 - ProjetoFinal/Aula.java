public abstract class Aula {
    protected String titulo;
    protected int duracao;

    
    public Aula(String titulo, int duracao) {
        this.titulo = titulo;
        this.duracao = duracao;
    }
    
    public void setTitulo(String t){
        this.titulo = t;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setDuracao(int d){
        this.duracao = d;
    }

    public int getDuracao(){
        return duracao;
    }

    abstract void exibirConteudo();
}
