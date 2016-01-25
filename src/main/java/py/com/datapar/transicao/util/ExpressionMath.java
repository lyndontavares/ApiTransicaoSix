package py.com.datapar.transicao.util;

import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

public class ExpressionMath {

	
	public static void main(String[] args) {
		
		
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

		//double expected = 2.5d;
		//assertEquals(expected, result, 0d);
		
		System.out.println(result);
		
		
	}
	
	
	
}
