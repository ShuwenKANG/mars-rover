import Exceptions.DirectionToDegreeException;

public class TurnCommand extends Command{

  private enum DirectionEnum {
    L,
    R
  }
  private DirectionEnum direction;

  public TurnCommand(String s) {
    this.direction = DirectionEnum.valueOf(s);
  }

  public double toDegree() throws DirectionToDegreeException {
    switch (direction) {
      case L:
        return -90;
      case R:
        return 90;
    }
    throw new DirectionToDegreeException();
  }
}
