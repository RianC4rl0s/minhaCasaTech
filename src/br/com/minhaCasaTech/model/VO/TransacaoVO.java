package br.com.minhaCasaTech.model.VO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class TransacaoVO {

	private Long id_transacao;
	private int tipo;
	private double valorTotal;
	private double pesoTotal;
	private int totalEquip;
	private Calendar data;
	List<EquipamentoVO> equipamentos = new ArrayList<EquipamentoVO>();
	
	public TransacaoVO() {
		
	}
	
	public TransacaoVO(double valorTotal, double pesoTotal, int totalEquip, int tipo) {
		this.setValorTotal(valorTotal);
		this.setPesoTotal(pesoTotal);
		this.setTotalEquip(totalEquip);
		this.setTipo(tipo);
		this.setData();
	}
	
	// Sets
	
	public void setValorTotal(double valorTotal) {
		if (valorTotal >= 0)
			this.valorTotal = valorTotal;
		else
			System.out.println("Valor Inválido");
	}
	
	public void setPesoTotal(double pesoTotal) {
		if (valorTotal >= 0)
			this.pesoTotal = pesoTotal;
		else
			System.out.println("Valor Inválido");
	}
	
	public void setTotalEquip(int totalEquip) {
		if (totalEquip >= 0)
			this.totalEquip = totalEquip;
		else
			System.out.println("Valor Inválido");
	}
	
	public void setData() {
		TimeZone zone = TimeZone.getTimeZone("GMT-3:00");
		this.data = Calendar.getInstance(zone);
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public void addEquipamento(EquipamentoVO eqp) {
		if (eqp != null)
			equipamentos.add(eqp);
		else
			System.out.println("Equipamento Inválido");
	}
	
	public void removeEquipamento(EquipamentoVO eqp) {
		if (eqp != null)
			equipamentos.remove(eqp);
		else
			System.out.println("Equipamento Inválido");
	}
	
	// Gets
	
	public double getValorTotal() {
		return valorTotal;
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public int getTotalEquip() {
		return totalEquip;
	}
	
	public Calendar getData() {
		return data;
	}
	
	public String toString() {
		String str =
		"Valor Total: "+valorTotal+"\n"+
		"Peso Total: "+pesoTotal+"\n"+
		"Data: "+data.toString()+"\n"+
		"Equipamentos: \n";
		
		for (EquipamentoVO eqp : equipamentos) {
			str += eqp.toString();
		}
		
		return str;
	}

	public Long getId_transacao() {
		return id_transacao;
	}

	public void setId_transacao(Long id) {
		this.id_transacao = id;
	}

	public ArrayList<EquipamentoVO> getEquipamentos() {
		return (ArrayList<EquipamentoVO>) equipamentos;
	}

	public void setEquipamentos(ArrayList<EquipamentoVO> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
