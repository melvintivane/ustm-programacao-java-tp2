package pacoteMelvin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AlteraFicheiroLIVRO {
public static void gereExecucaoAlteracaoLivros() {
		
		String caminhoCompleto = ("M:\\#DOCS/Others/Teste/livrosloja.txt");
		int numLinhas = numLinhasFich(caminhoCompleto);
		
		String[] dadosSystemUser = carregaDadosParaArray(numLinhas,caminhoCompleto);
		
		listarUtilizadoresCliente(dadosSystemUser);
		
		String codCli = lerCodUserAalterar();
		
		int indiceAalterar = encontraIndiceDoCodUser (dadosSystemUser,codCli);
		
		if (indiceAalterar != -1) {
			String novaLinha = lerTecladoNovosDadosLinha(codCli);
			
			dadosSystemUser [indiceAalterar] = novaLinha;
			escreveNoFich(caminhoCompleto,dadosSystemUser);
		}else{
			System.out.println("CÓDIGO DO LIVRO NÃO EXISTENTE NA BASE DE DADOS.");
		}
		
	}
	
	//REMOVE CLIENTE
	public static void listarUtilizadoresCliente(String [] dadosSystemUser) {
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
		
		
		public static String lerCodUserAalterar() {
			String codUserSist;
			
			Scanner lerDoTeclado = new Scanner(System.in);
			
			System.out.println("ESCREVA O CÓDIGO DO LIVRO A SER ALTERADO: ");
			codUserSist = lerDoTeclado.next();
			System.out.println("CÓDIGO INTRODUZIDO: "+codUserSist);
			
			return codUserSist;
		}
		
		
		
	    // Gera codigo para o novo utilizador
	    public static int geraCodUser(String[] users) 
	    {   int indiceUltimoUser = users.length-1;
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
		  System.out.println("SUCESSO AO ALTERAR LIVRO.");
						      
		  } catch (IOException e) {
			      System.out.println("OCORREU UM ERRO.");					      
			      e.printStackTrace();
		 }
							
	}
		  
	// procura o indice do array com base no codigo do utilizador
	public static int encontraIndiceDoCodUser (String []dadosSystemUser, String codUserAlt){
		int indiceToAlter = -1;
		String codUserNoFich = "0";

		int compara = -1;
		
		for (int i=0; i<dadosSystemUser.length; i++){
			
		StringTokenizer divideAFrase = new StringTokenizer(dadosSystemUser[i],";");
			
		 while (divideAFrase.hasMoreElements()){
			    codUserNoFich = divideAFrase.nextToken();
			    compara = codUserNoFich.compareTo(codUserAlt);
	 	    	break;
	 	 }
		 
		 if (compara==0) {
			 System.out.println("CÓDIGO EXISTENTE.");
			 System.out.println("");
			 indiceToAlter = i;
			 break; 
		 }
	}
		
		return indiceToAlter;
	}
	
	// le do teclado e compoe uma nova linha para inserir no array
	public static String lerTecladoNovosDadosLinha(String codCli) {
		//linha que sera retornada
		String linhaNovoUser = "";
	     
	    // para a leitura do teclado
	    Scanner scanner = new Scanner(System.in);
	     
	    // número gerado automaticamente
	    String dadosLivroNrUnico = codCli;
		
		//Input dos Dados do Livro
		System.out.println("INTRODUZA O TÍTULO DO LIVRO: ");
		String dadosLivroTitulo = scanner.nextLine();
		System.out.println("INTRODUZA O SUBTÍTULO DO LIVRO: ");
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
}
