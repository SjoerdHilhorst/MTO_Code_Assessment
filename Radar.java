import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Radar implements Scanner
{
  private BufferedReader reader;
  private String currentLine;

  public Radar(String filePath) throws FileNotFoundException {
      reader = new BufferedReader(new FileReader(filePath));
  }

  public String getNextLine() throws IOException {
      currentLine = reader.readLine();
      return currentLine;
  }

  public void close() throws IOException {
      reader.close();
  }

  @Override
  public String scan() {
    try {
      String line = getNextLine();
      System.out.println("Radar: Scanning...");
      return line;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}



