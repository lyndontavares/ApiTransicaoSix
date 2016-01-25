package py.com.datapar.transicao.estudo.impl;

import py.com.datapar.transicao.estudo.enums.ModuloSistema;

public class DolphinBusinessLanguage implements DolphinFormula {
	
	private ModuloSistema moduloSistema;
	
	public DolphinBusinessLanguage(ModuloSistema moduloSistema){
		this.moduloSistema=moduloSistema;
	}
	
	public DolphinFormula executeFormula(String formula ){

		if ( moduloSistema.equals(ModuloSistema.LOGISTICA) ) {
			DolphinFormula f = new DolphinFormulaLogistica();
			f.executeFormula(formula);
			return f;
		}
		
		return null;
		
	}

}
