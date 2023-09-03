package pacoteMelvin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ApagaFicheiroCLIENTES {

    // REMOVE CLIENTE
	public static void gereExecucaoRemocaoCliente() {
		String caminhoCompleto = ("M:\\#DOCS/Others/Teste/clientesloja.txt");
		int numLinhas = numLinhasFichCliente(caminhoCompleto);
		
		String[] dadosSystemUser = carregaDadosParaArray(numLinhas,caminhoCompleto);
		
		listarUtilizadoresCliente(dadosSystemUser);
		
		String codCli = lerCodUserAremoverCliente();
		
		int indiceAremover = encontraIndiceDoCodUser (dadosSystemUser,codCli);
		
		if (indiceAremover != -1) {
			dadosSystemUser[indiceAremover] = "-100";
			escreveNoFich2Cliente(caminhoCompleto,dadosSystemUser);
			
		}else{
			System.out.println("CÓDIGO NÃO EXISTENTE NA BASE DE DADOS.");
		}
	}


	// REMOVE CLIENTE
	public static void listarUtilizadoresCliente(String [] dadosSystemUser) {
		System.out.println("-------------------------------------------------------------");
	    System.out.println("|<<<<<<<<<<<<<<<<<LISTA DOS CLIENTES DA LOJA>>>>>>>>>>>>>>>>|");
	    System.out.println("-------------------------------------------------------------");
		for(int i=0; i<dadosSystemUser.length; i++)
		{
			System.out.println(dadosSystemUser[i]);
		}
		System.out.println("-------------------------------------------------------------");
	    System.out.println("-------------------------------------------------------------");
	    System.out.println("");
	}

	
	// REMOVE CLIENTE
	//Conta o numero de linhas existentes no ficheiro. retorna o numero de linhas
	public static int numLinhasFichCliente(String caminhoCompleto) {
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
		      System.out.println("OCORREU UM ERRO");
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
		      System.out.println("Ocorreu um erro.");
		      e.printStackTrace();
		}
		
		return dadosUsers;
	}
	
	
	// REMOVE CLIENTE		
	// le o codigo do utilizador (utilizador a ser removido)
	public static String lerCodUserAremoverCliente() {
		String codUserSist;
		
		Scanner lerDoTeclado = new Scanner(System.in);
		
		System.out.println("ESCREVA O CÓDIGO DO CLIENTE A SER REMOVIDO: ");
		codUserSist = lerDoTeclado.next();
		System.out.println("CÓDIGO INTRODUZIDO: "+codUserSist);
		
		return codUserSist;
	}


	// REMOVE CLIENTE
	// Escreve no ficheiro .txt
	public static void escreveNoFich2Cliente(String caminhoEfich, String[] users) {   
		try {
			FileWriter meuEscritor = new FileWriter(caminhoEfich);
			  
			for (int i=0; i<users.length; i++) {
			  if (users[i].compareTo("-100") !=0) {
				  meuEscritor.write(users[i] + "\n");
			  }
			}
			  
			meuEscritor.close();      
			System.out.println("SUCESSO AO REMOVER CLIENTE.");
						      
			} catch (IOException e) {
			  System.out.println("OCORREU UM ERRO.");					      
			  e.printStackTrace();
		}			
	}
	
	
			  
	// procura o indice do array do utilizador (utilizador a ser removido)
	public static int encontraIndiceDoCodUser (String []dadosSystemUser, String codUserAlt){
		int indiceToRemove = -1;
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
				indiceToRemove = i;
				break; 
			}
		}
			
		return indiceToRemove;
	}

}
