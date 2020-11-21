//automatically did this - needs changing
import javafx.scene.image.Image;

/**
 * Template for a Style type that can be chosen when starting a game.
 *
 * @author Aaron Davies, Isabelle Ludwig & Joseph Omar
 * @version 2.0
 * <p>
 * Styles may need more images than the ones originally thought of for example:
 * Icons for the sprites on the selection screen
 * Icons for the SilkBag/hand menus
 * Effect variations of tiles
 * effect variations of players
 * Menu backrounds?
 */

/**
 * icons
 * create three classes to split up the stuff into to make it easier to access from other classes ie make it more customisable later on...
 */
public class Style {
public abstract class Style implements Serializable {

    protected static Image PLAYER_ONE = null;
    protected static Image PLAYER_TWO = null;
    protected static Image PLAYER_THREE = null;
    protected static Image PLAYER_FOUR = null;
    protected static Image STRAIGHT_TILE = null;
    protected static Image CORNER_TILE = null;
    protected static Image JUNCTION_TILE = null;
    protected static Image GOAL_TILE = null;
    protected static Image GAMEBOARD = null;

    /**
     * Gets the image corresponding to the player number of a player
     *
     * @param playerNumber The number of the player 1-4
     * @return The players sprite
     */
    public static Image getPlayerImage(int playerNumber) {
        switch (playerNumber) {
            case 1:
                return PLAYER_ONE;
            case 2:
                return PLAYER_TWO;
            case 3:
                return PLAYER_THREE;
            case 4:
                return PLAYER_FOUR;
            default:
                throw new IndexOutOfBoundsException("<" + playerNumber + "> is not a valid player number");
        }
    }

    /**
     * Gets the Corner Tile Image
     *
     * @return Corner Tile Image
     */
    public static Image getCornerTile() {
        return CORNER_TILE;
    }

    /**
     * Gets the Straight Tile Image
     *
     * @return Straight Tile Image
     */
    public static Image getStraightTile() {
        return STRAIGHT_TILE;
    }

    /**
     * Gets the Goal Tile Image
     *
     * @return Goal Tile Image
     */
    public static Image getGoalTile() {
        return GOAL_TILE;
    }

    /**
     * Gets the Junction Tile Image
     *
     * @return Junction Tile Image
     */
    public static Image getJunctionTile() {
        return JUNCTION_TILE;
    }

    /**
     * Gets the Gameboard Border Image
     *
     * @return Gameboard Border Image
     */
    public static Image getGameboardImage() {
        return GAMEBOARD;
    }

    private static Image PLAYER_ONE;
    private static Image PLAYER_TWO;
    private static Image PLAYER_THREE;
    private static Image PLAYER_FOUR;
    private static Image STRAIGHT_TILE;
    private static Image CORNER_TILE;
    private static Image JUNCTION_TILE;
    private static Image GOAL_TILE;
    private static Image GAMEBOARD_BORDER;


}
