package py.com.datapar.transicao.novo.model.dolphinx.endereco;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tab_pais")
public class Pais {

	@Id
	private long id;
	
	private String nome;
	
	private String sigla;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
/*	@Autowired
	private ReplicacaoService  replicacaoService;

	@PrePersist
    void generateId(long id) {
        this.id =  replicacaoService.GerarSequencia(id);
    }	
	*/
}
