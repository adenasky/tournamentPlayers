import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testFirstPlayerWins() {
        Player firstPlayer = new Player(1, "Liu Kang", 70);
        Player secondPlayer = new Player(2, "Kano", 50);
        Game game = new Game();

        game.register(firstPlayer);
        game.register(secondPlayer);

        int actual = game.round("Liu Kang","Kano");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerWins() {
        Player firstPlayer = new Player(1, "Liu Kang", 50);
        Player secondPlayer = new Player(2, "Kano", 70);
        Game game = new Game();

        game.register(firstPlayer);
        game.register(secondPlayer);

        int actual = game.round("Liu Kang","Kano");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDrawnGame() {
        Player firstPlayer = new Player(1, "Liu Kang", 50);
        Player secondPlayer = new Player(2, "Kano", 50);
        Game game = new Game();

        game.register(firstPlayer);
        game.register(secondPlayer);

        int actual = game.round("Liu Kang","Kano");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayerNotRegistered() {
        Player firstPlayer = new Player(1, "Liu Kang", 50);
        Player secondPlayer = new Player(2, "Kano", 70);
        Game game = new Game();

        game.register(firstPlayer);
        game.register(secondPlayer);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Johnny Cage", "Kano"));
    }

    @Test
    public void testSecondPlayerNotRegistered() {
        Player firstPlayer = new Player(1, "Liu Kang", 50);
        Player secondPlayer = new Player(2, "Kano", 70);
        Game game = new Game();

        game.register(firstPlayer);
        game.register(secondPlayer);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Liu Kang", "Johnny Cage"));
    }
}