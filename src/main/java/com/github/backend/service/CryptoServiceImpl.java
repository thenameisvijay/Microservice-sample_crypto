package com.github.backend.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.backend.entity.CryptoEntity;
import com.github.backend.exception.CustomException;
import com.github.backend.model.CryptoData;
import com.github.backend.repo.CryptoRepo;

@Service
public class CryptoServiceImpl implements CryptoService{

	@Autowired
	CryptoRepo cryptoRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<CryptoData> getAllCrypto() {
		List<CryptoEntity> cryptoEntityList = this.cryptoRepo.findAll();
		return cryptoEntityList
				.stream()
				.map(data-> this.modelMapper.map(data, CryptoData.class))
				.toList();
	}

	@Override
	public CryptoData addCrypto(CryptoData cryptoData) {
		CryptoEntity cryptoEntity = this.modelMapper.map(cryptoData, CryptoEntity.class);
		this.cryptoRepo.save(cryptoEntity);
		return this.modelMapper.map(cryptoData, CryptoData.class);
	}

	@Override
	public CryptoData updateCryptoById(CryptoData cryptoData) {
		
		Optional<CryptoEntity> entity = this.cryptoRepo.findById(cryptoData.getId());
		if (!entity.isEmpty()) {
			CryptoEntity cryptoEntity = entity.get();
			cryptoEntity.setId(cryptoData.getId());
			cryptoEntity.setCryptoName(cryptoData.getName());
			cryptoEntity.setValue(cryptoData.getValue());
			cryptoEntity.setStatus(cryptoData.getStatus());
			this.cryptoRepo.save(cryptoEntity);
			return this.modelMapper.map(cryptoEntity, CryptoData.class);
		} else {
			throw new CustomException("Could not update");
		}
	}

	@Override
	public boolean deleteCryptoById(int cryptoId) {
		Optional<CryptoEntity> entity = cryptoRepo.findById(cryptoId);
		if (!entity.isEmpty()) {
			this.cryptoRepo.deleteById(cryptoId);
			return true;
		}else {
			throw new CustomException("Could not delete");
		}
		
	}
	
	
}
