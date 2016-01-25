package py.com.datapar.transicao.novo.model.dolphinx.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="TAB_LOCALIDADE")
public class Localidade {
	
	//sequence strategy
	//@Id
	//@SequenceGenerator(name="localizacaoSeq", sequenceName="API_SEQ_LOCALIDADE" )
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="localizacaoSeq")
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
	@TableGenerator(
			name = "appSeqStore", 
			table = "APP_SEQ_STORE", 
			pkColumnName = "APP_SEQ_NAME", 
			pkColumnValue = "TAB_LOCALIDADE.PK", 
			valueColumnName = "APP_SEQ_VALUE", 
			initialValue = 1, allocationSize = 1)
	
	
	@Column(name="ID")
	private long id;
	
	@Column(name="DESCRICAO",length=100,nullable=false)
	private String descricao;

	@Column(name="CODIGO_LEGADO",length=100)
	private String codigoLegado; 

	 
	public String getCodigoLegado() {
		return codigoLegado;
	}

	public void setCodigoLegado(String codigoLegado) {
		this.codigoLegado = codigoLegado;
	}

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
	
	public Localidade(){
		
	}
	
	
	
}
