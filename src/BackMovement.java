public class BackMovement extends Effect.PlayerEffect {

    protected BackMovement(boolean backMovement) {
        super(backMovement);
    }
    public boolean isBackMovement() {
        return this.backMovement;
    }

    public void setBackMovement(boolean backMovement) {
        this.backMovement = backMovement;
        System.out.println("Back movement is in effect");
    }

}
