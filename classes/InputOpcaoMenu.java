package pacoteMelvin;

import java.util.Scanner;

public class InputOpcaoMenu {
	
//	L� OP��ES DO TIPO INTEIRO DO TECLADO (GLOBAL)
	public static int leOpcaoDoMenu() {
		int opcao = -1;
		Scanner lerDoTeclado = new Scanner(System.in);
		System.out.print("Escolha a op��o: ");
		opcao = lerDoTeclado.nextInt();
		
		 
		return  opcao;
	 }

}
