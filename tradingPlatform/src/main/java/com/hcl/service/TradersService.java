package com.hcl.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entity.Traders;
import com.hcl.repo.TradersRepo;

@Service
public class TradersService {

	@Autowired
	private TradersRepo tradersRepo;

	public Traders createTraders(Traders traders) {
		traders.setCreated(LocalDateTime.now().toString());
		traders.setUpdated(LocalDateTime.now().toString());
		Traders traders2 = tradersRepo.save(traders);
		return traders2;

	}

	public List<Traders> getAllTraders() {
		List<Traders> list = tradersRepo.findAll();
		return list.stream().sorted(Comparator.comparing(Traders::getId)).collect(Collectors.toList());
	}

	public Traders getTradersByEmail(String email) {
		return tradersRepo.findByEmail(email);
	}

	public Traders updateTradersByEmail(String email, String name) {
		Traders traders2 = tradersRepo.findByEmail(email);
		if (traders2 != null) {
			traders2.setName(name);
			traders2.setUpdated(LocalDateTime.now().toString());
			return traders2;
		} else {
			return null;
		}

	}

	public Traders updateAmountByEmail(String email, double amount) {
		Traders traders2 = tradersRepo.findByEmail(email);
		Traders traders = new Traders();
		if (traders2 != null) {
			traders.setBalance(amount);
			traders.setEmail(traders2.getEmail());
			traders.setName(traders2.getName());
			traders.setCreated(traders2.getCreated());
			traders.setUpdated(LocalDateTime.now().toString());
			traders.setId(traders2.getId());
			return traders;
		} else {
			return null;
		}
	}

}
