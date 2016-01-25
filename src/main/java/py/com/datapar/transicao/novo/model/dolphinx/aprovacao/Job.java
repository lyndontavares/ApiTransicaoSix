package py.com.datapar.transicao.novo.model.dolphinx.aprovacao;

import java.util.Date;

import py.com.datapar.transicao.novo.model.dolphinx.aprovacao.enums.JobSituacao;

public class Job {

	private long id;
	
	private String descricao;
	
	private String tarefas;
	
	private Date virgenciaInicio;
	
	private Date virgenciaFim;
	
	private JobSituacao situacao;

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

	public String getTarefas() {
		return tarefas;
	}

	public void setTarefas(String tarefas) {
		this.tarefas = tarefas;
	}

	public Date getVirgenciaInicio() {
		return virgenciaInicio;
	}

	public void setVirgenciaInicio(Date virgenciaInicio) {
		this.virgenciaInicio = virgenciaInicio;
	}

	public Date getVirgenciaFim() {
		return virgenciaFim;
	}

	public void setVirgenciaFim(Date virgenciaFim) {
		this.virgenciaFim = virgenciaFim;
	}

	public JobSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(JobSituacao situacao) {
		this.situacao = situacao;
	}
	
	
}
