import Exceptions.DegreeToDirectionException;
import Exceptions.DirectionToDegreeException;

public class Direction {

  private enum DirectionEnum {
    N,
    E,
    W,
    S;


  }
  private DirectionEnum direction;
  public Direction(String n) {
    direction = DirectionEnum.valueOf(n);
  }
  public Direction(Direction direction) {
    this.direction = direction.direction;
  }

  public String getDirectionAsString() {
    return direction.toString();
  }

  public int toCoordinateX() {
    switch (direction) {
      case E:
        return 1;
      case W:
        return -1;
      default:
        return 0;
    }
  }

  public int toCoordinateY() {
    switch (direction) {
      case N:
        return 1;
      case S:
        return -1;
      default:
        return 0;
    }
  }

  public double toDegree() throws DirectionToDegreeException {
    switch (direction) {
      case N:
        return 0;
      case S:
        return 180;
      case W:
        return -90;
      case E:
        return 90;
    }
    throw new DirectionToDegreeException();
  }

  public void setDegree(double theta) throws DegreeToDirectionException {
    switch ((int) theta) {
      case 0:
        this.direction = DirectionEnum.N;
        break;
      case 90:
      case -270:
        this.direction = DirectionEnum.E;
        break;
      case 180:
      case -180:
        this.direction = DirectionEnum.S;
        break;
      case 270:
      case -90:
        this.direction = DirectionEnum.W;
        break;
      default:
        throw new DegreeToDirectionException();
    }
  }
}
