package br.com.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.microservice.loja.controller.dto.InfoFornecedorDTO;
import br.com.microservice.loja.controller.dto.InfoPedidoDTO;
import br.com.microservice.loja.controller.dto.IntemDaCompraDTO;

@FeignClient("fornecedor")
public interface InfoFornecedorClient {

	@GetMapping("/info/{estado}")
	InfoFornecedorDTO getRetornaFornecedor(@PathVariable String estado);

	@PostMapping("/pedido")
	InfoPedidoDTO realizaCompra(List<IntemDaCompraDTO> itens);

}
