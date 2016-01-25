package py.com.datapar.transicao.estudo.impl;

import py.com.datapar.transicao.estudo.dao.Formula;
import py.com.datapar.transicao.estudo.dao.FormulaDao;

public class DolphinFormulaLogistica implements DolphinFormula {

	public DolphinFormulaLogistica() {
	}

	public DolphinFormula executeFormula(String formula) {
		Formula f = new FormulaDao().findByNome(formula);
		if ((f != null)) {
			System.out.println("formula " + formula + " executada!");
		} else {
			System.out.println("formula " + formula + " não encontrada!");
		}
		return this;
	}

	@Override
	public String toString() {
		return "DolphinFormulaLogistica []";
	}

}
