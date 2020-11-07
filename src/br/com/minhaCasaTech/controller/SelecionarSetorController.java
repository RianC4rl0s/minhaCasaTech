package br.com.minhaCasaTech.controller;

import br.com.minhaCasaTech.view.Telas;

public class SelecionarSetorController {

	public void abrirPrincipal() {
		try {
			Telas.telaPrincipal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void fechar() {
		try {
			Telas.fecharTela();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void abrirSetorADM() {
		try {
			Telas.telaSetorProprietario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
