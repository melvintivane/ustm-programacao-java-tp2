package pacoteMelvin;


public class GereExecucao {
	
//   GERE A EXECU��O (1)
	 public static void gereExecuta1() {
		 
		Menus metodo01 = new Menus();
		InputOpcaoMenu metodo02 = new InputOpcaoMenu();
		GereEscolhasDosMenus metodo03 = new GereEscolhasDosMenus();
		  
		metodo01.menuPrincipal();
		  
		//L� Op��o do Teclado
		int opcao = metodo02.leOpcaoDoMenu();
		
		//Gere a Op��o Escolhida
		metodo03.gereEscolhas(opcao);
		  
	}
	 
	 
//   GERE A EXECU��O (2) ou M�TODO PARA FINALIZAR A EXECU��O
	 public static void gereExecuta2() {
		 
		 Menus metodo01 = new Menus();
		 InputOpcaoMenu metodo02 = new InputOpcaoMenu();
		 GereEscolhasDosMenus metodo03 = new GereEscolhasDosMenus();
			
		 int opcao = -1;      
	        
	     while (opcao != 7) { //Enquanto a vari�vel OPCAO n�o receber 7, o programa executa. 
	        opcao = -1;
	        metodo01.menuPrincipal();	
			opcao = metodo02.leOpcaoDoMenu();
				
	        if (opcao !=7) {
	        	metodo03.gereEscolhas(opcao);
	        }else{
				System.out.println("");
			    System.out.println("-------------------------------------------------------------");
			    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<Fim do Programa>>>>>>>>>>>>>>>>>>>>>>>");
			    System.out.println("-------------------------------------------------------------");
			}
	      }
			
	 }

}
