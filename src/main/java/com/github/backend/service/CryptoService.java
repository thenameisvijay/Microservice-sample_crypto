package com.github.backend.service;

import java.util.List;

import com.github.backend.model.CryptoData;

public interface CryptoService {
	
	public List<CryptoData> getAllCrypto();
	
	public CryptoData addCrypto(CryptoData cryptoData);
	
	public CryptoData updateCryptoById(CryptoData cryptoData, int cryptoId);
	
	public boolean deleteCryptoById(int cryptoId);
}
