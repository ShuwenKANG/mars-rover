import Exceptions.DegreeToDirectionException;
import Exceptions.DirectionToDegreeException;
import Exceptions.UndefinedCommandException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

  @Test
  public void should_return_message_contains_location_and_pose_when_send_init_command() {
    Rover rover = new Rover();

    Location location = new Location(2, 3);
    Direction direction = new Direction("N");
    InitCommand iCmd = new InitCommand(location, direction);

    Message actualMsg = rover.send(iCmd);

    assertEquals(2, actualMsg.getLocation().getX(), 0.01);
    assertEquals(3, actualMsg.getLocation().getY(), 0.01);
    assertEquals("N", actualMsg.getDirection().getDirectionAsString());
  }

  @Test
  public void should_return_message_contains_moving_result_when_send_move_command() throws DirectionToDegreeException {
    Rover rover = new Rover();
    InitCommand iCmd = new InitCommand(new Location(2, 3), new Direction("N"));
    rover.send(iCmd);

    MoveCommand mCmd = new MoveCommand();
    Message actualMsg = rover.send(mCmd);

    assertEquals(2, actualMsg.getLocation().getX(), 0.01);
    assertEquals(4, actualMsg.getLocation().getY(), 0.01);
    assertEquals("N", actualMsg.getDirection().getDirectionAsString());
  }

  @Test
  public void should_return_message_contains_turning_result_when_send_turn_command()
      throws DirectionToDegreeException, DegreeToDirectionException {
    Rover rover = new Rover();
    InitCommand iCmd = new InitCommand(new Location(2, 3), new Direction("N"));
    rover.send(iCmd);

    TurnCommand tCmd = new TurnCommand("L");
    Message actualMsg = rover.send(tCmd);

    assertEquals(2, actualMsg.getLocation().getX(), 0.01);
    assertEquals(3, actualMsg.getLocation().getY(), 0.01);
    assertEquals("W", actualMsg.getDirection().getDirectionAsString());
  }

  @Test
  public void should_return_message_contains_execution_result_when_send_command_list()
      throws DirectionToDegreeException, DegreeToDirectionException, UndefinedCommandException {
    Rover rover = new Rover();
    InitCommand iCmd = new InitCommand(new Location(2, 3), new Direction("N"));
    MoveCommand mCmd = new MoveCommand();
    TurnCommand tCmd = new TurnCommand("L");

    List<Command> cmdList = new ArrayList<>();
    cmdList.add(iCmd);
    cmdList.add(mCmd);
    cmdList.add(tCmd);

    Message actualMsg = rover.send(cmdList);

    assertEquals(2, actualMsg.getLocation().getX(), 0.01);
    assertEquals(4, actualMsg.getLocation().getY(), 0.01);
    assertEquals("W", actualMsg.getDirection().getDirectionAsString());
  }
}
