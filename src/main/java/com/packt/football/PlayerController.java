package com.packt.football;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.packt.football.model.*;
import com.packt.football.services.*;

@RequestMapping("/players")
@RestController
public class PlayerController {
		
		private FootballService footballService;
		
		public PlayerController(FootballService footballService) {
			this.footballService = footballService;
		}
	
		@GetMapping
		public List<Player> listPlayers() {
			return footballService.listPlayers();
		}
	
		@GetMapping("/{id}")
		public Player readPlayer(@PathVariable String id) {
			return footballService.getPlayer(id);
		}
	
		@PostMapping
		public void createPlayer(@RequestBody Player player) {
			footballService.addPlayer(player);
		}
	
		@PutMapping("/{id}")
		public void updatePlayer(@PathVariable String id, @RequestBody Player player) {
			footballService.updatePlayer(player);
		}

		@DeleteMapping("/{id}")
		public void deletePlayer(@PathVariable String id) {
			footballService.deletePlayer(id);
		}
}

