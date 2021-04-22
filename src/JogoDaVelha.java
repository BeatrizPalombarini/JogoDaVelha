import java.util.Scanner;

public class JogoDaVelha {

	Scanner entrada = new Scanner(System.in);

	private String jogador_1;
	private String marcador_j1;
	private String jogador_2;
	private String marcador_j2;

	private String[][] tabuleiro = new String[3][3]; // 0-1-2
	private int vez = -1;
	private boolean rodando = false;
	private boolean preenchido = false;

	// Função falar
	public void falar(String texto) {
		System.out.println(texto);
	}

	// Boas Vindas
	public void boasVindas() {
		falar("Bem vindo ao Jogo da Velha!");
		falar("Para jogar são necessários dois jogadores!");
	}

	// Inicializar o jogo
	public void inicializar() {
		rodando = true;
	}

	// Get rodando
	public boolean getRodando() {
		return rodando;
	}

	// Set jogadores
	public void jogadores() {
		falar("Por favor insira o nome do jogador 1:");
		jogador_1 = entrada.next();
		falar("Por favor insira o nome do jogador 2:");
		jogador_2 = entrada.next();
		falar("Jogador 1: " + jogador_1);
		falar("Jogador 2: " + jogador_2);
	}

	// Preencher Tabuleiro
	public void preencher_Tabuleiro() {
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				tabuleiro[j][i] = "#";
			}
		}
		preenchido = true;
	}

	// Mostrar Tabuleiro
	public void mostrar_Tabuleiro() {

		if (preenchido == false) {
			preencher_Tabuleiro();
		}

		for (int i = 0; i <= 2; i++) {
			falar(tabuleiro[0][i] + " " + tabuleiro[1][i] + " " + tabuleiro[2][i]);
		}

	}

	// Escolher quem começa
	public void escolherVez() {
		String escolha = "";

		while (escolha.equals("1") == false && escolha.equals("2") == false) {
			falar("Por favor selecione o primeiro a jogar (1 ou 2): ");
			escolha = entrada.next();
			try {
				vez = Integer.parseInt(escolha);
			} catch (Exception e) {

			}

		}
	}

	// Mostrar Vez
	public void mostrarJogador() {
		switch (vez) {
		case 1:
			falar("Vez do jogador " + jogador_1);
			break;
		case 2:
			falar("Vez do jogador " + jogador_2);
			break;
		default:
			falar("ERRO");
			rodando = false;
		}
	}

	// Set Marcador
	public void setMarcadores() {
		String escolha = "";

		while (escolha.equals("X") == false && escolha.equals("O") == false) {
			falar("Por favor escolha X ou O para o jogador 1:");
			escolha = entrada.next();
		}

		marcador_j1 = escolha;
		if (marcador_j1.equals("X")) {
			marcador_j2 = "O";
		} else {
			marcador_j1 = "O";
			marcador_j2 = "X";
		}
	}

	// Inserir Jogada
	public void jogar() {

		if (preenchido == false) {
			return;
		}
		int linha = 0;
		int coluna = 0;

		while (coluna != 1 && coluna != 2 && coluna != 3) {
			falar("Por favor insira a coluna:");
			coluna = entrada.nextInt();
		}
		while (linha != 1 && linha != 2 && linha != 3) {
			falar("Por favor insira a linha:");
			linha = entrada.nextInt();
		}

		while (tabuleiro[coluna - 1][linha - 1] != "#") {
			falar("Campo já preenchido.");
			falar("Por favor insira os dados novamente.");

			coluna = linha = 0;

			while (coluna != 1 && coluna != 2 && coluna != 3) {
				falar("Por favor insira a coluna:");
				coluna = entrada.nextInt();
			}
			while (linha != 1 && linha != 2 && linha != 3) {
				falar("Por favor insira a linha:");
				linha = entrada.nextInt();
			}
		}

		switch (vez) {
		case 1:
			tabuleiro[coluna - 1][linha - 1] = marcador_j1;
			if (verificarJogo() == 1) {
				rodando = false;
			} else {
				vez = 2;
			}
			break;

		case 2:
			tabuleiro[coluna - 1][linha - 1] = marcador_j2;
			if (verificarJogo() == 1) {
				rodando = false;
			} else {
				vez = 2;
			}
			break;

		default:
			falar("ERRO");
			rodando = false;
		}
	}

	// Função verificar tabuleiro e se há vencedores
	public int verificarJogo() {

		int quemGanhou = 0;
		int jogador_1 = 0;
		int jogador_2 = 0;
		int empate = 0;
		int continuar = 0;

		// Verifical horizontal
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[0][i].equals("X") && tabuleiro[1][i].equals("X") && tabuleiro[2][i].equals("X")) {
				quemGanhou = vez;
			}
			if (tabuleiro[0][i].equals("O") && tabuleiro[1][i].equals("O") && tabuleiro[2][i].equals("O")) {
				quemGanhou = vez;
			}
		}

		// Verifical Vertical
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[i][0].equals("X") && tabuleiro[i][1].equals("X") && tabuleiro[i][2].equals("X")) {
				quemGanhou = vez;
			}
			if (tabuleiro[i][0].equals("O") && tabuleiro[i][1].equals("O") && tabuleiro[i][2].equals("O")) {
				quemGanhou = vez;
			}
		}

		// Verifical Vertical
		if (tabuleiro[0][0].equals("X") && tabuleiro[1][1].equals("X") && tabuleiro[2][2].equals("X")) {
			quemGanhou = vez;
		}
		if (tabuleiro[2][0].equals("X") && tabuleiro[1][1].equals("X") && tabuleiro[0][2].equals("X")) {
			quemGanhou = vez;
		}
		if (tabuleiro[0][0].equals("O") && tabuleiro[1][1].equals("O") && tabuleiro[2][2].equals("O")) {
			quemGanhou = vez;
		}
		if (tabuleiro[2][0].equals("O") && tabuleiro[1][1].equals("O") && tabuleiro[0][2].equals("O")) {
			quemGanhou = vez;
		}

		switch (quemGanhou) {
		case 1:
			quemGanhou = jogador_1;
			break;

		case 2:
			quemGanhou = jogador_2;
			break;
			
		case 3:
			quemGanhou = empate;
			break;

		case 4:
			quemGanhou = continuar;
			break;

		default:
			falar("ERRO");
			rodando = false;
		}
		return quemGanhou;
	}
}
