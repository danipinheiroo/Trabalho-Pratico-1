
import java.util.Scanner;// Leitura de dados 
import java.util.Random;
public class tp1 {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		//Declaracao de variaveis
		String[][] temasPalavras = new String[51][51];
		String temaCadastrado;
		String  temaAExcluir;
		String temaABuscar;
		String temaAExcluir_palavra;
		char cadastro1_temas;
		char cadastro2_temas;
		char cadastro3_temas;
		char cadastro1_palavras;
		char cadastro2_palavras;
		char cadastro3_palavras;
		String temaCadastrado_Palavra;
		String palavraCadastrada;
		int indiceTema;
		int indiceExcluirTema=0;
		int indiceBuscarTema;
		int contPalavrasDoTema=0;
		int p=0;
		int t=0;
		int i=1;
		int z=0;
		int menu;
		
		//Switch com as opicoes do menu
		do {
		switch(menu=tp1.MenuDeOpicoes()) {
		case 1:
			
			System.out.print("1. Gerenciar Temas\n");
			//Cadastando temas do jogo
			System.out.print("\n-------CADASTRO:\n");
			do {
				System.out.print("Deseja cadastrar algum tema?(S/N)\n");
				cadastro1_temas = ler.next().charAt(0);
			}while(cadastro1_temas != 'S' && cadastro1_temas != 'N');
			if(cadastro1_temas == 'S') {
				//Pedindo o tema ao usuario
				System.out.print("Digite um tema:\n");
				temaCadastrado = ler.next();
				if(temaJaExistente(temasPalavras,temaCadastrado,t)) {
					System.out.print("Esse tema já foi cadastrado!\n");
				}else {
					//Atribuindo o tema a matriz
					temasPalavras[t][0] = temaCadastrado;
					//System.out.print("Na posicao "+t+" foi armazenado "+ temasPalavras[t][0]+"\n");
					System.out.print("Tema cadastrado com sucesso!\n");
					t++;
				}	
				
			}
			
			
			do {
				//EXCLUIRR!!!!!!!!!
				System.out.print("\n-------EXCLUSÃO:\n");
				System.out.print("Deseja excluir algum tema?(S/N)\n");
				cadastro2_temas = ler.next().charAt(0);
			}while(cadastro2_temas != 'S' && cadastro2_temas != 'N');
			if(cadastro2_temas == 'S') {
				System.out.print("Digite o tema que deseja excluir:\n");
				temaAExcluir = ler.next();
					//Primeiro vendo se esse tema existe
				if(temaJaExistente(temasPalavras,temaAExcluir,t)) {
					System.out.print("Tema encontrado!\n");
					for(int h = 0; h < t; h++) {
						if(temasPalavras[h][0].equals(temaAExcluir)) {
							indiceExcluirTema = h;
						}
					}
					for(int d = 0; d < 51; d++) {
						//Se o tema existir vamos ver se tem alguma palavra nesse tema
						if(temasPalavras[indiceExcluirTema][d] == null) {
							//esvasiando o tema com null
							temasPalavras[tp1.achandoIndice(temasPalavras,temaAExcluir,t)][0]=null;
							System.out.print("Tema excluido com sucesso!\n");
							
					}else {
						System.out.print("Não foi possível excluir o tema. Verifique se existem palavras cadastradas nesse tema\n");
						
						}
					}
					
			}else {
				System.out.print("Tema não encontrado!\n");
			}
			}
			
			//Buscando temas!!!!!!!!
			tp1.buscarTemas(temasPalavras,t);
			
		
			break;
			
		case 2:
			//CADASTRO!!!!!
			
			System.out.print("2. Gerenciar Palavras\n");
			System.out.print("\n------CADASTRO:\n");
			do {
				System.out.print("Deseja cadastrar alguma palavra?(S/N)\n");
				cadastro1_palavras = ler.next().charAt(0);
			}while(cadastro1_palavras != 'S' && cadastro1_palavras != 'N');
			
			if(cadastro1_palavras == 'S') {
				//Pedindo o tema ao usuario
				System.out.print("Digite um tema:\n");
				temaCadastrado_Palavra = ler.next();
				
					if(temaJaExistente(temasPalavras,temaCadastrado_Palavra,t)) {
						indiceTema = tp1.achandoIndice(temasPalavras,temaCadastrado_Palavra,t) ;
						System.out.print("Tema encontrado!\n");
						System.out.print("Digite a palavra:\n");
						palavraCadastrada = ler.next();
						
						//Verificando se a palavra ja esta cadastrada no tema
						if(i>1 && palavraJaExistente(temasPalavras,palavraCadastrada,indiceTema)) {
							System.out.print("Essa palavra já foi cadastrada nesse tema!\n");
							
						}else {
							//Atribuindo o tema a matriz
							temasPalavras[indiceTema][i] = palavraCadastrada;					
							System.out.print("Tema cadastrado com sucesso!\n");
							i++;
							
						}
						
				}
					if(temaJaExistente(temasPalavras,temaCadastrado_Palavra,t)==false){
					System.out.print("Esse tema não existe!\n");
				}
			}
			
			int indiceExcluirPalavra=0;
			String palavraAExcluir;
			int indiceExcluirPalavra2=0;
			do {
				//EXCLUIR tem que fazer!!!!!!!
				System.out.print("\n-----EXCLUSÃO\n");
				System.out.print("Deseja excluir alguma palavra?(S/N)\n");
				cadastro2_palavras = ler.next().charAt(0);
			}while(cadastro2_palavras != 'S' && cadastro2_palavras != 'N');
			if(cadastro2_palavras == 'S') {
				System.out.print("Digite o tema ao qual a palavra pertence:\n");
				temaAExcluir_palavra = ler.next();
				
				if(temaJaExistente(temasPalavras,temaAExcluir_palavra,t)) {
					System.out.print("Tema encontrado!\n");
					System.out.print("Digite a palavra:\n");
					palavraAExcluir = ler.next(); 
					//Encontrando onde ta o tema
					for(int f = 0; f < t; f++) {
						if(temasPalavras[z][0].equals(temaAExcluir_palavra)) {
							indiceExcluirPalavra = f;
						}
					}
					//Encontrando onde ta a palavra
					for(int r = 0; r < 51; r++) {
						if(temasPalavras[indiceExcluirPalavra][r].equals(palavraAExcluir)) {
							indiceExcluirPalavra2 = r;
						}
					}
					//Excluindo a palavra
							temasPalavras[indiceExcluirPalavra][indiceExcluirPalavra2]=null;
							System.out.print("Tema excluido com sucesso!\n");
							
					}else {
						System.out.print("Tema não encontrado!\n");
					}
					
			}
			
		
				
			
			//Buscando palavras nos temas
			tp1.buscarPalavras(temasPalavras,t);
			
			
			//LISTAR TEMAS
			tp1.listarTemas(temasPalavras,t);
			
			
			break;
		case 3:
			//Jogo da forca
			tp1.opicaoJogar(temasPalavras,t,i);
			
			break;
		case 5:
			
			t=5;
			//temas pedidos pela professora
			temasPalavras[0][0]="Paises";
			temasPalavras[1][0]="Frutas";
			temasPalavras[2][0]="Series";
			temasPalavras[3][0]="Celebridades";
			temasPalavras[4][0]="Filmes";
			
			//Palavras pedidas pela preofessora
			temasPalavras[0][1]="BRASIL";   		temasPalavras[1][1]="PERA";
			temasPalavras[0][2]="PORTUGAL";			temasPalavras[1][2]="BANANA";
			temasPalavras[0][3]="MADAGASCAR";		temasPalavras[1][3]="MACA";
			temasPalavras[0][4]="MEXICO";			temasPalavras[1][4]="SIRIGUELA";
			temasPalavras[0][5]="CUBA";				temasPalavras[1][5]="ABACATE";
			temasPalavras[0][6]="RUSSIA";			temasPalavras[1][6]="MANGA";
			temasPalavras[0][7]="ALEMANHA";			temasPalavras[1][7]="ROMA";
			temasPalavras[0][8]="CANADA";			temasPalavras[1][8]="ACEROLA";
			temasPalavras[0][9]="JAPAO";			temasPalavras[1][9]="ABACAXI";
			temasPalavras[0][10]="COLOMBIA";		temasPalavras[1][10]="AMORA";
			
			temasPalavras[2][1]="FRIENDS";   		temasPalavras[3][1]="ADELE";
			temasPalavras[2][2]="GLEE";				temasPalavras[3][2]="IZA";
			temasPalavras[2][3]="ATYPICAL";			temasPalavras[3][3]="ZENDAYA";
			temasPalavras[2][4]="EUPHORIA";			temasPalavras[3][4]="NEYMAR";
			temasPalavras[2][5]="FARGO";			temasPalavras[3][5]="XUXA";
			temasPalavras[2][6]="SHERLOCK";			temasPalavras[3][6]="PITTY";
			temasPalavras[2][7]="FLASH";			temasPalavras[3][7]="LUDIMILLA";
			temasPalavras[2][8]="WANDAVISION";		temasPalavras[3][8]="ANITTA";
			temasPalavras[2][9]="VEEP";				temasPalavras[3][9]="ELIANA";
			temasPalavras[2][10]="DARK";			temasPalavras[3][10]="SHAKIRA";
			
			temasPalavras[4][1]="TITANIC";   		
			temasPalavras[4][2]="ETERNOS";		
			temasPalavras[4][3]="ENCANTO";			
			temasPalavras[4][4]="VENOM";			
			temasPalavras[4][5]="DUNA";			
			temasPalavras[4][6]="CORINGA";			
			temasPalavras[4][7]="SOUL";			
			temasPalavras[4][8]="AFTER";		
			temasPalavras[4][9]="CRUELLA";	
			temasPalavras[4][10]="AQUAMAN";
				
			System.out.print("Prontinho!\n");
			break;
		}
		}while(menu!=4);
		System.out.print("Tchau!\n");
			
	}


	public static int MenuDeOpicoes() {
		int menu;
		//Imprimindo o menu para o usuario e validando a opicao escolhida
		Scanner ler = new Scanner(System.in);
		do {
			System.out.print("\n------MENU------\n");
			System.out.print("1. Gerenciar Temas\n");
			System.out.print("2. Gerenciar Palavras\n");
			System.out.print("3. Jogar\n");
			System.out.print("4. Sair\n");
			System.out.print("5. Atribuir 5 temas e 10 palavras para cada um\n");
			menu = ler.nextInt();
			if(menu<=0 || menu>=6) {
				System.out.print("Opição inválida!\n");
			}
		}while(menu<=0 || menu>=6);
		return menu;		
	}
	
	//JOGO!!!!!!!!!!!!
	public static void opicaoJogar(String temasPalavras[][], int t,int i) {
		String temaJogo;
		Scanner ler = new Scanner(System.in);
		Random random = new Random();
		String palavraSorteada;
		String letrasUsadas="";
		String palavraAdivinhada="";
		int maxTentativas=5;
		char jogarNovamente1=' ';
		char jogarNovamente2=' ';
		int contErros=0;
		int contPalavrasDoTema=-1; //Comecando no -1 para o numero aleatorio nao contar com o tema na matriz
		System.out.print("3. Jogar\n");
		System.out.print("Digite o tema escolhido: \n");
		temaJogo = ler.next();
		//Vendo de o tema existe mesmo
		if(temaJaExistente(temasPalavras,temaJogo,t)) {
			for(int k = 0;k <51;k++) {
				if(temasPalavras[tp1.achandoIndice(temasPalavras,temaJogo,t)][k]!=null){
					//Contando quantas palavras cadastradas existem no tema
					contPalavrasDoTema++;
				}
			}
			//Gerando o numero aleatorio
			int indiceAleatorioPalavras = (int)(Math.random() * contPalavrasDoTema)+1;
	        palavraSorteada = temasPalavras[tp1.achandoIndice(temasPalavras,temaJogo,t)][indiceAleatorioPalavras];
	            
	        for(int u=0;u<palavraSorteada.length();u++) { //Loop pra passar por tuda a palavra sorteada
	        	palavraAdivinhada += "_";
	        	
	        	for(int tentativas = 0; ; tentativas++) {
	        		if(contErros == maxTentativas) { //Quando errar 5 aparecer que errou e perguntar se que sair ou jogar mais
	        			System.out.println(contErros);
	        			do {
	        				System.out.println("Você perdeu! Deseja jogar novamente?(S/N)\n");
	        				jogarNovamente1 = ler.next().charAt(0);
	        			}while(jogarNovamente1 != 'S' && jogarNovamente1 != 'N');
	        			if(jogarNovamente1=='N') { //Se quer sair retorna ao manu
	        				return;
	        			}else { //Se nao joga dnv comoutra palavra
	        				tp1.opicaoJogar(temasPalavras,t,i);
	        			}
	        		}
	        		
	        		System.out.println("Rodada "+tentativas+"\n "+palavraAdivinhada+"\nDigite uma letra EM CAIXA ALTA: ");
	        		char letraTentada = new Scanner( System.in ).next().charAt(0);
	        		
	        		if(letrasUsadas.indexOf(letraTentada) >= 0) { //Se a letra for repetida
	        			System.out.println("Voce ja tentou essa letra, tente novamente...\n");
	        		}else {
	        			letrasUsadas+=letraTentada; //Adicionando as letra que foram tentadas para o proximo loop
	        			
	        			if(palavraSorteada.indexOf(letraTentada)>=0) { //
	        				palavraAdivinhada="";
	        				
	        				for(int j = 0;j<palavraSorteada.length();j++) { //Sustituindo _ pelas letras que forao acertadas
	        					palavraAdivinhada += letrasUsadas.indexOf(palavraSorteada.charAt(j)) >= 0 ? palavraSorteada.charAt(j) : "_" ;
	        				}
	        				
	        				if(palavraAdivinhada.contains("_")) { //Ainda esta jogando, ou seja, nao acertou a palavra toda
	        					System.out.println("Muito bem! Essa letra pertence a palavra...\n");
	        				}else {
	        					do {
	        						System.out.println("Parabéns! Você acertou a palavra! Deseja jogar novamente?”\n");
	    	        				jogarNovamente2 = ler.next().charAt(0);
	    	        			}while(jogarNovamente2 != 'S' && jogarNovamente2 != 'N');
	    	        			if(jogarNovamente2=='N') {
	    	        				tp1.MenuDeOpicoes();
	    	        			}else {
	    	        				tp1.opicaoJogar(temasPalavras,t,i);
	    	        			}
	        				}
	        			}else {
	        				System.out.println("Essa letra não existe na palavra, tente outra...\n");
	        				contErros++;
	        			}
	        			
	        		}
	        	}
		}
		}
	}
		
	
		
	
	//Buscando palavras dentro do tema tem que fazer!!!!!!!!!!!!!!!
	public static void buscarPalavras(String temasPalavras[][], int t){
		Scanner ler = new Scanner(System.in);
		char cadastro3_palavras;
		String palavraABuscar;
		int indiceTema_Pesquisa=0;
		int encontrou=0;
		do {
			//BUSCAR!!!!!
			System.out.print("\n------BUSCA\n");
			System.out.print("Deseja buscar alguma palavra?(S/N)\n");
			cadastro3_palavras = ler.next().charAt(0);
		}while(cadastro3_palavras != 'S' && cadastro3_palavras != 'N');
		if(cadastro3_palavras == 'S') {
			System.out.print("Digite a palavra que deseja buscar:\n");
			palavraABuscar = ler.next();
			//Encontando onde esta a palavra entre todos os temas
			for(int m = 0; m < t; m++) {
				for(int n = 1; n < 10; n++) {
					if(temasPalavras[m][n].equals(palavraABuscar) && (temasPalavras[m][n]!=null)) {
						indiceTema_Pesquisa = m;
						encontrou=1;
					}
				}
			}
			if(encontrou==1) {
				System.out.print("Palavra encontrada no tema "+ temasPalavras[indiceTema_Pesquisa][0]+"\n");
			}else {
				System.out.print("Palavra não encontrada\n");
		}
		}
	}
	
	
	//Buscando temas e imprimindo 
	public static void buscarTemas(String temasPalavras[][], int t) {
		Scanner ler = new Scanner(System.in);
		char cadastro3_temas;
		String temaABuscar;
	do {
		//BUSCAR!!!!!
		System.out.print("\n------BUSCA\n");
		System.out.print("Deseja buscar algum tema?(S/N)\n");
		cadastro3_temas = ler.next().charAt(0);
	}while(cadastro3_temas != 'S' && cadastro3_temas != 'N');
	if(cadastro3_temas == 'S') {
		
		System.out.print("Digite o tema que deseja buscar:\n");
		temaABuscar = ler.next();
		//Verificando se o tema existe
		if(temaJaExistente(temasPalavras,temaABuscar,t)) {
			System.out.print("O tema foi encontrado: "+temasPalavras[tp1.achandoIndice(temasPalavras,temaABuscar,t)][0]+"\n");
			for(int s = 0; s < 51; s++) {
				//Vai imprimir o temas e as palavras na matriz que nao estao vazias
				if(temasPalavras[tp1.achandoIndice(temasPalavras,temaABuscar,t)][s]!=null) {
					if(s==0) {
						System.out.print("\nTEMA  |   "+temasPalavras[tp1.achandoIndice(temasPalavras,temaABuscar,t)][s]+"\n");
						System.out.print("------------------------\n");
					}else {
						System.out.print("PALAVRA|  "+temasPalavras[tp1.achandoIndice(temasPalavras,temaABuscar,t)][s]+"\n");
				}
				}
			}
		}else {
			System.out.print("Esse tema não existe!\n");
		}
		
	}
	}
	
	
	//Listando o tema escolhido
	public static void listarTemas(String temasPalavras[][], int t){
		Scanner ler = new Scanner(System.in);
		char cadastro4_palavras;
		String listarTema;
	System.out.print("\n-----LISTAR: \n");
	do {
		System.out.print("Deseja listar as palavras de um tema?(S/N)\n");
		cadastro4_palavras = ler.next().charAt(0);
	}while(cadastro4_palavras != 'S' && cadastro4_palavras != 'N');
	if(cadastro4_palavras == 'S') {
		System.out.print("Digite o tema escolhido: \n");
		listarTema = ler.next();
		//Achando se o tema existe mesmo
		if(temaJaExistente(temasPalavras,listarTema,t)) {
			for(int s = 0; s < 51; s++) {
				//Se ele existe entao imprimindo ele comas palavras cadastradas
				if(temasPalavras[tp1.achandoIndice(temasPalavras,listarTema,t)][s]!=null) {
					if(s==0) {
						System.out.print("\nTEMA|   "+temasPalavras[tp1.achandoIndice(temasPalavras,listarTema,t)][s]+"\n");
						System.out.print("------------------------\n");
					}else {
						System.out.print("PALAVRA|  "+temasPalavras[tp1.achandoIndice(temasPalavras,listarTema,t)][s]+"\n");
				}
				}
			}
		}else {
			System.out.print("Esse tema não existe!\n");
		}
	}
	}
	
	//Achando o indice do tema achado
	public static int achandoIndice(String temasPalavras[][],String Tema, int t) {
		int indiceListar=0;
		for(int y = 0; y < t; y++) {
			if(temasPalavras[y][0].equals(Tema)) {
				indiceListar = y;
			}
		}
		return indiceListar;
	}
	
	//Metodo verificando se o tema cadastrado ja existe
	public static Boolean temaJaExistente(String temasPalavras[][],String temaCadastrado,int i) {
		for(int z = 0; z < i; z++) {
			if(temasPalavras[z][0].equals(temaCadastrado)) {
				return true;
			}
		}
		return false;
	}
	
	//Verificando de a palavra ja existe
	public static Boolean palavraJaExistente(String temasPalavras[][],String palavraCadastrada,int indiceTema) {
		for(int v = 0; v < 51; v++) {
			if(temasPalavras[indiceTema][v]!=null && temasPalavras[indiceTema][v].equals(palavraCadastrada)) {
				return true;
			}
		}
		return false;

	}
}

