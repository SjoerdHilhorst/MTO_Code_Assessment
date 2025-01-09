public class FriendFoeIdentifier implements Identifier
{
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
  public boolean identify(String target) {
    if (hasMoreOddThanEven(target)) {
      System.out.println("FriendFoeIdentifier: Target identified as Foe");
      return true;
    } else {
      System.out.println("FriendFoeIdentifier: Target identified as Friend");
      return false;
    }
  }
}