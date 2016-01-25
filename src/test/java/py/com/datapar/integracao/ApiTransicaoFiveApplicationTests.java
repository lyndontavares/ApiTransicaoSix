package py.com.datapar.integracao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;
import net.objecthunter.exp4j.function.Function;
import py.com.datapar.transicao.ApiTransicaoFiveApplication;
import py.com.datapar.transicao.novo.repo.MapeamentoTabelaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApiTransicaoFiveApplication.class)
@WebAppConfiguration
public class ApiTransicaoFiveApplicationTests {

	@Autowired
	MapeamentoTabelaRepository repo;
	
	@Autowired
	EntityManager em;
	
	public void contextLoads() {

		expressionOne();
		expressionTwo();
		expressionThree();
		expressionFour();
		
	}
	
	@Test
	public void expressionFour() {
		
		Function dobraQtde = new Function("dobraQtde",0){

			@Override
			public double apply(double... args) {
				//repo.findById(1).iterator().next().getOrdemAtualizacao() ;
				@SuppressWarnings("unchecked")
				List<Object> query = em.createNamedQuery("select quantidade from api_formula").getResultList();
				return Long.valueOf( query.iterator().next().toString() ) * 2;
			}
			
			
		};
		
		double result = new ExpressionBuilder("reaj(1)")
		        .function(dobraQtde)
		        .build()
		        .evaluate();
		
		System.out.println(result);
		
		
	}

	@Test
	public void expressionOne(){
		
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

		double expected = 2.5d;
		assertEquals(expected, result, 0d);
		

	}
	
	@Test
	public void expressionTwo(){
		
		Function count = new Function("count", 1) {

		    @Override
		    public double apply(double... args) {
		        return repo.count();
		    }
		};
		
		
		double result = new ExpressionBuilder("count(0) + 2")
		        .function(count)
		        .build()
		        .evaluate();

		//System.out.println(result);
		
		double expected = 10d;
		assertEquals(expected, result, 0d);
		
		
	}
	
	@Test
	public void expressionThree(){
		
		Expression e = new ExpressionBuilder("x")
		        .variable("x")
		        .build();

		ValidationResult res = e.validate();
		assertFalse(res.isValid());
		assertEquals(1, res.getErrors().size());

		e.setVariable("x",1d);
		res = e.validate();
		assertTrue(res.isValid());
	}

}
