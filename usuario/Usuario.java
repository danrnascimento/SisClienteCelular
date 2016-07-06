package usuario;

import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.management.openmbean.OpenDataException;

import cadastro.CadClienteCelular;
import dados.Celular;
import dados.CelularCartao;
import dados.ClienteCelular;
import erros.CelularException;
import utilitarios.LtpUtil;

public class Usuario {
	
	public static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) throws CelularException{
		
		menu();
		
	}
	
	//--------------------------------------Cliente---------------------------------------//
	public static void cadastrarClienteCelular(){
		String nome, cpf, numero;
		int opcao;
		Celular celular;
		ClienteCelular cliente;
		boolean error;
		
		GregorianCalendar data = new GregorianCalendar();
		
		do{
			error = false;
			System.out.println("Digite o cpf do cliente: ");
			cpf = leia.nextLine();
			
			if(LtpUtil.validarCPF(cpf) == false || cpf.isEmpty()){
				error = true;
				System.out.println("CPF INV�LIDO");
			}else if(CadClienteCelular.listaClienteCelular.containsKey(cpf)){
				error = true;
				System.out.println("Existe cliente para o CPF");
			}
			
		}while(error == true);
		
		do{
			error = false;
			
			System.out.println("Digite o nome do Cliente: ");
			nome = leia.nextLine();
			
			if(nome.isEmpty()){
				error = true;
				System.out.println("Nome n�o pode ser vazio!");
			}
			
		}while(error == true);

		do{
			error = false;
			
			System.out.println("Digite o numero de celular do Cliente: ");
			numero = leia.nextLine();
			
			if(numero.matches("[a-zA-Z]") || numero.length() != 11){
				error = true;
				System.out.println("O Numero � inv�lido!");
			}
			
		}while(error == true);
		
		do{
			error = false;
			
			System.out.println("Qual seu plano? [1]COMUM [2]CARTAO");
			opcao = Integer.parseInt(leia.nextLine());
			
			if(opcao != 1 && opcao != 2){
				error = true;
				System.out.println("Opcao Inv�lida!");
			}
			
			if(opcao == 1){
				celular = new Celular(data, numero);
			}else{
				celular = new CelularCartao(data, numero);
				System.out.println("Insira os Creditos?");
				Double credito = Double.parseDouble(leia.nextLine());
				((CelularCartao)celular).setCreditos(credito);
			}
			
		}while(error == true);
		
		
		
		cliente = new ClienteCelular(cpf, data);
		cliente.incluirCelular(celular);
		cliente.setNome(nome);
		CadClienteCelular.incluircliente(cliente);
		
	}

	public static void excluirCliente() throws CelularException{
		
		String cpf;
		boolean error;
		do{
			error = false;
			
			System.out.println("Digite o cpf do cliente que deseja excluir");
			cpf = leia.nextLine();
			
			if(!LtpUtil.validarCPF(cpf) || cpf.isEmpty()){
				error = true;
				System.out.println("CPF Inv�lido!");
			}
			
		}while(error == true);
		
		CadClienteCelular.listaClienteCelular.get(cpf).toString();
		System.out.println("\nDeseja Excluir este cliente?");
		String opcao = leia.nextLine();
		
		if (opcao.equalsIgnoreCase("sim") || opcao.charAt(0) == 's' || opcao.charAt(0) == 'S'){
			CadClienteCelular.listaClienteCelular.remove(cpf);
		}else{
			System.out.println("cliente n�o excluido \nObrigado");
		}
		
	}
	
	public static void consultarClieteCPF() throws CelularException{
		
		String cpf;
		boolean error;
		ClienteCelular cliente = null;
		
		do{
			error = false;
			
			System.out.println("Digite o cpf do cliente: ");
			cpf = leia.nextLine();
			
			if(!LtpUtil.validarCPF(cpf) || cpf.isEmpty()){
				error = true;
				System.out.println("CPF Invalido");
			}
			
		}while(error == true);
		
		try {
			cliente = CadClienteCelular.listaClienteCelular.get(cpf);
			System.out.println(cliente.toString());;
		} catch (Exception e) {
			throw new CelularException("Nao foi possivel localizar o cliente para o cpf!");
		}
	}
	
	public static void menu() throws CelularException{
		int opcao = 0;
		do{
			System.out.println("\n========| \tEscolha uma das opções abaixo:\t  |========\n"
					+ "\n\tCLIENTES \n"
					+ "\n\t 1 - CADASTRAR UM CLIENTE"
					+ "\n\t 2 - EXCLUIR UM CLIENTE"
					+ "\n\t 3 - CONSULTAR UM CLINETE (CPF)"
					+ "\n\n\t 0 - SAIR \n");

			System.out.println("Entre com a opção desejada: ");
			try {
				opcao = Integer.parseInt(leia.nextLine());
			} catch (Exception e) {
				opcao = 99;
			}
			

			switch(opcao){
			case 0: 
				break;
			case 1:		
				cadastrarClienteCelular();
				break;
			case 2:
				excluirCliente();
				break;
			case 3:
				consultarClieteCPF();
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}

		}while(opcao != 0);

	}
}
