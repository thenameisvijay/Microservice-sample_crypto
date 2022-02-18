package com.github.backend.service;

import java.util.ArrayList;
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
public class CryptoServiceImpl implements CryptoService {

	@Autowired
	CryptoRepo cryptoRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<CryptoData> getAllCrypto() {
		List<CryptoEntity> cryptoEntityList = cryptoRepo.findAll();
//		return cryptoEntityList
//				.stream()
//				.map(data-> this.modelMapper.map(data, CryptoData.class))
//				.toList();

		List<CryptoData> cryptoList = new ArrayList<>();
		for (CryptoEntity entity : cryptoEntityList) {
			cryptoList
					.add(new CryptoData(entity.getId(), entity.getCryptoName(), entity.getValue(), entity.getStatus()));
		}
		return cryptoList;
	}

	@Override
	public CryptoData addCrypto(CryptoData crypto) {
		CryptoEntity cryptoEntity = this.modelMapper.map(crypto, CryptoEntity.class);
		CryptoEntity cryptoData = cryptoRepo.save(cryptoEntity);
//		return this.modelMapper.map(cryptoData, CryptoData.class);
		return new CryptoData(cryptoData.getId(), cryptoData.getCryptoName(), cryptoData.getValue(),
				cryptoData.getStatus());
	}

	@Override
	public CryptoData updateCryptoById(CryptoData cryptoData, int cryptoId) {

		Optional<CryptoEntity> entity = cryptoRepo.findById((long) cryptoId);
		if (entity.isPresent()) {
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
		this.cryptoRepo.deleteById((long) cryptoId);
		return true;
	}

}
