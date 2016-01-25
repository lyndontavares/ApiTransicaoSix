package py.com.datapar.transicao.novo.model.dolphinx.aprovacao;

public class Estado {

	private long id;
	
	private String descricao;
	
	private Artefato artefato;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Artefato getArtefato() {
		return artefato;
	}

	public void setArtefato(Artefato artefato) {
		this.artefato = artefato;
	}
	
	
}
