package py.com.datapar.transicao.novo.model.dolphinx.aprovacao;

import java.util.Date;

import py.com.datapar.transicao.novo.model.dolphinx.security.Usuario;

public class Aprovacao {

	private long id;
	
	private Transicao transicao;
	
	private Comite comite;
	
	private Usuario aprovante;
	
	private Date dataSolicitacao;
	
	private Date dataAprovacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Transicao getTransicao() {
		return transicao;
	}

	public void setTransicao(Transicao transicao) {
		this.transicao = transicao;
	}

	public Comite getComite() {
		return comite;
	}

	public void setComite(Comite comite) {
		this.comite = comite;
	}

	public Usuario getAprovante() {
		return aprovante;
	}

	public void setAprovante(Usuario aprovante) {
		this.aprovante = aprovante;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Date getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao(Date dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}
	
	
	
}
