public class IdentificationEvent implements SimulationEvent {

  private boolean isEnemy;

  public IdentificationEvent(boolean isEnemy) {
    this.isEnemy = isEnemy;
  }

  public boolean isEnemy() {
    return isEnemy;
  }

  @Override
  public String getName() {
    return "IdentificationEvent";
  }

  @Override
  public String getEventDetails() {
    return "Identified" + (isEnemy ? " enemy" : " friend");
  }
}
