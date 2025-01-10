public class Sleeper implements SimulationEventListener {
  @Override
  public void handleEvent(SimulationEvent event) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
