public class MissileLauncher implements Firer {

  private double pk_ratio = 0.0f;
  
  public MissileLauncher(double pk_ratio) {
    this.pk_ratio = pk_ratio;
  }

  @Override
  public boolean fire() {
    boolean hit = Math.random() < pk_ratio;
    System.out.println("MissileLauncher: Missile " + (hit ? "hit" : "missed"));
    return hit;
  }
}
