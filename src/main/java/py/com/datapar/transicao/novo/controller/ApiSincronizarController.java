package py.com.datapar.transicao.novo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.com.datapar.transicao.novo.model.MapeamentoTabela;
import py.com.datapar.transicao.novo.repo.MapeamentoTabelaRepository;
import py.com.datapar.transicao.novo.service.MapeamentoService;
import py.com.datapar.transicao.novo.service.Sincronizar;
import py.com.datapar.transicao.novo.service.enums.SincronizacaoTipo;

@RestController
@RequestMapping("/api")
public class ApiSincronizarController {

	@Autowired
	MapeamentoTabelaRepository tabelaRepo;

	@Autowired
	Sincronizar sincro;

	@Autowired
	MapeamentoService mapService;
	
	@RequestMapping(value = "/sincronizar", method = RequestMethod.POST)
	public void sincronizarTabela() throws Exception {
		MapeamentoTabela tabela = tabelaRepo.queryFirstByOrderByIdAsc().iterator().next();
		sincro.sincronizarTabela(tabela, SincronizacaoTipo.SIMPLE);
	}

	@RequestMapping(value = "/sincronizar/origem", method = RequestMethod.POST)
	public void sincronizarTabelaPorNomeOrigem(@RequestBody final String tabela) {
		MapeamentoTabela tab = tabelaRepo.findByTabelaOrigem(tabela).iterator().next();
		sincro.sincronizarTabela(tab, SincronizacaoTipo.SIMPLE);
	}

	@RequestMapping(value = "/sincronizar/destino", method = RequestMethod.POST)
	public void sincronizarTabelaPorNomeDestino(@RequestBody final String tabela) {
		MapeamentoTabela tab = tabelaRepo.findByTabelaDestino(tabela).iterator().next();
		sincro.sincronizarTabela(tab, SincronizacaoTipo.SIMPLE);
	}
	
	@RequestMapping(value = "/sincronizar/all", method = RequestMethod.POST)
	public void sincronizarTabelaPorNomeDestino() throws Exception {
		sincro.sincronizarAll();
	}

	@RequestMapping(value = "/sincronizar/sincronizaveis", method = RequestMethod.POST)
	public void sincronizarMarcadasParaSincronzar() throws Exception {
		sincro.sincronizarMarcadasParaSincronizar();
	}
	

	@RequestMapping(value = "/sincronizar/adicionarcampos", method = RequestMethod.POST)
	public void adicionarCamposDaTabelaOrigemNaTabelaDestino(@RequestBody final String tabela) {
		MapeamentoTabela tab = tabelaRepo.findByTabelaOrigem(tabela).iterator().next();
		mapService.adicionarCamposDaTabelaOriemNaTabelaDestino(tab);
	}
	
	
}
