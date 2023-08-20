package tabuleiro;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new ExcecaoTabuleiro("Erro criando tabuleiro, necessario que haja 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	
	}
	
	public int getLinhas() {
		return linhas;
	}
	public int getColunas() {
		return colunas;
	}	
	public Peca peca(int linha, int coluna) {
		if (!existiPosicao(linha, coluna)) {
			throw new ExcecaoTabuleiro("Posição indisponivel");
		}
		return pecas[linha][coluna];
		}
	public Peca peca(Posicao posicao) {
		if (!existiPosicao(posicao)) {
			throw new ExcecaoTabuleiro("Posição indisponivel");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];	
	}
	
	public void lugarPeca(Peca peca, Posicao posicao) {
		if(temPeca(posicao)) {
			throw new ExcecaoTabuleiro("Já existi uma peça nesta posição" + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private boolean existiPosicao(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas; 
	}
	
	public boolean existiPosicao(Posicao posicao) {
		return existiPosicao(posicao.getLinha(), posicao.getColuna()); 
	}
	
	public boolean temPeca(Posicao posicao) {
		if (!existiPosicao(posicao)) {
			throw new ExcecaoTabuleiro("Posição indisponivel");
		}
		return peca(posicao) != null;
	}
	
}
	

