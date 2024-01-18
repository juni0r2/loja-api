package br.com.microservice.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.microservice.loja.controller.dto.InfoFornecedorDTO;

@FeignClient("fornecedor")
public interface InfoFornecedorClient {

	@GetMapping("/info/{estado}")
	InfoFornecedorDTO getRetornaFornecedor(@PathVariable String estado);

}
