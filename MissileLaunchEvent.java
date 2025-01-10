public class MissileLaunchEvent implements SimulationEvent {
  private boolean hit;

  public MissileLaunchEvent(boolean hit) {
    this.hit = hit;
  }

  public boolean isHit() {
    return hit;
  }

  @Override
  public String getName() {
    return "MissileLaunchEvent";
  }

  @Override
  public String getEventDetails() {
    return (hit ? "Hit" : "Miss");
  }
}
