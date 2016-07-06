package dados;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import erros.CelularException;
import utilitarios.LtpUtil;

public class ClienteCelular {
	
	private String cpf;
	private String nome;
	private GregorianCalendar data;
	private ArrayList<Celular> listaDeCelulares = new ArrayList<>();
	
	public ClienteCelular(String cpf, GregorianCalendar data){
		this.cpf = cpf;
		this.data = data;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public ArrayList<Celular> getListaDeCelulares() {
		return listaDeCelulares;
	}

	public void setListaDeCelulares(ArrayList<Celular> listaDeCelulares) {
		this.listaDeCelulares = listaDeCelulares;
	}
	
	public Celular pesquisarCelular(String numero) throws CelularException{
		Celular celular = null;
		
		for(Celular aux : listaDeCelulares){
			if (aux.getNumero().equals(numero)){
				celular = aux;
			}
		}
		
		if(celular != null){
			return celular;
		}else{
			throw new CelularException("N�o encontrado");
		}
	}
	
	public void incluirCelular(Celular celular){
		this.listaDeCelulares.add(celular);
	}
	
	public void excluirCelular(Celular celular){
		this.listaDeCelulares.remove(celular);
	}
	
	@Override
	public String toString(){
		return "Nome: " + this.nome + 
				"\nCPF: " + this.cpf + 
				"\nData: " + LtpUtil.formatarData(this.data, "dd/MM/yyyy") + 
				"\nCelulares: " + this.listaDeCelulares.toString();
	}


	
}
