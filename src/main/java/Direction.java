public class Direction {

  private enum directions {
    N,
    E,
    W,
    S;

  }
  private directions direction;
  public Direction(String n) {
    direction = directions.valueOf(n);
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
}
