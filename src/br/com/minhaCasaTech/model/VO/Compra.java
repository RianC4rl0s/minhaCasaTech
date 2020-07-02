package br.com.minhaCasaTech.model.VO;

import java.util.Calendar;

public class Compra {
	private double valorTotal;
	private double pesoTotal;
	private int totalEquip;
	private Equipamento[] equipList = new Equipamento[totalEquip];
	private Calendar data;
	private Calendar hora;
	
	
	
	//Set
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	public void setTotalEquip(int totalequip) {
		this.totalEquip = totalequip;
	}
	public void setData(Calendar data) {
		if(data == null) {
			System.out.println("VAlor nulo");
		}else {
			this.data = data;
		}
	}
	public void setHora(Calendar hora) {
		if(data == null) {
			System.out.println("VAlor nulo");
		}else {
			this.hora = hora;
		}
	}
	public void setEquipList(Equipamento[] equipList) {
		if(equipList == null) {
			System.out.println("Valor nulo");
		}else {
		
		int tamanho = this.totalEquip;
			for (int i = 0; i < tamanho; i++) {
				this.equipList[i] =  equipList[i];
			}
		}
	}
	
	
	
	//Get
	public double getValorTotal() {
		return valorTotal;
	}
	public double getPesoTotal() {
		return pesoTotal;
	}
	public int getTotalequip() {
		return totalEquip;
	}
	public Calendar getData() {
		return data;
	}
	public Calendar getHora() {
		return hora;
	}
	public Equipamento[] getEquiplist(){
		
	return equipList;
	
	}
	
}
