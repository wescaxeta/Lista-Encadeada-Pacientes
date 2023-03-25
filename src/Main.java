import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
	    ListaEncadeada listaEncadeada = new ListaEncadeada();
	    int opcao;
	    long telefone;
	    long cpf;
	    int plano;
	    String nome;
	    System.out.print("\nLista Encadeada - Cadastro de Pacientes");
	    do {
	        System.out.print("\n***********************************");
	        System.out.print("\nEntre com a opcao:");
			System.out.print("\n----1: Inserir");
			System.out.print("\n----2: Excluir");
			System.out.print("\n----3: Pesquisar");
			System.out.print("\n----4: Exibir em ordem crescente");
			System.out.print("\n----5: Exibir em ordem decrescente");
			System.out.print("\n----6: Importar arquivo");
			System.out.print("\n----7: Salvar em arquivo");
			System.out.print("\n----8: Sair do programa");
			System.out.print("\n***********************************");
			System.out.print("\n-> ");
			opcao = sc.nextInt();
			sc.nextLine();
			switch(opcao) {
			 	case 1: {
			 		   System.out.print("\nInforme o nome do paciente: ");
			 		   nome = sc.nextLine();
			 		   System.out.print("\nInforme o cpf: ");
				       cpf = sc.nextLong();
				       System.out.print("\nInforme o telefone: ");
				       telefone = sc.nextLong();
				       System.out.print("\nInforme o plano (1-Unimed/2-Amil/3-Outro): ");
				       plano = sc.nextInt();
				       listaEncadeada.adicionaOrdenado(new Paciente(nome, cpf, telefone, plano));
				       break;
				}
				case 2: {
					   System.out.print("\nInforme o cpf: ");
			 		   cpf = sc.nextLong();
				       if (!listaEncadeada.remover(new Paciente(cpf)))
		                  System.out.print("\nPessoa não encontrada!");
				       else
				    	   System.out.print("\nExcluído com sucesso!");
				       break;
				}
				case 3: {
					   System.out.print("\nInforme o cpf: ");
			 		   cpf = sc.nextLong();
			 		   Paciente p = listaEncadeada.busca(new Paciente(cpf));
		      	       if(p != null )
				          listaEncadeada.imprimir(p);
				       else 
				          System.out.print("\nPaciente nao encontrado!");
				       break;
				}	 
				case 4: {
			      listaEncadeada.imprimirCrescente();
			      break; 
				}
				case 5: {
			      listaEncadeada.imprimirDecrescente();
			      break; 
				}
				case 6: {
					try {
						listaEncadeada = Arquivo.lerArquivo();
						System.out.println("\nImportado com sucesso!");
					} catch (IOException e) {
						System.out.println("\nErro ao ler arquivo. Detalhes: " + e.getMessage());
					}
					break; 
				}
				case 7: {
					try {
						Arquivo.salvarArquivo(listaEncadeada, true);
						System.out.print("\nSalvo com sucesso!");
					} catch (IOException e) {
						System.out.println("\nErro ao gerar arquivo. Detalhes: " + e.getMessage());
					}
					break; 
				}
				case 8: {
				      break; 
				}
	        }
	    } while(opcao != 8);

	  }
}
