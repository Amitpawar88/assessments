package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Traders;
import com.hcl.service.TradersService;

@RestController
@RequestMapping("/trading/traders")
public class TradersController {

	@Autowired
	private TradersService tradersService;

	@PostMapping("/register")
	public ResponseEntity<Traders> createTraders(@RequestBody Traders traders) {
		Traders traders2 = tradersService.createTraders(traders);
		return ResponseEntity.ok().body(traders2);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Traders>> getAllTraders() {
		List<Traders> list = tradersService.getAllTraders();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/all/{email}")
	public ResponseEntity<Traders> getAllTradersByEmail(@PathVariable String email) {
		Traders traders = tradersService.getTradersByEmail(email);
		if (traders != null) {
			return ResponseEntity.ok().body(traders);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PutMapping("/name/{email}")
	public ResponseEntity<Traders> updateName(@PathVariable String email, String name) {
		Traders traders2 = tradersService.updateTradersByEmail(email, name);
		if (traders2 != null) {
			return ResponseEntity.ok().body(traders2);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PutMapping("/amount/{email}")
	public ResponseEntity<Traders> updateAmount(@PathVariable String email, double amount) {
		Traders traders2 = tradersService.updateAmountByEmail(email, amount);
		if (traders2 != null) {
			return ResponseEntity.ok().body(traders2);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> deleteTracks(@PathVariable long id){
//		  musicTracksService.deleteTracksById(id);
//		return ResponseEntity.ok().build();
//	}
}
