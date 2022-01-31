package com.github.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.backend.model.CryptoData;
import com.github.backend.service.CryptoService;

@RestController
@RequestMapping("/crypto")
public class CryptoController {

	@Autowired
	CryptoService cryptoService;

	@GetMapping(value = "/read")
	public List<CryptoData> getAllCryptoData() {
		return cryptoService.getAllCrypto();
	}

	@PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public CryptoData addCryptoData(@RequestBody CryptoData cryptoData) {
		return cryptoService.addCrypto(cryptoData);
	}
	
	@PutMapping(value = "/update")
	public CryptoData updateCryptoData(@RequestBody CryptoData cryptoData) {
		return cryptoService.updateCryptoById(cryptoData);
	}
	
	@DeleteMapping(value = "/delete")
	public boolean deleteCryptoData(@RequestParam("crypto_id") int cryptoId) {
		return cryptoService.deleteCryptoById(cryptoId);
	}
}
