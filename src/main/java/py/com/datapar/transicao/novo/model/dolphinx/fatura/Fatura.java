package py.com.datapar.transicao.novo.model.dolphinx.fatura;

import java.util.Date;

import py.com.datapar.transicao.novo.model.dolphinx.endereco.Localidade;
import py.com.datapar.transicao.novo.model.dolphinx.entidade.Cliente;
import py.com.datapar.transicao.novo.model.dolphinx.entidade.Fornecedor;
import py.com.datapar.transicao.novo.model.dolphinx.organizacao.Departamento;
import py.com.datapar.transicao.novo.model.dolphinx.security.Usuario;

public class Fatura {

	private long id;
	
	private Date dataLancamento;
	
	private FaturaTipo faturaTipo;
	
	private Departamento departamento;
	
	private Localidade localidade;
	
	private Moeda moeda;
	
	private Cliente cliente;
	
	private PlanoFinanciamento plano;
	
	private Fornecedor fornecedor;
	
	private Usuario usuario;
	
	private CondicaoPagamento condicao;
	
	public CondicaoPagamento getCondicao() {
		return condicao;
	}

	public void setCondicao(CondicaoPagamento condicao) {
		this.condicao = condicao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}

 
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public PlanoFinanciamento getPlano() {
		return plano;
	}

	public void setPlano(PlanoFinanciamento plano) {
		this.plano = plano;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FaturaTipo getFaturaTipo() {
		return faturaTipo;
	}

	public void setFaturaTipo(FaturaTipo faturaTipo) {
		this.faturaTipo = faturaTipo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
 

	
	
}
