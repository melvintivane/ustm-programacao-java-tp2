package pacoteMelvin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EscreveFicheiroVENDALIVRO {
//  INSERE DADOS NO FICHEIRO TXT (clientesloja.txt)
	
	public static void gereExecucaoIntroducaoVendasLivros() {
		
		String caminhoCompleto = "M:\\#DOCS/Others/Teste/vendasLivros.txt";
		
		
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
	     
	    // número gerado automaticamente
	    String vendaLivroNrUnico = ""+geraCodUser(users);
		
		
		System.out.println("INTRODUZA O TÍTULO DO LIVRO: ");
		String vendaLivroTitulo = scanner.nextLine();
		System.out.println("INTRODUZA O ANO DO LIVRO: ");
		String vendaLivroAno = scanner.nextLine();
		System.out.println("INTRODUZA O AUTOR DO LIVRO: ");
		String vendaLivroAutor = scanner.nextLine();
		System.out.println("INTRODUZA O PREÇO: ");
		String vendaLivroPreco = scanner.nextLine();
		System.out.println("INTRODUZA O VALOR ENTREGUE PELO CLIENTE: ");
		String vendaLivroValorRec = scanner.nextLine();
		
		
		int x = deStringParaInt(vendaLivroValorRec);
		int y = deStringParaInt(vendaLivroPreco);
		int res = geraTrocos(x, y);
		
		// número gerado automaticamente
		String vendaLivroChange = deIntParaString(res);;
		
		
		
		linhaNovoUser = vendaLivroNrUnico +"; "+ vendaLivroTitulo +"; "+ vendaLivroAno +"; "+ vendaLivroAutor +"; "+ vendaLivroPreco +"; "+ vendaLivroValorRec +"; "+ vendaLivroChange;
	     
	    return linhaNovoUser;
	}
	
	
	// LISTA OS LIVROS
	public static void listarUtilizadores(String [] dadosSystemUser) {
		System.out.println("-------------------------------------------------------------");
	    System.out.println("|<<<<<<<<<<LISTA DOS REGISTROS DE VENDAS DE LIVROS>>>>>>>>>>|");
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
    
    public static int geraTrocos(int x, int y) {
    	int trocos = x - y;
    	
    	return trocos;    	
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
    
// Converte do tipo Int para o tipo String
    
    public static String deIntParaString(int numAconverter) 
    {   String numConv = "";
    
    	try{
    		numConv = Integer.toString(numAconverter);
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
