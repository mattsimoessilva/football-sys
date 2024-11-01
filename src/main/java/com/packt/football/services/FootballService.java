package com.packt.football.services;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.List;

import com.packt.football.model.*;
import com.packt.football.exceptions.*;

@Service
public class FootballService {
		private final Map<String, Player> players = Map.ofEntries(
			Map.entry("1884823", new Player("1884823", 5, "Ivana ANDRES", "Defender", LocalDate.of(1994, 07, 13))),
			Map.entry("325636", new Player("325636", 11, "Alexia PUTELLAS", "Midfielder", LocalDate.of(1994, 02, 04)))
		);
	
		public List<Player> listPlayers() {
			return players.values().stream()
						.collect(Collectors.toList());
		}
	
		public Player getPlayer(String id) {
			Player player = players.get(id);

			if (players.containsKey(player.id())) {
				throw new AlreadyExistsException("The player already exists");
			} else {
				players.put(player.id(), player);
				return player;
			}
		}
	
		public Player addPlayer(Player player) {
			if (players.containsKey(player.id())) {
					throw new AlreadyExistsException("The player already exists");
			} else {
				players.put(player.id(), player);
				return player;
			}
		}
	
		public Player updatePlayer(Player player) {
			if (!players.containsKey(player.id())) {
				throw new NotFoundException("The player does not exist");
			} else {
				players.put(player.id(), player);
				return player;
			}
		}
	
		public void deletePlayer(String id) {
			if (players.containsKey(id)) {
				players.remove(id);
			}
		}
	
		
}