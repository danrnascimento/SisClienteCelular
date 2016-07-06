package dados;

import java.util.GregorianCalendar;

public class Celular {

	public static final int CELULAR = 1;
	public static final int CELULARCARTAO = 2;
	
	protected String numero;
	protected GregorianCalendar data;
	
	public Celular(GregorianCalendar data, String numero){
		this.data = data;
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}


	
	@Override
	public String toString(){
		return "Numero: " + this.numero + "\nData: " + this.data + "\nTipo: "+ this.getTipo();
	}
	
	public int getTipo(){
		return CELULAR;
	}
	
}
