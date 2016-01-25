package py.com.datapar.transicao.novo.model.dolphinx.aprovacao;

public class Transicao {

	private long id;
	
	private Artefato artefato;
	
	private Estado estadoInicial;
	
	private Estado EstadoFinal;
	
	private String job;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Artefato getArtefato() {
		return artefato;
	}

	public void setArtefato(Artefato artefato) {
		this.artefato = artefato;
	}

	public Estado getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public Estado getEstadoFinal() {
		return EstadoFinal;
	}

	public void setEstadoFinal(Estado estadoFinal) {
		EstadoFinal = estadoFinal;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
}
