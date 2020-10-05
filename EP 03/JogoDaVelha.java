/*  <01.06.2020> */

/*
	Jogo da Velha - programa para verificar o status de um jogo.
	
	Lista de Status calculado:
	0 - Jogo não iniciado: o tabuleiro está 'vazio', isto é sem peças X e O;
    1 - Jogo encerrado1: o primeiro jogador (que usa as peças X) é o ganhador;
    2 - Jogo encerrado2: o segundo jogador (que usa as peças O) é o ganhador;
    3 - Jogo encerrado3: empate - todas as casas do tabuleiro estão preenchidas com X e O, mas nenhum dos jogadores ganhou;
    4 - Jogo já iniciado e em andamento: nenhuma das alternativas anteriores.	
*/

public class JogoDaVelha {
    
	static final char pecaX = 'X';
	static final char pecaY = 'O';
	static final char espacoVazio = ' ';

	/*
		Determina o status de uma partida de Jogo da Velha
		
		Entrada:
			tabuleiro - matriz 3x3 de caracteres representando uma partida valida de Jogo da Velha
			
		Saída:
			um inteiro contendo o status da partida (valores válidos de zero a quatro)
	*/
	static int verificaStatus(char[][] tabuleiro) {
		
		int status = -1;
		int vazio = 0; //Representa quando não há X ou O
		int X = 0; 
		int O = 0;
		int zero = 0; //Para verificar outros status, além de vitórias. 
        
        for (int i = 0; i < tabuleiro.length; i++) { //Verificar se alguém ganhou pela linha
            
            for (int j = 0; j < tabuleiro[i].length; j++) { 
                
                if (tabuleiro[i][j] == pecaX) {
                    
                    X++;
                }
                
                else if (tabuleiro[i][j] == pecaY) { 
                    
                    O++;
                
                }
                
                else {
                    
                    vazio++; 
                    
                }
                
            }
            
            if (X == 3) { //Através da verificação de quantidades, é possível determinar o status do jogo nessa situação
                
                status = 1;
                return status;
            }
            
            else if (O == 3) {
                
                status = 2;
                return status;
            }
            
            else if (X != 0 || O != 0) {
                
                status = 4;
            }
            
            else { 
                
                zero++; 
            }
            
            vazio = 0; //Zera, pois irá utilizar novamente e para não dar erro, isto deve ocorrer
            X = 0;
            O = 0;
            
            
        }
        
        for (int i = 0; i < tabuleiro.length; i++) { //Verificar se alguém ganhou através das colunas
            
            for (int j = 0; j < tabuleiro[i].length; j++) {
                
                if (tabuleiro[j][i] == pecaX) {
                    
                    X++;
                }
                
                else if (tabuleiro[j][i] == pecaY) {
                    
                    O++;
                }
                
                else {
                    
                    vazio++;
                }
            
            }
            
            if (X == 3) { //Através da verificação de quantidades, é possível determinar o status do jogo nessa situação
                
                status = 1;
                return status;
            }
            
            else if (O == 3) {
                
                status = 2;
                return status;
            }
            
            else if (X != 0 || O != 0) {
                
                status = 4;
            }
            
            else { 
                
                zero++; 
            }
            
            vazio = 0; //Zera, pois irá utilizar novamente e para não dar erro, isto deve ocorrer
            X = 0;
            O = 0;
        }
        
        
        for (int i = 0; i < tabuleiro.length;) { //Verificar a diagonal principal
        
            for (int j = 0; j < 3;) {
                
                if (tabuleiro[i][j] == pecaX) {
                    
                    X++;
                    i++;
                    j++;
                }
                
                else if (tabuleiro[i][j] == pecaY) {
                    
                    O++;
                    i++;
                    j++;
                }
                
                else {
                    
                    vazio++;
                    i++;
                    j++;
                }
                
            }
            
            if (X == 3) { //Através da verificação de quantidades, é possível determinar o status do jogo nessa situação
                
                status = 1;
                return status;
            }
            
            else if (O == 3) {
                
                status = 2;
                return status;
            }
            
            else if (X != 0 || O != 0) {
                
                status = 4;
            }
            
            else { 
                
                zero++; 
            }
            
            vazio = 0; //Zera, pois irá utilizar novamente e para não dar erro, isto deve ocorrer
            O = 0;
            X = 0;
            
        }
        
        for (int i = 2; i >= 0;) { //Verificar a diagonal secundária
        
            for (int j = 0; j < 3;) {
                
                if (tabuleiro[i][j] == pecaX) {
                    
                    X++;
                    i--;
                    j++;
                    
                }
                
                else if (tabuleiro[i][j] == pecaY) {
                    
                    O++;
                    i--;
                    j++;
                }
                
                else {
                    vazio++;
                    i--;
                    j++;
                }
                
            }
               
            if (X == 3) { //Através da verificação de quantidades, é possível determinar o status do jogo nessa situação
                
                status = 1;
                return status;
                
            }
            
            else if (O == 3) {
                
                status = 2;
                return status;
            
            }
            
            else if (X != 0 || O != 0) {
                
                status = 4;
            }
            
            else { 
                
                zero++; 
            }
            
            vazio = 0; 
            O = 0;
            X = 0;
        
        }
            
        if (zero == 8) { //Se for igual a 8, indica que não foi iniciado
            
            status = 0;
            
        }
        
        else if (zero != 8 && zero != 0) { //Indica que está em andamento
            
            status = 4;
        }
        
        else { //Indica que deu empate
            
            status = 3; 
           
        }
     	
     	return status;
	}

	public static void main(String[] args) {
		
        char[][] tab0 = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		char[][] tab1 = {{'X','X','X'},{'O','O',' '},{' ',' ',' '}};
		char[][] tab2 = {{'O','X','X'},{'X','O','O'},{' ',' ','O'}};
		char[][] tab3 = {{'O','X','X'},{'X','O','O'},{'O','X','X'}};
		char[][] tab4 = {{' ',' ',' '},{'X','O','X'},{' ',' ',' '}};

		System.out.println("Status calculado: " + verificaStatus(tab0));
		System.out.println("Status esperado para o tabuleiro0: 0\n");

		System.out.println("Status calculado: " + verificaStatus(tab1));
		System.out.println("Status esperado para o tabuleiro1: 1\n");

		System.out.println("Status calculado: " + verificaStatus(tab2));
		System.out.println("Status esperado para o tabuleiro2: 2\n");
		
		System.out.println("Status calculado: " + verificaStatus(tab3));
		System.out.println("Status esperado para o tabuleiro1: 3\n");
		
		System.out.println("Status calculado: " + verificaStatus(tab4));
		System.out.println("Status esperado para o tabuleiro4: 4\n");
		
	}
}
