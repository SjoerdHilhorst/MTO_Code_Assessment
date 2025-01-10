public class MissileLauncher implements SimulationEventListener {

  private double pk_ratio = 0.0f;
  private EventBus eventBus;
  
  public MissileLauncher(double pk_ratio, EventBus eventBus) {
    this.pk_ratio = pk_ratio;
    this.eventBus = eventBus;
  }

  @Override
  public void handleEvent(SimulationEvent event) {
    IdentificationEvent idEvent = (IdentificationEvent) event;
    if (idEvent.isEnemy()) {
      boolean hit = Math.random() < pk_ratio;
      eventBus.publish(new MissileLaunchEvent(hit));
    }
  }
}
