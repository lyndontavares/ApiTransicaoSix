package py.com.datapar.transicao.novo.model.dolphinx.produto.service;

public class Formula {

	private long id;
	
	private String descricao;
	
	private String formula;

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

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}
	
   //@ElementCollection(fetch=FetchType.EAGER)
   //@CollectionTable(name="tab_formula_param",joinColumns=@JoinColumn(name="formula_id"))
   //@Enumerated(EnumType.STRING)
   // private List<Parametros> roles;
	
	
}
