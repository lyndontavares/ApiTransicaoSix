package py.com.datapar.transicao.novo.service.enums.old;

public enum OracleColunaSqlInfo {

	TABELA(0),COLUNA(1),TIPO(2),TAMANHO(3),PRECISAO(5),ESCALA(6);

	private int posicao;
	
	OracleColunaSqlInfo(int posicao){
		this.posicao = posicao;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
}
