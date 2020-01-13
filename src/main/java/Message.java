public class Message {

  Location location;
  Direction direction;

  public Location getLocation() {
    return location;
  }

  public Direction getDirection() {
    return direction;
  }

  public Message(Location location, Direction direction) {
    this.location = location;
    this.direction = direction;
  }
}
