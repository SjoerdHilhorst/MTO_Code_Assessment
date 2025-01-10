public class FriendFoeIdentifier implements SimulationEventListener
{
  private EventBus eventBus;

  public FriendFoeIdentifier(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  /** 
   * A Foe has more odd entries than even entries
   */
  public boolean hasMoreOddThanEven(String target) {
    String[] entries = target.split(";");
    int even = 0;
    int odd = 0;

    for (String entry : entries) {
      String lastElement = entry.substring(entry.length() - 1);
      if (lastElement.equals("1")) {
        odd++;
      } else if (lastElement.equals("0")) {
        even++;
      }
    }

    return odd > even;
  }

  @Override
  public void handleEvent(SimulationEvent event) {
    RadarScanEvent radarEvent = (RadarScanEvent) event;
    if (hasMoreOddThanEven(radarEvent.getRadarData())) {
      eventBus.publish(new IdentificationEvent(true));
    } else {
      eventBus.publish(new IdentificationEvent(false));
    }
  }
}