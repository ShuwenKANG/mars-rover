import Exceptions.DegreeToDirectionException;
import Exceptions.DirectionToDegreeException;
import Exceptions.UndefinedCommandException;
import java.util.List;

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

  public Message send(TurnCommand tCmd) throws DirectionToDegreeException, DegreeToDirectionException {
    turn(tCmd);
    return new Message(this.location, this.direction);
  }

  public Message send(List<Command> cmdList)
      throws DirectionToDegreeException, DegreeToDirectionException, UndefinedCommandException {
    for(Command cmd: cmdList) {
      if(cmd instanceof InitCommand) {
        send((InitCommand) cmd);
      }
      else if(cmd instanceof MoveCommand) {
        send((MoveCommand) cmd);
      }
      else if(cmd instanceof TurnCommand) {
        send((TurnCommand) cmd);
      }
      else {
        throw new UndefinedCommandException();
      }
    }
    return new Message(this.location, this.direction);
  }

  private void turn(TurnCommand tCmd) throws DirectionToDegreeException, DegreeToDirectionException {
    double currentTheta = direction.toDegree();

    double turnTheta = tCmd.toDegree();

    double updatedTheta = (currentTheta + turnTheta) % 360;
    this.direction.setDegree(updatedTheta);
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
