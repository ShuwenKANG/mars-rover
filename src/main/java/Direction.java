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

  public String get() {
    return direction.toString();
  }
}
