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

	// Boas Vindas
	public void boasVindas() {
		System.out.println("Bem vindo ao Jogo da Velha!");
		System.out.println("Para jogar são necessários dois jogadores!");
	}

	// Inicializar o jogo
	public void inicializar() {
		rodando = true;
	}

	// Set jogadores
	public void jogadores() {
		System.out.println("Por favor insira o nome do jogador 1:");
		jogador_1 = entrada.next();
		System.out.println("Por favor insira o nome do jogador 2:");
		jogador_2 = entrada.next();
		System.out.println("Jogador 1: " + jogador_1);
		System.out.println("Jogador 2: " + jogador_2);
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
			System.out.println(tabuleiro[0][i] + " " + tabuleiro[1][i] + " " + tabuleiro[2][i]);
		}

	}

	// Escolher quem começa
	public void escolherVez() {
		String escolha;

		System.out.println("Por favor selecione o primeiro a jogar (1 ou 2): ");
		escolha = entrada.next();

		if(escolha == "1" || escolha == "2") {
			vez = Integer.parseInt(escolha);
		}
	}

	// Mostrar Vez
	public void mostrarJogador() {
		switch (vez) {
		case 1:
			System.out.println("Vez do jogador " + jogador_1);
			break;
		case 2:
			System.out.println("Vez do jogador " + jogador_2);
			break;
		default:
			System.out.println("ERRO");
		}
	}

	// Set Marcador
	public void setMarcadores() {
		String escolha;

		System.out.println("Por favor escolha X ou O para o jogador 1:");
		escolha = entrada.next();

		if (escolha != "X" && escolha != "O") {
			return;
		}

		marcador_j1 = escolha;
		if (marcador_j1 == "X") {
			marcador_j2 = "O";
		} else {
			marcador_j2 = "X";
		}
	}

	// Inserir Jogada
	public void jogar(int linha, int coluna) {

		if (preenchido == false) {
			return;
		}

		switch (vez) {

		case 1:
			tabuleiro[coluna - 1][linha - 1] = marcador_j1;
			break;

		case 2:
			tabuleiro[coluna - 1][linha - 1] = marcador_j2;
			break;

		default:
			System.out.println("ERRO");

		}

	}
}
