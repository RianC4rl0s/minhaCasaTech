package br.com.minhaCasaTech.model.VO;

public class logVO {
	private String data;
	private String usuario;
	private String modificacao;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getModificacao() {
		return modificacao;
	}
	public void setModificacao(String modificacao) {
		this.modificacao = modificacao;
	}
	@Override
	public String toString() {
		return "logVO [data=" + data + ", usuario=" + usuario + ", modificacao=" + modificacao + "]";
	}
}
