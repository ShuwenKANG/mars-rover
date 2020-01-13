public class Rover {

  private Location location;
  private Direction direction;
  private double stepLength = 1;

  public Rover() {
    this.location = new Location(0, 0);
    this.direction = new Direction("N");
  }

  public Message send(InitCommand iCmd) {
    this.location = iCmd.getLocation();
    this.direction = iCmd.getDirection();

    return new Message(this.location, this.direction);
  }

  public Message send(MoveCommand mCmd) {
    move();
    return new Message(this.location, this.direction);
  }

  private void move() {
    double currentX = location.getX();
    double currentY = location.getY();

    double updatedX = currentX + direction.toCoordinateX() * stepLength;
    double updatedY = currentY + direction.toCoordinateY() * stepLength;

    location.setX(updatedX);
    location.setY(updatedY);
  }
}
