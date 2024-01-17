package br.com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.microservice.loja.controller.dto.CompraDTO;
import br.com.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	@Autowired
	private RestTemplate client;
	
	public void realizaCompra(CompraDTO compra) {

		ResponseEntity<InfoFornecedorDTO> response = this.client.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), 
				HttpMethod.GET, null, InfoFornecedorDTO.class);
		System.out.println(response.getBody().getEndereco());
	}

}
