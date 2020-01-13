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

    assertEquals(location, actualMsg.getLocation());
    assertEquals(direction, actualMsg.getDirection());
  }
}
