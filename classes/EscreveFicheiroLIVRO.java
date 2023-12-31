package pacoteMelvin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EscreveFicheiroLIVRO {
	
//  INSERE DADOS NO FICHEIRO TXT (clientesloja.txt)
	
	public static void gereExecucaoIntroducaoLivros() {
		
		String caminhoCompleto = "M:\\#DOCS/Others/Teste/livrosloja.txt";
		
		
		int numLinhas = numLinhasFich(caminhoCompleto);
		
		String[] dadosSystemUsers = carregaDadosParaArray(numLinhas,caminhoCompleto);
		
		listarUtilizadores (dadosSystemUsers);
		
		lerTeclEscrFich(caminhoCompleto,dadosSystemUsers);	
		
	}
	public static String lerTecladoDadosCliente(String[] users) {
		//linha que sera retornada
		String linhaNovoUser = "";
	     
	    // para a leitura do teclado
	    Scanner scanner = new Scanner(System.in);
	     
	    // n�mero gerado automaticamente
	    String dadosLivroNrUnico = ""+geraCodUser(users);
		
		//Input dos Dados do Livro
		System.out.println("INTRODUZA O T�TULO DO LIVRO: ");
		String dadosLivroTitulo = scanner.nextLine();
		System.out.println("INTRODUZA O SUBT�TULO DO LIVRO: ");
		String dadosLivroSubtitulo = scanner.nextLine();
		System.out.println("INTRODUZA O ANO DO LIVRO: ");
		String dadosLivroAno = scanner.nextLine();
		System.out.println("INTRODUZA O AUTOR DO LIVRO: ");
		String dadosLivroAutor = scanner.nextLine();
		System.out.println("INTRODUZA A EDITORA DO LIVRO: ");
		String dadosLivroEditora = scanner.nextLine();
		System.out.println("INTRODUZA O ISBN DO LIVRO: ");
		String dadosLivroISBN = scanner.nextLine();
		
		linhaNovoUser = dadosLivroNrUnico +"; "+ dadosLivroTitulo +"; "+ dadosLivroSubtitulo +"; "+ dadosLivroAno +"; "+ dadosLivroAutor +"; "+ dadosLivroEditora +"; "+ dadosLivroISBN;
		
	     
	    return linhaNovoUser;
	}
	
	
	// LISTA OS LIVROS
	public static void listarUtilizadores(String [] dadosSystemUser) {
		System.out.println("-------------------------------------------------------------");
	    System.out.println("|<<<<<<<<<<<<<<<<<<<<<<LISTA DOS LIVROS>>>>>>>>>>>>>>>>>>>>>|");
	    System.out.println("-------------------------------------------------------------");
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
	
	 
	
    // Gera c�digo para o novo utilizador
	
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

}
