package py.com.datapar.transicao.novo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.com.datapar.transicao.novo.model.MapeamentoCampo;
import py.com.datapar.transicao.novo.repo.MapeamentoCampoRepository;
import py.com.datapar.transicao.novo.service.CampoInfoJson;
import py.com.datapar.transicao.novo.service.MapeamentoCampoService;

@RestController
@RequestMapping("/api")
public class CampoController {
	
	@Autowired
	MapeamentoCampoRepository tabRepo;
	
	
	@Autowired
	MapeamentoCampoService repoInfo;
	
	@RequestMapping("/campo")
	public Iterable<MapeamentoCampo> listaTabelas(){
		return tabRepo.findAll();
	}

	@RequestMapping( value="/campo", method = RequestMethod.POST)
	public MapeamentoCampo addTable(@RequestBody final  MapeamentoCampo mapeamentoCampo ){
		
		System.out.println(mapeamentoCampo);
		
		MapeamentoCampo campo = tabRepo.save(mapeamentoCampo);	
		return campo;
	}

	@RequestMapping( value="/campo", method = RequestMethod.PUT)
	public MapeamentoCampo updateTable(@RequestBody final  MapeamentoCampo mapeamentoCampo ){
		MapeamentoCampo campo = tabRepo.save(mapeamentoCampo);
		return campo;
	}

	@RequestMapping( value="/campo/{id}", method = RequestMethod.DELETE)
	public void deleteTable(@PathVariable final long id ){
		tabRepo.delete(id);
	}
	
	@RequestMapping("/info/old")
	public List<CampoInfoJson> listarInformacoesDosCamposDaBaseOld(){
		return repoInfo.listaInfoCampos();
	}
	
	@RequestMapping("/info/new")
	public List<CampoInfoJson> listarInformacoesDosCamposDaBaseNew(){
		return null;
	}
	
}
