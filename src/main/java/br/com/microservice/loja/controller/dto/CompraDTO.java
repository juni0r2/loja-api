package br.com.microservice.loja.controller.dto;

import java.util.List;

public class CompraDTO {
	
	private List<IntemDaCompraDTO> itens;
	
	private EnderecoDTO endereco;

	public List<IntemDaCompraDTO> getItens() {
		return itens;
	}

	public void setItens(List<IntemDaCompraDTO> itens) {
		this.itens = itens;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	
	
}
