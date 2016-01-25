package py.com.datapar.transicao.novo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import py.com.datapar.transicao.novo.model.enums.AtualizacaoStatus;

@Entity
@Table(name = "API_TABLE")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class MapeamentoTabela {

	/*
	 * 
	 * //table strategy
	 * @Id
	 * @GeneratedValue( strategy= GenerationType.TABLE, generator="API_TABLE")
	 * @TableGenerator( name="API_TABLE", table="API_GENERATOR_TABLE",
	 * pkColumnValue="TABLE_SEQ")
	 * 
	 * 
	 * //table strategy - full
	 * @GeneratedValue( strategy = GenerationType.TABLE, generator =
	 * "appSeqStore" )
	 * @TableGenerator( name = "appSeqStore", table = "APP_SEQ_STORE",
	 * pkColumnName = "APP_SEQ_NAME", pkColumnValue = "API_TABLE.API_TABLE_PK",
	 * valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 1 )
	 * 
	 * 
	 * //sequence strategy
	 * @Id
	 * @GeneratedValue( strategy=GenerationType.SEQUENCE, generator =
	 * "apiTableSeq")
	 * @SequenceGenerator( name="apiTableSeq", sequenceName = "API_TABLE_SEQ")
	 *  
	 *  
	 *  // sequence strategy - oracle/dolphin 
	 *  @Id
	 *  @SequenceGenerator(name="apiTableSeq", sequenceName="API_TABLE_SEQ" )
	 *  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apiTableSeq")
	 *   
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@TableGenerator(
			name = "appSeqStore", 
			table = "APP_SEQ_STORE", 
			pkColumnName = "APP_SEQ_NAME", 
			pkColumnValue = "API_TABLE.PK", 
			valueColumnName = "APP_SEQ_VALUE", 
			initialValue = 1, allocationSize = 1)

	@Column(name = "ID")
	private long id;

	@Column(name = "TABELA_ORIGEM", length = 100, unique = true, nullable = false)
	private String tabelaOrigem;

	@Column(name = "TABELA_DESTINO", length = 100, unique = true, nullable = false)
	private String tabelaDestino;

	@Column(name = "SINCRONIZAR")
	private boolean sincronizar;

	@Column(name = "CHAVE_PRIMARIA",length=255)
	private String chavePrimaria;
	
	@Column(name = "CHAVE_PRIMARIA_DESTINO",length=255)
	private String chavePrimariaDestino;
	
	@Column(name="ORDEM_ATUALIZACAO")
	private long ordemAtualizacao;
	
	@Column(name="DATA_ULTIMA_ATUALIZACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAtualizacao;
	
	@Column(name="STATUS_ULTIMA_ATUALIZACAO",length=20)
	@Enumerated(EnumType.STRING)
	private AtualizacaoStatus  statusUltimaAtualizacao;

	//Use para resolver problema de recursividade
	//@ JsonManagedReference 
	@ JsonIgnore 
	@OneToMany(mappedBy = "tabela", fetch = FetchType.LAZY)
	private List<MapeamentoCampo> campos;

	// @OneToMany(orphanRemoval=true)
	// @JoinColumn(name="CUST_ID") // join column is in table for Order
	// public Set<Order> getOrders() {return orders;}
	
	
	
	public long getOrdemAtualizacao() {
		return ordemAtualizacao;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public AtualizacaoStatus getStatusUltimaAtualizacao() {
		return statusUltimaAtualizacao;
	}

	public void setStatusUltimaAtualizacao(AtualizacaoStatus statusUltimaAtualizacao) {
		this.statusUltimaAtualizacao = statusUltimaAtualizacao;
	}

	public String getChavePrimariaDestino() {
		return chavePrimariaDestino;
	}

	public void setChavePrimariaDestino(String chavePrimariaDestino) {
		this.chavePrimariaDestino = chavePrimariaDestino;
	}

	public void setOrdemAtualizacao(long ordemAtualizacao) {
		this.ordemAtualizacao = ordemAtualizacao;
	}

	public boolean isSincronizar() {
		return sincronizar;
	}

	public void setSincronizar(boolean sincronizar) {
		this.sincronizar = sincronizar;
	}

	public String getChavePrimaria() {
		return chavePrimaria;
	}

	public void setChavePrimaria(String chavePrimaria) {
		this.chavePrimaria = chavePrimaria;
	}


	 public List<MapeamentoCampo> getCampos() {
		return campos;
	}

	public void setCampos(List<MapeamentoCampo> campos) {
		this.campos = campos;
	} 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTabelaOrigem() {
		return tabelaOrigem;
	}

	public void setTabelaOrigem(String tabelaOrigem) {
		this.tabelaOrigem = tabelaOrigem;
	}

	public String getTabelaDestino() {
		return tabelaDestino;
	}

	public void setTabelaDestino(String tabelaDestino) {
		this.tabelaDestino = tabelaDestino;
	}

	public MapeamentoTabela() {
	}

	public MapeamentoTabela(long id, String tabelaOrigem, String tabelaDestino, boolean sincronizar,
			String chavePrimaria, List<MapeamentoCampo> campos) {
		this.id = id;
		this.tabelaOrigem = tabelaOrigem;
		this.tabelaDestino = tabelaDestino;
		this.sincronizar = sincronizar;
		this.chavePrimaria = chavePrimaria;
		//this.campos = campos;
	}

	@Override
	public String toString() {
		return "MapeamentoTabela [id=" + id + ", tabelaOrigem=" + tabelaOrigem + ", tabelaDestino=" + tabelaDestino
				+ ", sincronizar=" + sincronizar + ", chavePrimaria=" + chavePrimaria + ", campos=" + "]";
	}

}
