To generate a map with robots and run BFS, run the main method.
There are 10 constants in the Main class:

1. SIDE_LENGTH - times itself, is the size of the board(size=SIDE_LENGTH*SIDE_LENGTH).
2. CHANCE_OF_OBSTACLE - the probabillity of an obstacle being placed on each square(must be 0-1. if val >= 1, only obstacles and robots will be placed. if val <= 0, no obstacles will be placed).
3. ROBOT_COUNT - the number of robots on the board.
4. ROBOT_TOKEN - not relevant to user.
5. UNREACHABLE_TOKEN - not relevant to user.
6. MAX_DIGITS_PER_NUM - part of formatting for the result map. Should be set to Number of digits in largest distance + 1. For example: if map is large enough to generate 3 digit distances, this should be set to 4.
7. ROBOT_CHAR - The character representing a robot in the maps.
8. OBSTACLE_CHAR - The character representing obstacles and unreachable squares in the result map.
9. PATH_CHAR - The character representing a clear path in the blueprint path("Raw" map).
10. INCLUDE_DISTANCE_ON_ROBOT_SQUARE - If true, cumulative distances to squares robots are on will be included. If false, they won't be included(only RobotChar will appear on that square).
