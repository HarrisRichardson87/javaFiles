package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalvoApplication {


	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository repository,GameRepository gameRepository, GamePlayerRepository gamePlayerRepository,ShipRepository shipRepository) {
		return (args) -> {
			//Create Games//
			Game game_test_one = new Game("Test_Game 1");
			Game game_test_two = new Game("Test_Game_2");

			//Create GamePlayers//
			GamePlayer gamePlayer_one = new GamePlayer();
			GamePlayer gamePlayer_two = new GamePlayer();

			//Creates Player//
			Player player_one = new Player("Player One");
			Player player_two = new Player("Player Two");

			//Create Ships//
			Ship ship_one = new Ship("Destroyer","The Destroyer");
			Ship ship_two = new Ship("Chapo","Cruzer");


			//Add GamePlayers to Game
			game_test_one.addGamePlayer(gamePlayer_one);
			game_test_one.addGamePlayer(gamePlayer_two);

			//Add GamePlayers to Player//

			player_one.addGamePlayer(gamePlayer_one);
			player_two.addGamePlayer(gamePlayer_two);

			//Add Ships to Player to GamePlayer//


			//Add Locations to Ships//

			ShipLocation spot_one = new ShipLocation("H2");
			ShipLocation spot_two = new ShipLocation("H3");

			ship_two.addShipLocation(spot_one);
			ship_two.addShipLocation(spot_two);

			gamePlayer_one.setShips(ship_one);
			gamePlayer_two.setShips(ship_two);


			gamePlayerRepository.saveAndFlush(gamePlayer_one);
			gamePlayerRepository.saveAndFlush(gamePlayer_two);
			gameRepository.saveAndFlush(game_test_one);
			gameRepository.saveAndFlush(game_test_two);


	};

	}
}
