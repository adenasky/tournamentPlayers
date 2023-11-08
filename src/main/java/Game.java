import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Game {
    HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.name, player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

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