package pacoteMelvin;


public class Menus {
	
//	MENU PRINCIPAL
	public void menuPrincipal(){
	
	     System.out.println("");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("|<<<<<<<<<<<<<<<<<<<<<<MENU PRINCIPAL>>>>>>>>>>>>>>>>>>>>>>>|");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("");
	     System.out.println("|-------------> 1 - Gest�o dos Clientes");
	     System.out.println("|-------------> 2 - Gest�o de Vendas de Livros");
	     System.out.println("|-------------> 3 - Gest�o dos Livros");
	     System.out.println("|-------------> 4 - Gest�o dos Utilizadores do Sistema");
	     System.out.println("|-------------> 5 - Menu Gest�o dos Clientes");
	     System.out.println("|-------------> 6 - Menu Gest�o de Vendas de Livros");
	     System.out.println("|-------------> 7 - Sair do Programa");
	     System.out.println("");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("");
	     System.out.println("");
		  
	}
	
	
//	MENU GEST�O DOS CLIENTES
	public void menuGerirClientes(){
		
		 InputOpcaoMenu metodo01 = new InputOpcaoMenu();
		 GereEscolhasDosMenus metodo02 = new GereEscolhasDosMenus();
	
	     System.out.println("");
	     System.out.println("--------------------------------------------------------------");
	     System.out.println("|<<<<<<<<<<<<<<<<<<<<GEST�O DOS CLIENTES>>>>>>>>>>>>>>>>>>>>>|");
	     System.out.println("--------------------------------------------------------------");
	     System.out.println("");
	     System.out.println("|-------------> 1 - Inserir Cliente");
	     System.out.println("|-------------> 2 - Alterar Dados do Cliente");
	     System.out.println("|-------------> 3 - Remover Cliente");
	     System.out.println("|-------------> 4 - //Procurar Cliente pelo N�mero");
	     System.out.println("|-------------> 5 - Listar Clientes");
	     System.out.println("|-------------> 6 - Voltar ao Menu Principal");
	     System.out.println("");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("");
	     System.out.println("");
	     
	     //L� Op��o do Teclado
	     int opcao = metodo01.leOpcaoDoMenu();
	     
	     //Gere as Op��es Escolhidas
	     metodo02.escolhasMenuGerirClientes(opcao);
	    
	}
	
	
//	MENU GEST�O DE VENDAS DOS LIVROS
	public void menuGerirVendasLivros(){
		
		 InputOpcaoMenu metodo01 = new InputOpcaoMenu();
		 GereEscolhasDosMenus metodo02 = new GereEscolhasDosMenus();
		 
	
	     System.out.println("");
	     System.out.println("--------------------------------------------------------------");
	     System.out.println("|<<<<<<<<<<<<<<<<GEST�O DE VENDAS DOS LIVROS>>>>>>>>>>>>>>>>>|");
	     System.out.println("--------------------------------------------------------------");
	     System.out.println("");
	     System.out.println("|-------------> 1 - Registar Venda do Livro");
	     System.out.println("|-------------> 2 - Alterar Registo de Venda do Livro");
	     System.out.println("|-------------> 3 - Remover Registo de Venda Livro");
	     System.out.println("|-------------> 4 - Listar Livros");
	     System.out.println("|-------------> 5 - //Procurar Livro pelo Ano");
	     System.out.println("|-------------> 6 - //Procurar Livro pelo T�tulo");
	     System.out.println("|-------------> 7 - Voltar ao Menu Principal");
	     System.out.println("");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("");
	     System.out.println("");
	     
	     
	     //L� Op��o do Teclado
	     int opcao = metodo01.leOpcaoDoMenu();
	     
	     //Gere as Op��es Escolhidas
	     metodo02.escolhasMenuGerirVendasLivros(opcao);
	     
	}
	
	
//	MENU GEST�O DOS LIVROS
	public void menuGerirLivros(){
		
		 InputOpcaoMenu metodo01 = new InputOpcaoMenu();
		 GereEscolhasDosMenus metodo02 = new GereEscolhasDosMenus();
		 
	
	     System.out.println("");
	     System.out.println("--------------------------------------------------------------");
	     System.out.println("|<<<<<<<<<<<<<<<<<<<<<GEST�O DOS LIVROS>>>>>>>>>>>>>>>>>>>>>>|");
	     System.out.println("--------------------------------------------------------------");
	     System.out.println("");
	     System.out.println("|-------------> 1 - Inserir Livro");
	     System.out.println("|-------------> 2 - Alterar Dados do Livro");
	     System.out.println("|-------------> 3 - Remover Livro");
	     System.out.println("|-------------> 4 - Voltar ao Menu Principal");
	     System.out.println("");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("");
	     System.out.println("");
	     
	     
	     //L� Op��o do Teclado
	     int opcao = metodo01.leOpcaoDoMenu();
	     
	     //Gere as Op��es Escolhidas
	     metodo02.escolhasMenuGerirLivros(opcao);
		  
	}
	

//	MENU GEST�O DOS UTILIZADORES DO SISTEMA
	public void menuGerirUsers(){
		
		 InputOpcaoMenu metodo01 = new InputOpcaoMenu();
		 GereEscolhasDosMenus metodo02 = new GereEscolhasDosMenus();
		 
	
	     System.out.println("");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("|<<<<<<<<<<<<<GEST�O DOS UTILIZADORES DO SISTEMA>>>>>>>>>>>>>|");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("");
	     System.out.println("|-------------> 1 - Inserir Utilizador");
	     System.out.println("|-------------> 2 - Alterar Dados do Utilizador");
	     System.out.println("|-------------> 3 - Remover Utilizador-Caixa");
	     System.out.println("|-------------> 4 - Voltar ao Menu Principal");
	     System.out.println("");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("-------------------------------------------------------------");
	     System.out.println("");
	     System.out.println("");
	     
	   //L� Op��o do Teclado
	     int opcao = metodo01.leOpcaoDoMenu();
	     
	     //Gere as Op��es Escolhidas
	     metodo02.escolhasMenuGerirUsers(opcao);
	     
		  
	}
	
	
	
}
