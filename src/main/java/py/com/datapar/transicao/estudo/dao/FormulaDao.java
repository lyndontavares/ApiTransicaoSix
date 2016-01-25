package py.com.datapar.transicao.estudo.dao;

import java.util.ArrayList;
import java.util.List;

public class FormulaDao {

	private List<Formula> formulas;
	
	public FormulaDao(){
		formulas = new ArrayList<>();
		formulas.add( new Formula(1,"reajustePreco1") );
		formulas.add( new Formula(2,"reajustePreco2") );
	}

	
	public Formula findById(long id){
		return formulas.get((int)id);
	}

	public Formula findByNome(String descricao){
		for (Formula formula : formulas) {
			if ( formula.getDescricao().equals(descricao)){
				return formula;
			}
		}
		return null;
	}
	
	
}
