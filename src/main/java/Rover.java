public class Rover {

  private Location location;
  private Direction direction;

  public Rover() {
    this.location = new Location(0, 0);
    this.direction = new Direction("N");
  }

  public Message send(InitCommand iCmd) {
    this.location = iCmd.getLocation();
    this.direction = iCmd.getDirection();

    Message message = new Message(this.location, this.direction);
    return message;
  }
}
