public class InitCommand extends Command{

  Location location;
  Direction direction;

  public InitCommand(Location location, Direction direction) {
    this.location = new Location(location);
    this.direction = new Direction(direction);
  }

  public Location getLocation() {
    return location;
  }

  public Direction getDirection() {
    return direction;
  }
}
