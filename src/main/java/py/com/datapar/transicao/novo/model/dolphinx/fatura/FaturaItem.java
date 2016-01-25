package py.com.datapar.transicao.novo.model.dolphinx.fatura;

import py.com.datapar.transicao.novo.model.dolphinx.produto.ProdutoCatalogo;

public class FaturaItem {

	
	private long id;
	
	private Fatura fatura;
	
	private Preco tabelaPreco;
	
	private ProdutoCatalogo produtoCatalogo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

	public ProdutoCatalogo getProdutoCatalogo() {
		return produtoCatalogo;
	}

	public void setProdutoCatalogo(ProdutoCatalogo produtoCatalogo) {
		this.produtoCatalogo = produtoCatalogo;
	}

	public Preco getTabelaPreco() {
		return tabelaPreco;
	}

	public void setTabelaPreco(Preco tabelaPreco) {
		this.tabelaPreco = tabelaPreco;
	}


	
	
}
