package com.hcl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Traders;

@Repository
public interface TradersRepo extends JpaRepository<Traders, Long> {

	
	Traders findByEmail(String email);

//	Traders saveByEmail(String email);

}
