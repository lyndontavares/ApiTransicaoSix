package py.com.datapar.transicao.estudo;

import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;
import py.com.datapar.transicao.estudo.enums.ModuloSistema;
import py.com.datapar.transicao.estudo.impl.DolphinBusinessLanguage;
import py.com.datapar.transicao.estudo.impl.DolphinFormula;

public class TesteFormula {

	public static void main(String[] args) {
		
		DolphinFormula  formula2 = new DolphinBusinessLanguage(ModuloSistema.LOGISTICA)
				.executeFormula("reajustePreco1")
				.executeFormula("reajustePreco2")
				.executeFormula("reajustePrecoXXX");
		
		System.out.println(formula2);
	
		
		Function avg = new Function("avg", 4) {
		    @Override
		    public double apply(double... args) {
		        double sum = 0;
		        for (double arg : args) {
		            sum += arg;
		        }
		        return sum / args.length;
		    }
		};
		
		double result = new ExpressionBuilder("avg(1,2,3,4)")
		        .function(avg)
		        .build()
		        .evaluate();
		System.out.println(result);
		
	}
	
	
	
}
