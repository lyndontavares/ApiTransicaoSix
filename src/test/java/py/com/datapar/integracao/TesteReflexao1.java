package py.com.datapar.integracao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TesteReflexao1 {

	
	public static void main(String[] args) throws Exception {
		 Class<?> cls = Class.forName("py.com.datapar.integracao.novo.model.MapeamentoTabela");
	     //cls.getDeclaredAnnotations(); // get all annotation
	     //(cls.getDeclaredMethods()[0]).getAnnotations(); //get annotation of a method

		 Annotation ety = cls.getAnnotation(javax.persistence.Table.class)  ; // get annotation of particular annotation class
	     System.out.println(ety);
	     
	    // Method met = cls.getMethod("name");
	    // System.out.println(met);
	     
	     System.out.println( 
	    		 
	    		 UtilAnnotation.getAnnotationValue(
	    		  py.com.datapar.transicao.novo.model.MapeamentoTabela.class, 
	    		  javax.persistence.Table.class, "name").toString() );
	}
}
