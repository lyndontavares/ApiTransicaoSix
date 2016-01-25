package py.com.datapar.transicao.novo.model.dolphinx.logistica;

import py.com.datapar.transicao.novo.model.dolphinx.entidade.Fornecedor;

public class Pedido {

	private long id;
	
	private Fornecedor fornecedor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	
	
}
