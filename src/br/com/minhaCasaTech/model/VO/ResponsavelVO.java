package br.com.minhaCasaTech.model.VO;

public class ResponsavelVO extends PessoaVO{
	
	private String login;
	private String senha;
	private String telefone;
	
	public ResponsavelVO(String nome,String endereco,String telefone,String login,String senha) {
		super(nome, endereco);
		setLogin(login);
		setSenha(senha);
		setTelefone(telefone);
	}

	//Set
	
	public void setLogin(String login) {
		//PRECISA FAZER UM METODO PARA CHAMAR O DAO, E VERIFICAR SE O USUARIO JÁ EXISTE;
		if(login ==null)
			System.out.println("ValorNulo");
		else
			if(login.equals(""))
				System.out.println("Nada escrito");
			else
				this.login = login;
	}
	
	public void setSenha(String senha) {
		if(senha == null)
			System.out.println("Valor nulo");
		else
			if(senha.equals(""))
				System.out.println("Nada foi escrito");
			else
				if(senha.matches("(.*)([a-zA-Z][0-9])(.*)") == true)
					this.senha =  senha;
				else
					System.out.println("A senha deve conter caracteres Maiusculos, minusculos e numeros");
	}
	
	public void setTelefone(String telefone) {
		if (telefone != null)
			System.out.println("Valor nulo");
		else
			if (telefone.equals(""))
				System.out.println("Nada foi escrito");
			else
				if (telefone.length() != 11)
					System.out.println("Telefone Inválido");
				else
					this.telefone = telefone;
	}
	
	//Get
	
	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
		
	}

	public String getTelefone() {
		return telefone;
	}
}
