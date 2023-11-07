import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName() == playerName1) {
                player1 = player;
            }
            if (player.getName() == playerName2) {
                player2 = player;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException(
                    playerName1 + " not registered"
            );
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    playerName2 + " not registered"
            );
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}