package pacoteMelvin;

import java.io.File;
import java.io.IOException;

public class CriaFicheirosTXT {
		
//   CRIA O FICHEIRO livrosloja.txt	 
	 public static void livrosLoja() {
			
		String caminhoCompleto = "M:\\#DOCS/Others/Teste/livrosloja.txt";
		
		try {
		    File meuObjecto = new File(caminhoCompleto);
		    if (meuObjecto.createNewFile()) {
		       System.out.println("Ficheiro Criado: " + meuObjecto.getName());  
		    }else {
		       System.out.println("Ficheiro já existente.");
		    } 
		}catch (IOException e) {
		    System.out.println("Houve um erro.");
		    e.printStackTrace();
		}

	 }
		 

//	 CRIA O FICHEIRO clientesloja.txt	 
	 public static void clientesLoja() {
				
		String caminhoCompleto = "M:\\#DOCS/Others/Teste/clientesloja.txt";
			
		try {
			File meuObjecto = new File(caminhoCompleto);
			if (meuObjecto.createNewFile()) {
			   System.out.println("Ficheiro Criado: " + meuObjecto.getName());  
			}else {
			   System.out.println("Ficheiro já existente.");
			}
		}catch (IOException e) {
			System.out.println("Houve um erro.");
			e.printStackTrace();
		}

	 }
	 
	 
//	 CRIA O FICHEIRO userssistema.txt	 
	 public static void usersSistema() {
				
		String caminhoCompleto = "M:\\#DOCS/Others/Teste/userssistema.txt";
			
		try {
			File meuObjecto = new File(caminhoCompleto);
			if (meuObjecto.createNewFile()) {
			   System.out.println("Ficheiro Criado: " + meuObjecto.getName());  
			}else {
			   System.out.println("Ficheiro já existente.");
			}
		}catch (IOException e) {
			System.out.println("Houve um erro.");
			e.printStackTrace();
		}

	 }
		 

}
