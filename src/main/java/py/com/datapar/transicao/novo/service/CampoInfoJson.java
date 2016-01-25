package py.com.datapar.transicao.novo.service;

public class CampoInfoJson {

	private String tabela;
	
	private String comentarioTabela;
	
	private String coluna;
	
	private String tipo;
	
	private String tamanho;
	
	private String precisao;
	
	private String comentarioCampo;

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public String getComentarioTabela() {
		return comentarioTabela;
	}

	public void setComentarioTabela(String comentarioTabela) {
		this.comentarioTabela = comentarioTabela;
	}

	public String getColuna() {
		return coluna;
	}

	public void setColuna(String coluna) {
		this.coluna = coluna;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

 
	public String getComentarioCampo() {
		return comentarioCampo;
	}

	public void setComentarioCampo(String comentarioCampo) {
		this.comentarioCampo = comentarioCampo;
	}
	
	public CampoInfoJson(){
		
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getPrecisao() {
		return precisao;
	}

	public void setPrecisao(String precisao) {
		this.precisao = precisao;
	}

	public CampoInfoJson(String tabela, String comentarioTabela, String coluna, String tipo, String tamanho,
			String precisao, String comentarioCampo) {
		this.tabela = tabela;
		this.comentarioTabela = comentarioTabela;
		this.coluna = coluna;
		this.tipo = tipo;
		this.tamanho = tamanho;
		this.precisao = precisao;
		this.comentarioCampo = comentarioCampo;
	}

 
	
	
}
