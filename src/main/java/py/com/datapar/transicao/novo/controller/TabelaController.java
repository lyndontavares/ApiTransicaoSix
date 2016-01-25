package py.com.datapar.transicao.novo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.com.datapar.transicao.novo.model.MapeamentoTabela;
import py.com.datapar.transicao.novo.repo.MapeamentoTabelaRepository;

@RestController
@RequestMapping("/api")
public class TabelaController {
	
	@Autowired
	MapeamentoTabelaRepository tabRepo;
	
	@RequestMapping("/tabela")
	public Iterable<MapeamentoTabela> listaTabelas(){
		return tabRepo.findAll();
	}

	@RequestMapping( value="/tabela", method = RequestMethod.POST)
	public MapeamentoTabela addTable(@RequestBody final  MapeamentoTabela mapeamentoTabela ){
		
		System.out.println(mapeamentoTabela);
		
		MapeamentoTabela tab = tabRepo.save(mapeamentoTabela);	
		return tab;
	}

	@RequestMapping( value="/tabela", method = RequestMethod.PUT)
	public MapeamentoTabela updateTable(@RequestBody final  MapeamentoTabela mapeamentoTabela ){
		MapeamentoTabela tab = tabRepo.save(mapeamentoTabela);
		return tab;
	}

	@RequestMapping( value="/tabela/{id}", method = RequestMethod.DELETE)
	public void deleteTable(@PathVariable final long id ){
		tabRepo.delete(id);
	}	

	
}
