public class principal {

	public static void main(String[] args) {

		JogoDaVelha jogo = new JogoDaVelha();

		jogo.inicializar();
		jogo.boasVindas();
		jogo.jogadores();
		jogo.escolherVez();
		jogo.setMarcadores();

		while (jogo.getRodando() == true) {
			jogo.mostrar_Tabuleiro();
			jogo.mostrarJogador();
			jogo.jogar();
		}
		
	}
}
