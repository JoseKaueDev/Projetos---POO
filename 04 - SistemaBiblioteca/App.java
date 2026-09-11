
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
                
        while(true){
            System.out.println("\nSISTEMA DE EMPRÉSTIMO DE LIVROS "); 
            System.out.println("1. Criar livro"); 
            System.out.println("2. Criar usuário"); 
            System.out.println("3. Realizar empréstimo"); 
            System.out.println("4. Devolver livro"); 
            System.out.println("5. Ver multas por usuário"); 
            System.out.println("6. Sair"); 
            System.out.print("Escolha uma opção: "); 
            int opcao = scanner.nextInt(); 
            scanner.nextLine();

           switch(opcao){
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    int isbn = scanner.nextInt();
                    livros.add(new Livro(titulo , autor , isbn));
                    System.out.println("Livro criado");
                    break;

                case 2:
                    System.out.print("Nome do usuario: ");
                    String nome = scanner.nextLine();
                    System.out.print("Matricula: ");
                    int matricula = scanner.nextInt();
                    usuarios.add(new Usuario(nome , matricula));
                    System.out.println("Usuario cadastrado");
                    break;

                case 3:
                     if(usuarios.isEmpty() || livros.isEmpty()){
                        System.out.println("Cadastre livros e usuarios primeiro");
                        break;
                     }   
                     System.out.println("Usuarios: ");
                     for(int i = 0; i < usuarios.size(); i++){
                        System.out.println(i + " - " + usuarios.get(i).getNome());
                     }
                     System.out.print("Escolha o usuario: ");
                     int indexUsuario = scanner.nextInt();

                    System.out.println("Livros disponiveis: ");
                    for(int i = 0; i < livros.size(); i++){
                        if(livros.get(i).getDisponivel()){
                            System.out.println(i + " - " + livros.get(i).getTitulo());
                        }
                    }
                    System.out.print("Escolha o livro: ");
                    int indexLivro = scanner.nextInt();
                    
                    Emprestimo emprestimo = new Emprestimo();
                    boolean sucesso = emprestimo.criarEmprestimo(usuarios.get(indexUsuario), livros.get(indexLivro), LocalDate.now());

                    if(sucesso){
                        emprestimos.add(emprestimo);
                        System.out.println("Emprestimo deu certo");
                    }
                    break;
                case 4: 
                    System.out.println("Devolver o livro");
                    for(int i = 0; i < emprestimos.size() ; i++){
                        Emprestimo aux = emprestimos.get(i);
                        if(!aux.seFinalizou()){
                            System.out.println(i + " Livro: " + aux.getLivro().getTitulo() + " | Usuario: "+ aux.getUsuario().getNome());

                        }
                    }
                    System.out.print("Escolha o emprestimo para devolucao: "); 
                    int empIndex = scanner.nextInt(); 
                    Emprestimo emp = emprestimos.get(empIndex); 
                    emp.devolverLivro(LocalDate.now()); 
                    emp.getUsuario().decEmprestimos(); 
                    System.out.println("Livro devolvido!"); 
                    break; 

                case 5:
                    System.out.println("Multas acumuladas:"); 
                    for (Usuario u : usuarios) { 
                        double totalMulta = 0.0; 
                        for (Emprestimo aux : emprestimos) { 
                            if (aux.seFinalizou() && aux.getUsuario() == u){ 
                                totalMulta += aux.getMulta(); 
                            } 
                        } 
                        System.out.println("Usuário: " + u.getNome() + 
" | Multa total: R$ " + totalMulta); 
                    } 
                    break; 


                case 6:
                    System.out.println("Encerrando o programa");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalido");

           }
        }
    }
}
            
            
            
         
    

