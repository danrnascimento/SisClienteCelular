package dados;

import java.util.GregorianCalendar;

public class CelularCartao extends Celular{

	private Double creditos;
	
	public CelularCartao(GregorianCalendar data, String numero) {
		super(data, numero);
		this.creditos = 0.0;
	}

	public Double getCreditos() {
		return creditos;
	}

	public void setCreditos(Double creditos) {
		this.creditos = creditos;
	}
	
	@Override
	public String toString(){
		return super.toString() + "\nCreditos: " + this.creditos;
	}
	
	@Override
	public int getTipo(){
		return CELULARCARTAO;
	}
	
	
	
}
