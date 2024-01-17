package br.com.microservice.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.microservice.loja.controller.dto.CompraDTO;
import br.com.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	public void realizaCompra(CompraDTO compra) {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<InfoFornecedorDTO> response = restTemplate.exchange("http://localhost:8081/info/"+compra.getEndereco().getEstado(), HttpMethod.GET, 
				null, InfoFornecedorDTO.class);
		System.out.println(response.getBody().getEndereco());
	}

}
