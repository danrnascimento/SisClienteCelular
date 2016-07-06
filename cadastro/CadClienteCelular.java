package cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import dados.ClienteCelular;
import erros.CelularException;

public class CadClienteCelular {
	
	
	public static HashMap<String, ClienteCelular> listaClienteCelular  = new HashMap<String, ClienteCelular>();
	
	public static ClienteCelular consultarClienteCpf(String cpf) throws CelularException{
		
		ClienteCelular cliente;
		
		cliente = listaClienteCelular.get(cpf);
		
		if(cliente != null){
			return cliente;
		}else{
			throw new CelularException("Não existe cliente para este cpf");
		}
		
	}
	
	public static void incluircliente(ClienteCelular cliente){
		listaClienteCelular.put(cliente.getCpf(), cliente);
	}
	
	public static void excluirCliente(ClienteCelular cliente){
		listaClienteCelular.remove(cliente);
	}
	
	public static ClienteCelular consultarClienteCelular(String numero) throws CelularException{
		
		ClienteCelular cliente = null;
		
		for(ClienteCelular aux : listaClienteCelular.values()){
			if(aux.getNome().equals(numero)){
				cliente = aux;
			}
		}
		
		if(cliente != null){
			return cliente;
		}else{
			throw new CelularException("Não encontrado cliente para este número");
		}
	}
	
	
	public static ArrayList<ClienteCelular> consultarClienteNome(String nome) throws CelularException{
		
		ArrayList<ClienteCelular> listaAux = new ArrayList<ClienteCelular>();
		
		for(ClienteCelular aux : listaClienteCelular.values()){
			if (aux.getNome().equals(nome)){
				listaAux.add(aux);
			}
		}
		
		
		if(listaAux.isEmpty()){
			throw new CelularException("Não existe cliente com este nome");
		}else{
			Collections.sort(listaAux, new Comparator<ClienteCelular>() {
				
				@Override
				public int compare(ClienteCelular auxiliar1, ClienteCelular auxiliar2) {
					
					return auxiliar1.getNome().compareTo(auxiliar2.getNome());
				}
				
			});
			
			return listaAux;
		}
	}
	
	
	
}
