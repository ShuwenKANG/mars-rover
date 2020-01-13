# Mars Rover

假想你在火星探索团队中负责软件开发。现在你要给登陆火星的探索小车编写控制程序，
根据地球发送的控制指令来控制火星车的行动。
火星车收到的指令(command)分为：
1. 初始化信息(init)：火星车的降落地点（x, y）和朝向（N, S, E, W）信息；
2. 移动指令(move)：火星车可以前进（M）,一次移动一格；
3. 转向指令(turn)：火星车可以左转90度（L）或右转90度（R）。

由于地球和火星之间的距离很远，指令必须批量发送，火星车执行完整批指令之后，
再回报自己所在的位置坐标和朝向。

## Tasking
```
Given
    rover
When
    send initialize command (2, 3) (N)
Then
    rover initialize location and pose accreding to command,
    and return location and pose
```
```
Given 
    rover
When 
    send move command (M)
Then
    rover move towards current direction for 1 step,
    and return location and pose 
```
```
Given
    rover
When
    send turn command (L)
Then
    rover turn left for 90 degree, and return location and pose
```
```
Given
    rover
When
    send command list [init (2, 3) (N), M, L]
Then
    rover execute command list, and return (2, 4) (W)        
```