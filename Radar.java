import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Radar implements SimulationEventListener
{
  private BufferedReader reader;
  private String currentLine;
  private EventBus eventBus;

  public Radar(String filePath, EventBus eventBus) throws FileNotFoundException {
      reader = new BufferedReader(new FileReader(filePath));
      this.eventBus = eventBus;
  }

  public String getNextLine() throws IOException {
      currentLine = reader.readLine();
      return currentLine;
  }

  public void close() throws IOException {
      reader.close();
  }

  @Override
  public void handleEvent(SimulationEvent event) {
    try {
      String line = getNextLine();
      eventBus.publish(new RadarScanEvent(line));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}



