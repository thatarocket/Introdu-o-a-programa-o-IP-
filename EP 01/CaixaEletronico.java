/* <15.04.2020> */

/*
	Caixa eletrônico das Ilhas Weblands, com estoque ilimitado de cédulas
	de B$50,00, B$10,00, B$5,00 e B$1,00.
*/
public class CaixaEletronico {
	
	static int n50; // Número de cédulas de B$50,00
	static int n10; // Número de cédulas de B$10,00
	static int n5; // Número de cédulas de B$5,00
	static int n1; // Número de cédulas de B$1,00

	/*
		Determina a quantidade de cada nota necessária para totalizar
		um determinado valor de retirada, de modo a minimizar a quantidade
		de cédulas entregues.
		
		Abastece as variáveis globais n50,n10, n5 e n1 com seu respectivo
		número de cédulas.
		
		Parâmetro:
			valor - O valor a ser retirado
	*/
	static void fazRetirada(int valor) {
		
		while(valor >= 50) { //Caso corresponda a essas características é possível devolver o troco com essa nota de 50
        
            n50++; //Conta quantas notas de 50 vão ser necessárias
            valor -=50; //Diminui o valor da nota utilizada para a realização da nova verificação
        }
        
        while(valor >= 10) { //Caso corresponda a essas características é possível devolver o troco com essa nota de 10 
        
            n10++; //Conta quantas notas de 10 vão ser necessárias
            valor-=10; //Diminui o valor da nota utilizada para a realização da nova verificação
        }
    
    
        while(valor >= 5) { //Caso corresponda a essas características é possível devolver o troco com essa nota de 5
        
            n5 ++; //Conta quantas notas de 5 vão ser necessárias
            valor -= 5; //Diminui o valor da nota utilizada para a realização da nova verificação
        }
    
    
        while (valor >= 1) { //Caso corresponda a essas características é possível devolver o troco com essa nota de 1
        
            n1++; //Conta quantas notas de 1 vão ser necessárias
            valor -= 1; //Diminui o valor da nota utilizada para a realização da nova verificação
        }
    
        if (valor < 0) { //Não há como retirar notas negativas, logo retorna -1
        
        n50 = -1; 
        n10 = -1;
        n5 = -1;
        n1 = -1; 
        
        }
	}
	
	public static void main(String[] args) {
	    
	    // Exemplo de teste:
		fazRetirada(63);
		System.out.println("Notas de 50: "+n50);
		System.out.println("Notas de 10: "+n10);
		System.out.println("Notas de 5:  "+n5);
		System.out.println("Notas de 1:  "+n1);
	}
}
