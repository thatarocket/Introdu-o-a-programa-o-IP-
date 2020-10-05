/*  <06.05.2020>  */

/*
	Cálculo para raiz quadrada
*/
public class Raiz {
	/*
		Calcula a raiz quadrada de um valor, com uma determinada
		precisão. Retorna esse valor, ou -1 quando:
		
		* a < 0
		* epsilon <= 0
		* epsilon >= 1
		
		Parâmetro:
			a - valor cuja raiz quadrada será calculada
			epsilon - precisão do cálculo
	*/
	static double raizQuadrada(double a, double epsilon) {
	    
	    double x = a / 2; 
	    double xproximo = 1; //O valor seguinte do x
	    double xmodulo = 1; //O valor do módulo da subtração 
	    
	    if (a < 0 || epsilon <= 0 || epsilon >= 1 ) { //Esses itens não podem ser dessa forma, como citado anteriormente, logo retornam -1 
	    
	        return -1;
	    }
	    
	    else if (a == 0) { //A raiz de 0 é o próprio 0
	        
	        return 0;
	        
	    }
	    
	    else {
	    
	        for (int j = 0; xmodulo > epsilon;) {
	        
	            xproximo = (x + a / x) /2 ; //A conta para saber o próximo x
	            xmodulo = xproximo - x; 
	        
	            if (xmodulo < 0) { //O módulo faz com que fiquem positivos
	            
	                xmodulo *= -1;
	            }
	           
	            if (xmodulo < epsilon) { //Quando for menor que o epsilon, ele sai e retorna o xproximo
	           
	                break;
	            }
	        
	            else {
	                
	                x = xproximo; //Caso não seja menor que o epsilon, o xproximo vira o x e roda novamente para descobrir o valor seguinte
	                j++; 
	                
	            }
	            
	        } return xproximo;
	    
	    }
	    
	}
	
	public static void main(String[] args) {
		
		// Exemplo de teste:
		double valor = 63;
		double precisao = 0.001;
		System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	}
}
