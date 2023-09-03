package pacoteMelvin;


public class GereEscolhasDosMenus {

//	 GERE ESCOLHAS DO MENU: PRINCIPAL
	 public static void gereEscolhas(int opcao){
		 
		 Menus methodMR = new Menus();
	
		 
	     int op = opcao;
	   
	     switch (op){
	     	case (1): methodMR.menuGerirClientes();
		    break;
		  
		    case (2): methodMR.menuGerirVendasLivros();
		    break;
		  
		    case (3): methodMR.menuGerirLivros();
		    break;
		  
		    case (4): methodMR.menuGerirUsers();
		    break;
		  
		    case (5): methodMR.menuGerirClientes();
		    break;
		  
		    case (6): methodMR.menuGerirVendasLivros();
		    break;
		    
		    case (7):
		    break;
		}

	 }

	 
//	 GERE ESCOLHAS DO MENU: GESTÃO DOS CLIENTES
	 public static void escolhasMenuGerirClientes(int opcao){
		 
		 Menus methodMR = new Menus();
		 EscreveFicheiroCLIENTES metodo01 = new EscreveFicheiroCLIENTES();
		 ListarBDCLIENTES metodo02 = new ListarBDCLIENTES();
		 ApagaFicheiroCLIENTES metodo03 = new ApagaFicheiroCLIENTES();
		 AlteraFicheiroCLIENTES metodo04 = new AlteraFicheiroCLIENTES();

	     int op = opcao;
	   
	     switch (op){ 
	     	case (1): metodo01.gereExecucaoIntroducaoClientesLoja();
		    break;
		  
		    case (2): metodo04.gereExecucaoAlteracaoCliente();
		    break;
		  
		    case (3): metodo03.gereExecucaoRemocaoCliente();
		    break;
		  
		    case (4): System.out.println("Por desenvolver3");
		    break;
		  
		    case (5): metodo02.leFicheiroGuardaNoArray();
		    break;
		  
		    case (6):
		    break;
		}

	 }
	 
	 
//	 GERE ESCOLHAS DO MENU: GESTÃO DE VENDAS DOS LIVROS
	 public static void escolhasMenuGerirVendasLivros(int opcao){
		 
		 Menus methodMR = new Menus();
		 ListarBDVENDASLIVROS metodo01 = new ListarBDVENDASLIVROS();
		 EscreveFicheiroVENDALIVRO metodo02 = new EscreveFicheiroVENDALIVRO();
		 AlteraFicheiroVENDALIVRO metodo03 = new AlteraFicheiroVENDALIVRO();
		 ApagaFicheiroVENDALIVRO metodo04 = new ApagaFicheiroVENDALIVRO();
		 
		 
	     int op = opcao;
	   
	     switch (op)
		  { case (1): metodo02.gereExecucaoIntroducaoVendasLivros();
		    break;
		  
		    case (2): metodo03.gereExecucaoAlteracaoVendasLivros();
		    break;
		  
		    case (3): metodo04.gereExecucaoRemocaoVendasLivro();
		    break;
		  
		    case (4): metodo01.leFicheiroGuardaNoArrayVendasLivros();
		    break;
		  
		    case (5): System.out.println("Por desenvolver555");
		    break;
		  
		    case (6): System.out.println("Por desenvolver666");
		    break;
		    
		    case (7):
		    break;
		}

	 }
	
	
//	 GERE ESCOLHAS DO MENU: GESTÃO DOS LIVROS
	 public static void escolhasMenuGerirLivros(int opcao){
		 
		 Menus methodMR = new Menus();
		 EscreveFicheiroLIVRO metodo01 = new EscreveFicheiroLIVRO();
		 AlteraFicheiroLIVRO metodo02 = new AlteraFicheiroLIVRO();
		 ApagaFicheiroLIVRO metodo03 = new ApagaFicheiroLIVRO();
		 
		 
		
		 
	     int op = opcao;
	   
	     switch (op){
	     
	     
	     			
	     	case (1): metodo01.gereExecucaoIntroducaoLivros();
		    break;
		    
	     	case (2): metodo02.gereExecucaoAlteracaoLivros();
			break;
		  
		    case (3): metodo03.gereExecucaoRemocaoLivro();
		    break;
		  
		    case (4):
		    break;
		}

	 }
	 
//	 GERE ESCOLHAS DO MENU: GESTÃO DOS UTILIZADORES DO SISTEMA
	 public static void escolhasMenuGerirUsers(int opcao){
		 
		 Menus methodMR = new Menus();
		 EscreveFicheirosUSERS metodo01 = new EscreveFicheirosUSERS();
		 AlteraFicheiroUSERS metodo02 = new AlteraFicheiroUSERS();
		 ApagaFicheiroUSERS metodo03 = new ApagaFicheiroUSERS();
		 
	     int op = opcao;
	   
	     switch (op){ 
	     	case (1): metodo01.gereExecucaoIntroducaoUsers();
		    break;
		  
		    case (2): metodo02.gereExecucaoAlteracaoUsers();
		    break;
		  
		    case (3): metodo03.gereExecucaoRemocaoUsers();
		    break;
		  
		    case (4): 
		    break;
		}

	 }
	
	
}
