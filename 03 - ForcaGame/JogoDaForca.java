import java.util.Arrays;
import java.util.Random;

public class JogoDaForca{
    private String palavraSecreta;
    private char[] letrasUsadas;
    private char[] palavraAdivinhada;
    private int indiceLetrasUsadas;
    private Jogador jogador;
    private int erros;
    private int rodadas;

    private static final String[] DICIONARIO = {"KILLUA" , "TANJIRO" , "LUFFY", "ICHIGO", "SAITAMA", "NATSU", "GOKU", "NARUTO", "GON", "SASUKE", "ITACHI", "DEKU", "NEZUKO", "SHIKAMARU", "KURIRIN"};
    
    public JogoDaForca(Jogador jogador){
        this.jogador = jogador;
        this.erros = 0;
        this.rodadas = 0;
        this.letrasUsadas = new char[26];
        this.indiceLetrasUsadas = 0;

        Random random = new Random();
        this.palavraSecreta = DICIONARIO[random.nextInt(DICIONARIO.length)];
        this.palavraAdivinhada = new char[palavraSecreta.length()];
        Arrays.fill(palavraAdivinhada , '_');
    }

    public void mostrarEstado(){
        System.out.println("=== FORCA ===  (erros: " +erros + "/"+ jogador.getTentativasRestantes()+ ")");
        System.out.print("Palavra: ");
        for(char c : palavraAdivinhada){
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.print("Usadas: ");
        if(indiceLetrasUsadas == 0){
            System.out.println("_");
        }else{
            for(int i = 0 ; i < indiceLetrasUsadas; i++){
                System.out.print(letrasUsadas[i] + " ");
            }
        }
        System.out.println();
    }

    public void adivinhaLetra(char letra){
        letra = Character.toUpperCase(letra);

        if(letraJaUsada(letra)){
            System.out.println("Você já tentou a letra "+ letra +". Tente outra.");
            return;
        }
        letrasUsadas[indiceLetrasUsadas] = letra;
        indiceLetrasUsadas++;
        rodadas++;

        boolean letraEncontrada = false;

        for(int i = 0 ; i < palavraSecreta.length(); i++){
            if(palavraSecreta.charAt(i) == letra){
                palavraAdivinhada[i] = letra;
                letraEncontrada = true;
            }
        }
        if(!letraEncontrada){
            System.out.println("Errou!");
            erros++;
            jogador.diminuirTentativas();
        }else{
            System.out.println("Acertou!");
        }
        


    }



//se a letra que verifico ja foi usada 
 private boolean letraJaUsada(char letra){
        for(int i = 0  ; i < indiceLetrasUsadas ; i++){
            if(letrasUsadas[i]== letra){
                return true;
            }
        }
        return false;
    }


    //se jogo acabou e ganhou
    public boolean jogoAcabou(){
        return jogador.getTentativasRestantes() <= 0 || jogoGanho();
    }

    public boolean jogoGanho(){
        return String.valueOf(palavraAdivinhada).equals(palavraSecreta);
    }

//aqui vai todos os getters
    public String getPalavraSecreta(){
        return palavraSecreta;
    }

    public int  getRodadas(){
        return rodadas;
    }

    public int getErros(){
        return erros;
    }

    public char[] getLetraUsada(){
        char[] usadas = new char[indiceLetrasUsadas];
        System.arraycopy(letrasUsadas, 0, usadas , 0 , indiceLetrasUsadas);
        return usadas;
    }
    public char[] getPalavraAdivinhada(){
        return this.palavraAdivinhada;
    }
}
