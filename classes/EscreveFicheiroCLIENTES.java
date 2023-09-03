package pacoteMelvin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EscreveFicheiroCLIENTES {
	
	
//  INSERE DADOS NO FICHEIRO TXT (clientesloja.txt)
	
	public static void gereExecucaoIntroducaoClientesLoja() {
		
		String caminhoCompleto = "M:\\#DOCS/Others/Teste/clientesloja.txt";
		//System.out.println("Inserir Clientes");
		
		int numLinhas = numLinhasFich(caminhoCompleto);
		
		String[] dadosSystemUsers = carregaDadosParaArray(numLinhas,caminhoCompleto);
		
		listarUtilizadores (dadosSystemUsers);
		
		lerTeclEscrFich(caminhoCompleto,dadosSystemUsers);	
		
	}
	public static String lerTecladoDadosCliente(String[] users) {
		 //linha que sera retornada
		 String linhaNovoUser = "-1";
	     
	     // para a leitura do teclado
	     Scanner scanner = new Scanner(System.in);
	     
	     // número gerado automaticamente
		 String dadosClienteNrUnico = ""+geraCodUser(users);
		 
		 System.out.println("Digite o Primeiro Nome: ");
		 String dadosClientePrimeiroNome = scanner.nextLine();
		 System.out.println("Digite o Apelido: ");
		 String dadosClienteApelido = scanner.nextLine();
		 System.out.println("Digite o Documento de Identificação (BI/Passaporte): ");
		 String dadosID = scanner.nextLine();

	
	     // linha a retornar
	     linhaNovoUser = dadosClienteNrUnico+"; "+dadosClientePrimeiroNome+"; "+dadosClienteApelido+"; "+dadosID;
	     
	     return linhaNovoUser;
	}
	// LISTA USERS
	public static void listarUtilizadores(String [] dadosSystemUser) {
		System.out.println("--------------------------------------------------------------");
	    System.out.println("|<<<<<<<<<<<<<<<<<LISTA DOS CLIENTES DA LOJA>>>>>>>>>>>>>>>>>|");
	    System.out.println("--------------------------------------------------------------");
		for(int i=0; i<dadosSystemUser.length; i++)
		{
			System.out.println(dadosSystemUser[i]);
		}
		System.out.println("-------------------------------------------------------------");
	    System.out.println("-------------------------------------------------------------");
	    System.out.println("");
	}
	
	
	
	
	
	// METODOS AUXILIARES
	//Conta o numero de linhas existentes no ficheiro. retorna o numero de linhas
	public static int numLinhasFich(String caminhoCompleto) {
		int numLinhasFich = 0;
		
		try {
		      File meuObjecto = new File(caminhoCompleto);
		      Scanner meuLeitor = new Scanner(meuObjecto);
		      
		      while (meuLeitor.hasNextLine()) {
		    	numLinhasFich++;
		        String linhaLida = meuLeitor.nextLine();
		      }
		      meuLeitor.close();
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("OCORREU UM ERRO.");
		      e.printStackTrace();
	
		    }
		
		return numLinhasFich;
	}
	
	// carrega os dados do ficheiro para o array. Retorna o array.
	public static String[] carregaDadosParaArray(int numLinhasFich, String caminhoCompleto) {
		
		String[] dadosUsers = new String [numLinhasFich];
		int cont =0;
		try {
		      File meuObjecto = new File(caminhoCompleto);
		      Scanner meuLeitor = new Scanner(meuObjecto);
		      
		      while (meuLeitor.hasNextLine()) {
		    	
		        String linhaLida = meuLeitor.nextLine(); 
		        dadosUsers[cont] = linhaLida;
		        
		        cont++;
		      }
		      meuLeitor.close();
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("OCORREU UM ERRO.");
		      e.printStackTrace();
	
		    }
		
		return dadosUsers;
	}
	
	
	public static void lerTeclEscrFich(String caminhoEficheiro, String[] users1) {
		 Scanner lerDoTeclado = new Scanner(System.in);
	     String linhaLida = "";
	     
	     String[] users2 = new String [users1.length+1];
	     String ultimoCodigo = users1[users1.length-1];
		     
		     
	     String dadosNovoUser = lerTecladoDadosCliente(users1);
		 //System.out.println("dados do novo utilizador "+dadosNovoUser);
		 
	     // copia elementos de um array para outro
	     for (int i=0; i<users1.length; i++) {
	    	 users2[i] = users1[i];
	     }
		     
	     users2 [users2.length-1] = dadosNovoUser;     
	     escreveNoFich(caminhoEficheiro, users2);	
	}
	
	 
	
    // Gera código para o novo utilizador
	
    public static int geraCodUser(String[] users) {
    	int indiceUltimoUser = users.length-1;
    	String dadosUltimoUser = users[indiceUltimoUser];
    	
    	int codUltimoUser = -1;
    	int novoCod = -1;
    	String numUser = "-1";
    	
 	    StringTokenizer divideAFrase = new StringTokenizer(dadosUltimoUser, ";");
 			
 	    while (divideAFrase.hasMoreElements())
 	    {
 	    	numUser = divideAFrase.nextToken();
 	    	break;
 	    }
 	    
    	 codUltimoUser = deStringParaInt(numUser);
    	 novoCod = codUltimoUser + 1;
    
    	 return novoCod;
    }
    
    
    
	// Converte do tipo String para o tipo Int
    
    public static int deStringParaInt(String numAconverter) 
    {   int numConv = -1;
    
    	try{
    		numConv = Integer.parseInt(numAconverter);
    	}
    	catch (NumberFormatException ex){
    		ex.printStackTrace();
    	  }
    	
    	return numConv;
    }
    

	// Escreve no ficheiro .txt
	public static void escreveNoFich(String caminhoEfich, String[] users) {   
		try {
			FileWriter meuEscritor = new FileWriter(caminhoEfich);
			  
			for (int i=0; i<users.length; i++) {
			  meuEscritor.write(users[i] + "\n");
			}
			  
			meuEscritor.close();
			System.out.println("");
			System.out.println("SUCESSO AO ESCREVER NO FICHEIRO.");
			} catch (IOException e) {
				      System.out.println("OCORREU UM ERRO.");					      
				      e.printStackTrace();
			}					
	 }
	
	
	
//  INSERE DADOS NO FICHEIRO TXT (vendasLivros.txt) 
	
	public static void escreverEmFicheiroVendasLivros() {
		try {
			String caminhoCompleto = "M:\\#DOCS/Others/Teste/vendasLivros.txt";    
			FileWriter meuEscritor = new FileWriter(caminhoCompleto, true);
			
			
			//Input dos Dados do Livro
			Scanner scanner = new Scanner(System.in);
			String vendaLivroNrUnico = "Vai ser gerado automaticamente";
			System.out.println("Introduza o Título do livro: ");
			String vendaLivroTitulo = scanner.nextLine();
			System.out.println("Introduza o Ano do livro: ");
			String vendaLivroAno = scanner.nextLine();
			System.out.println("Introduza o Autor do livro: ");
			String vendaLivroAutor = scanner.nextLine();
			System.out.println("Introduza Preço: ");
			String vendaLivroPreco = scanner.nextLine();
			System.out.println("Introduza o valor recebido: ");
			String vendaLivroValorRec = scanner.nextLine();
			String vendaLivroChange = "Espera método para gerar os trocos";
			
			String DadosLivro = vendaLivroNrUnico +";"+ vendaLivroTitulo +";"+ vendaLivroAno +";"+ vendaLivroAutor +";"+ vendaLivroPreco +";"+ vendaLivroValorRec +";"+ vendaLivroChange;
			
			
			//Mostra os Dados Inseridos
			StringTokenizer divideAFrase = new StringTokenizer(DadosLivro, ";");
			
			String[] mostraDadosLivro = new String[8];
			
			while(divideAFrase.hasMoreTokens()) {
				System.out.println("" );
				System.out.println("|===============================DADOS INSERIDOS==============================|");
				mostraDadosLivro[0] = divideAFrase.nextToken();
				System.out.println("|------> Número Único da Venda do Livro (GERADO AUTOMATICAMENTE): " + mostraDadosLivro[0]);
				mostraDadosLivro[1] = divideAFrase.nextToken();
				System.out.println("|------> Título: " + mostraDadosLivro[1]);
				mostraDadosLivro[2] = divideAFrase.nextToken();
				System.out.println("|------> Ano: " + mostraDadosLivro[2]);
				mostraDadosLivro[3] = divideAFrase.nextToken();
				System.out.println("|------> Autor: " + mostraDadosLivro[3]);
				mostraDadosLivro[4] = divideAFrase.nextToken();
				System.out.println("|------> Preço: " + mostraDadosLivro[4]);
				mostraDadosLivro[5] = divideAFrase.nextToken();
				System.out.println("|------> Valor recebido: " + mostraDadosLivro[5]);
				mostraDadosLivro[6] = divideAFrase.nextToken();
				System.out.println("|------> Trocos: " + mostraDadosLivro[6]);
				System.out.println("");
			}
			
			DadosLivro = "\n" + vendaLivroNrUnico +";"+ vendaLivroTitulo +";"+ vendaLivroAno +";"+ vendaLivroAutor +";"+ vendaLivroPreco +";"+ vendaLivroValorRec +";"+ vendaLivroChange;
			meuEscritor.write(DadosLivro);
			meuEscritor.close();
			          
		} catch (IOException e) {
		    System.out.println("HOUVE UM ERRO.");
		    e.printStackTrace();
		}
			
	}
	
	

	

}
