package py.com.datapar.transicao.novo.model.enums;

public enum TipoCampo {

	STRING, NUMERIC, NUMBER, DATE, DATETIME, VARCHAR2, VARCHAR, TIMESTAMP, TIME, DECIMAL, INT, TEXT;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public static TipoCampo  fromString(String text) {
	    if (text != null) {
	      for (TipoCampo b : TipoCampo.values()) {
	        if (text.equalsIgnoreCase(b.toString())) { 
	          return b;
	        }
	      }
	    }
	    return null;
	  }
}
