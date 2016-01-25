package py.com.datapar.transicao.novo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import py.com.datapar.transicao.novo.model.enums.TipoCampo;

@Entity
@Table(name="API_CAMPO")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class MapeamentoCampo {

	//sequence strategy
	//@Id
	//@SequenceGenerator(name="apiCampoSeq", sequenceName="API_CAMPO_SEQ" )
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="apiCampoSeq")
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@TableGenerator(
			name = "appSeqStore", 
			table = "APP_SEQ_STORE", 
			pkColumnName = "APP_SEQ_NAME", 
			pkColumnValue = "API_CAMPO.PK", 
			valueColumnName = "APP_SEQ_VALUE", 
			initialValue = 1, allocationSize = 1)
	
	@Column(name="ID")
	private long id;
	
	//@ JsonBackReference
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="TABELA_ID")
	private MapeamentoTabela tabela;
	
	@Column(name="NOME_ORIGEM",length=50,nullable=false)
	private String nomeOrigem;
	
	@Column(name="NOME_DESTINO",length=50,nullable=false)
	private String nomeDestino;
	
	@Column(name="TIPO_ORIGEM",length=20,nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoCampo tipoOrigem;

	@Column(name="TIPO_DESTINO",length=20,nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoCampo tipoDestino;
	
	@Column(name="TAMANHO_ORIGEM")
	private long tamanhoOrigem;

	@Column(name="TAMANHO_DESTINO")
	private long tamanhoDestino;
	
	@Column(name="PRECISAO_ORIGEM")
	private long precisaoOrigem;

	@Column(name="PRECISAO_DESTINO")
	private long precisaoDestino;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public MapeamentoTabela getTabela() {
		return tabela;
	}


	public void setTabela(MapeamentoTabela tabela) {
		this.tabela = tabela;
	}


	public String getNomeOrigem() {
		return nomeOrigem;
	}


	public void setNomeOrigem(String nomeOrigem) {
		this.nomeOrigem = nomeOrigem;
	}


	public String getNomeDestino() {
		return nomeDestino;
	}


	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}


	public TipoCampo getTipoOrigem() {
		return tipoOrigem;
	}


	public void setTipoOrigem(TipoCampo tipoOrigem) {
		this.tipoOrigem = tipoOrigem;
	}


	public TipoCampo getTipoDestino() {
		return tipoDestino;
	}


	public void setTipoDestino(TipoCampo tipoDestino) {
		this.tipoDestino = tipoDestino;
	}


   public MapeamentoCampo(){
	}
   
	public MapeamentoCampo(long id, MapeamentoTabela tabela, String nomeOrigem, String nomeDestino, TipoCampo tipoOrigem,
		TipoCampo tipoDestino, long tamanhoOrigem, long tamanhoDestino, long precisaoOrigem, long precisaoDestino) {
	this.id = id;
	this.tabela = tabela;
	this.nomeOrigem = nomeOrigem;
	this.nomeDestino = nomeDestino;
	this.tipoOrigem = tipoOrigem;
	this.tipoDestino = tipoDestino;
	this.tamanhoOrigem = tamanhoOrigem;
	this.tamanhoDestino = tamanhoDestino;
	this.precisaoOrigem = precisaoOrigem;
	this.precisaoDestino = precisaoDestino;
}


	public long getTamanhoOrigem() {
	return tamanhoOrigem;
}


public void setTamanhoOrigem(long tamanhoOrigem) {
	this.tamanhoOrigem = tamanhoOrigem;
}


public long getTamanhoDestino() {
	return tamanhoDestino;
}


public void setTamanhoDestino(long tamanhoDestino) {
	this.tamanhoDestino = tamanhoDestino;
}


public long getPrecisaoOrigem() {
	return precisaoOrigem;
}


public void setPrecisaoOrigem(long precisaoOrigem) {
	this.precisaoOrigem = precisaoOrigem;
}


public long getPrecisaoDestino() {
	return precisaoDestino;
}


public void setPrecisaoDestino(long precisaoDestino) {
	this.precisaoDestino = precisaoDestino;
}


	@Override
	public String toString() {
		return "MapeamentoCampo [id=" + id + ", tabela=" + tabela + ", nomeOrigem=" + nomeOrigem + ", nomeDestino="
				+ nomeDestino + ", tipoOrigem=" + tipoOrigem + ", tipoDestino=" + tipoDestino + ", tamanhoOrigem="
				+ tamanhoOrigem + ", tamanhoDestino=" + tamanhoDestino + ", precisaoOrigem=" + precisaoOrigem
				+ ", precisaoDestino=" + precisaoDestino + "]";
	}

	
	
	
	
}
