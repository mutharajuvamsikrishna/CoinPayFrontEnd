package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Converter;
import com.web.repo.ProRepo;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ProController {

	@Autowired
	private ProRepo proRepo;
	@Autowired
	private ProRepo repo1;

	@PutMapping("/addcoins")
	public String walletadd1(@RequestBody Converter con1) {
		String mob = con1.getMob();
		String password = con1.getPassword();
		double coins = con1.getCoins();

		Converter con = repo1.findByMobAndPassword(mob, password);
		System.out.println(mob + "  mob is");
		System.out.println(password + "  password is");
		System.out.println(coins + "   coins1 is");
		if (con != null) {

			double coin = 0;
			coin = con.getCoins();

			coin = coin + coins;

			con.setCoins(coin);
			repo1.save(con);

			return "sucess";

		} else {

			return "delete1";
		}
	}

	@PutMapping("/sendcoins")
	public String sendcoins(@RequestBody Converter con1) {
		String email = con1.getEmail();
		String mob = con1.getMob();
		double coins = con1.getCoins();
		String password = con1.getPassword();
		Converter con = repo1.findByEmailAndPassword(email, password);

		Converter user = repo1.findByMob(mob);
		System.out.println("email is " + email);
		System.out.println("mob is " + mob);
		System.out.println("coins is " + coins);
		System.out.println("password is " + password);
		if (con != null && user != null) {

			double coins2 = con.getCoins();
			System.out.println("balance coins is " + coins2);
			if (coins2 > coins) {
				double coins3 = coins2 - coins;
				con.setCoins(coins3);
				repo1.save(con);

				Double ucoins = user.getCoins();
				ucoins = ucoins + coins;
				user.setCoins(ucoins);

				repo1.save(user);
				return "success";
			} else {
				return "insufficent";
			}

		} else {
			return "Invalid Credits";
		}

	}

	@PostMapping("/checkbalance")
	public String checkbalance1(@RequestBody Converter con1) {

		String mob = con1.getMob();
		String password = con1.getPassword();
		Converter con = repo1.findByMobAndPassword(mob, password);

		if (con != null) {

			return "proceed";
		} else {
			return "invalid";
		}

	}

	@GetMapping("/balancecheck")
	public Converter checkbalance(@RequestParam String mob) {

		Converter con = repo1.findByMob(mob);

		if (con != null) {

			return con;
		} else {
			return null;
		}

	}

	@GetMapping("/viewallusers")

	public List<Converter> getPerEmps() {
		return repo1.findAll();
	}

}
