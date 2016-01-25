package py.com.datapar.transicao.novo.service.enums;

public enum ColunaSqlInfo {

    //select i.table_name,i.column_name, i.data_type, i.character_maximum_length, i.numeric_precision, i.numeric_scale, i.datetime_precision, i.column_type, i.column_key from information_schema.columns i where i.table_name='TAB_LOCALIDADE';
	
	TABELA(0),COLUNA(1),TIPO(2),TAMANHO(3),PRECISAO(5),ESCALA(6);
 
	private int posicao;
	
	ColunaSqlInfo(int posicao){
		this.posicao = posicao;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
}
