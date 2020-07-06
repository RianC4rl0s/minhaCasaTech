package br.com.minhaCasaTech.model.VO;

public class Usuario {
	private String login;
	private String senha;
	private int nivel;
	
	
	//Set
	public void setLogin(String login) {
		
		//PRECISA FAZER UM METODO PARA CHAMAR O DAO, E VERIFICAR SE O USUARIO JA EXISTE;
		if(login ==null) {
			System.out.println("ValorNulo");
			
		}else {
			if(login.equals("")) {
				System.out.println("Nada escrito");
			}else {
				System.out.println(this.login);
			this.login = login;
			}
		
		}
	}
	public void setSenha(String senha) {
		if(senha == null) {
			System.out.println("Valor nulo");
		}else {
			if(senha.equals("")) {
				System.out.println("Nada foi escrito");
			}else {
				if(senha.matches("[a-zA-Z][0-9]")  == true) {
					this.senha =  senha;
					System.out.println(this.senha);
				}else if(senha.matches("[a-zA-Z][0-9]")== false) {
					System.out.println("A senha deve conter caracteres Maiusculos, minusculos e numeros");
				}
			}
			
		}
		
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	//Get
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
		
	}
	public int getNivel() {
		return nivel;
	}
	
	
	
}
