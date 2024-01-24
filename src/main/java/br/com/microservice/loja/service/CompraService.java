package br.com.microservice.loja.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.loja.client.InfoFornecedorClient;
import br.com.microservice.loja.controller.dto.CompraDTO;
import br.com.microservice.loja.controller.dto.InfoFornecedorDTO;
import br.com.microservice.loja.controller.dto.InfoPedidoDTO;
import br.com.microservice.loja.model.Compra;


@Service
public class CompraService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

	@Autowired
	InfoFornecedorClient client;
	//	@Autowired
//	private RestTemplate client;

//	@Autowired
//	private DiscoveryClient discoveryClient;
	
	public Compra realizaCompra(CompraDTO compra) {
		
		LOG.info("buscando informações do fornecedor de {}", compra.getEndereco().getEstado() );
		InfoFornecedorDTO dto = this.client.getRetornaFornecedor(compra.getEndereco().getEstado());
		System.out.println(dto.getEndereco());

		LOG.info("realizando um pedido");
		InfoPedidoDTO infoPedidoDTO = this.client.realizaCompra(compra.getItens());
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(infoPedidoDTO.getId());
		compraSalva.setTempoDePreparo(infoPedidoDTO.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		return compraSalva;
		
//		this.discoveryClient.getInstances("fornecedor").forEach(fornecedor -> {
//			System.out.println("localhost:"+fornecedor.getPort());
//		});
	}

}
