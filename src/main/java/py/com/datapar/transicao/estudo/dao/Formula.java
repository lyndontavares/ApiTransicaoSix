package py.com.datapar.transicao.estudo.dao;

public class Formula {

	private long id;
	
	private String descricao;

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

	public Formula() {
	}
	
	
	public Formula(long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Formula [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	
	
}
