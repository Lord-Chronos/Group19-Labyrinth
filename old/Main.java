package core;

import holdables.Tile;
import players.Player;
import styles.CarStyle;
import styles.PirateStyle;
import styles.Style;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        Style style = new PirateStyle();
        ArrayList<Player> players = new ArrayList<>();
        Gameboard gameboard = new Gameboard(new int[]{10, 10}, style, players);
        gameboard.boardToString();
        System.out.println(Tile.class.getName());
    }
    private static void makeGameboard() {
        Style style = new CarStyle();
        ArrayList<Player> players = new ArrayList<>();
        Gameboard gameboard = new Gameboard(new int[]{2, 2}, style, players);
        Tile tile = new Tile (new int[]{2, 2}, 2, style, 90, True);

    }
}
