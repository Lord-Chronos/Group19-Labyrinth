import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class for players in game
 *
 * @author Joshua Murray
 * @version 1.0
 */
public class Player implements Serializable {
    private PlayerProfile profile;
    private Coordinate coordinate;
    private ArrayList<Effect> hand;
    private Style style;
    private int playerNum;
    private int currentDirection;
    private PlayerEffect activeEffect;

    /**
     * Constructor for a player
     *
     * @param profile   Profile of a player
     * @param coord     Coordinates of gameboard of player
     * @param style     Style of piece for player
     * @param playerNum Player number
     */
    public Player(PlayerProfile profile, Coordinate coord, Style style, int playerNum) {
        setProfile(profile);
        setCoordinate(coord);
        setStyle(style);
        setPlayerNum(playerNum);
        setCurrentDirection(0);

    }

    /**
     * Gets players profile
     *
     * @return Players profile
     */
    public PlayerProfile getProfile() {
        return profile;
    }

    /**
     * Sets the profile
     *
     * @param profile Profile of player
     */
    private void setProfile(PlayerProfile profile) {
        this.profile = profile;
    }

    /**
     * Gets coordinates of player
     *
     * @return Coordinates of player
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Sets coordinates of player on gameboard
     *
     * @param coordinate Coordinate object for player
     */
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Adds an effect card to players hand
     *
     * @param effect Effect card
     */
    public void addToHand(Effect effect) {
        hand.add(effect);
    }

    /**
     * Gets the current card hand of player
     *
     * @return Card hand of player
     */
    public ArrayList<Effect> getHand() {
        return hand;
    }

    /**
     * Sets the card hand of a player
     *
     * @param hand Players hand
     */
    private void setHand(ArrayList<Effect> hand) {
        this.hand = hand;
    }

    /**
     * Sets the style
     *
     * @param style Style of player piece
     */
    public void setStyle(Style style) {
        this.style = style;
    }

    /**
     * Gets players number
     *
     * @return Players number
     */
    public int getPlayerNum() {
        return playerNum;
    }

    /**
     * Sets players number
     *
     * @param playerNum Players number
     */
    private void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    /**
     * Gets direction player is facing
     *
     * @return Direction player is facing
     */
    public int getCurrentDirection() {
        return currentDirection;
    }

    /**
     * Sets direction the player is facing
     *
     * @param currentDirection Direction player is facing
     */
    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    /**
     * Gets active effects of player
     *
     * @return Effects active on player
     */
    public PlayerEffect getActiveEffect() {
        return activeEffect;
    }

    /**
     * Sets effects on player
     *
     * @param activeEffect Effects to be active on player
     */
    public void setActiveEffect(PlayerEffect activeEffect) {
        this.activeEffect = activeEffect;
    }
}
