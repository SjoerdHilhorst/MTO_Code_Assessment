public class Logger implements SimulationEventListener {
  @Override
  public void handleEvent(SimulationEvent event) {
    System.out.println(event.getName() + ": " + event.getEventDetails());
  }
}
