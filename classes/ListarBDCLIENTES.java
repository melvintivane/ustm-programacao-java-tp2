package pacoteMelvin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ListarBDCLIENTES {
	
	
	//LISTA FICHEIROS DA BASE DE DADOS (GESTÃO DOS CLIENTES)
	public static String[] leFicheiroGuardaNoArray() {
		
		String linha[] = new String[20];
		int i = 0;
		
		try {
			File myObj = new File("M:\\#DOCS/Others/Teste/clientesloja.txt");
			Scanner myReader = new Scanner(myObj);
			
			while(myReader.hasNextLine()) {
				String data = myReader.nextLine();
				linha[i] = data;
				//System.out.println(linha[i]);
				i++;
			}
			myReader.close();	
		}catch(FileNotFoundException e){
			System.out.println("OCORREU UM ERRO.");
			e.printStackTrace();
		}
		
		for (int j = 0; j<linha.length; j++) {
			System.out.println("CONTEÚDO DA BASE DE DADOS "+j+": " +"ID => "+ linha[j]);
		}
		
		return linha;		
	}
	

}
