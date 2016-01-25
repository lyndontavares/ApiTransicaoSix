package py.com.datapar.transicao.old.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CFGLOCA")
public class Localidade {

	
	@Id
	@GeneratedValue
	@Column(name="NCODILOCA")
	private long id;
	
	@Column(name="CNOMELOCA")
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
	
	public Localidade(){
		
	}
	
	
	
}
