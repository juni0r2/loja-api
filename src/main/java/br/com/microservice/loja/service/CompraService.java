package br.com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.loja.client.InfoFornecedorClient;
import br.com.microservice.loja.controller.dto.CompraDTO;
import br.com.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	@Autowired
	InfoFornecedorClient client;
	//	@Autowired
//	private RestTemplate client;

//	@Autowired
//	private DiscoveryClient discoveryClient;
	
	public void realizaCompra(CompraDTO compra) {
		
		InfoFornecedorDTO dto = this.client.getRetornaFornecedor(compra.getEndereco().getEstado());
		System.out.println(dto.getEndereco());
		
//		this.discoveryClient.getInstances("fornecedor").forEach(fornecedor -> {
//			System.out.println("localhost:"+fornecedor.getPort());
//		});
	}

}
