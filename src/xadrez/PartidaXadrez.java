package xadrez;

import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,8);
		initialSetup();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i=0;i<tabuleiro.getLinhas(); i++) {
			for(int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
			}
		}
		return mat;
	}
	private void lugarNPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
		
		
	}
	private void initialSetup() {
		lugarNPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		lugarNPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		lugarNPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		lugarNPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		lugarNPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		lugarNPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		lugarNPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		lugarNPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
        lugarNPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
        lugarNPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
        lugarNPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
        lugarNPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
}
