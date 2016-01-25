package py.com.datapar.transicao.novo.model.dolphinx.produto.service;

import java.math.BigDecimal;

public interface ProdutoServiceInterface {

	/**
	 * ReajustarPrecoPercentual
	 * @param percentual
	 */
	public void ReajustarPrecoVendaPercentual(BigDecimal percentual);
	
	/**
	 * 	ReajustarPrecoFormulaSqlNativo
	 * @param formula
	 */
	public void ReajustarPrecoVendaFormulaSqlNativo(String formula);
	
	/**
	 * ReajustarPrecoFormulaDBL
	 * @param  formula 
	 */
	public void ReajustarPrecoVendaFormulaDBL(String formula);
	
	
}
