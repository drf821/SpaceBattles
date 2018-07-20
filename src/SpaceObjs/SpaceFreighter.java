package SpaceObjs;



public class SpaceFreighter extends EnemySpaceShip  {

	public SpaceFreighter(int x, int y, int d, int f) {
		super(x, y, d, f, 15);
	}
	@Override
    public void actions() {
        super.actions();
        takeAction();
    }
}
