package com.github.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.backend.model.CryptoData;
import com.github.backend.service.CryptoService;

@RestController
//@CrossOrigin(origins="*")
@RequestMapping("/crypto")
public class CryptoController {

	@Autowired
	CryptoService cryptoService;

	@GetMapping("/read")
	public List<CryptoData> getAllCryptoData() {
		return cryptoService.getAllCrypto();
	}

	@PostMapping(value="/create", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public CryptoData addCryptoData(@RequestBody CryptoData cryptoData) {
		return cryptoService.addCrypto(cryptoData);
	}
	
	@PutMapping(value="/update/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public CryptoData updateCryptoData(@RequestBody CryptoData cryptoData, @PathVariable(value="id") int cryptoId) {
		return cryptoService.updateCryptoById(cryptoData, cryptoId);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteCryptoData(@PathVariable(value="id") int cryptoId) {
		return cryptoService.deleteCryptoById(cryptoId);
	}
}
