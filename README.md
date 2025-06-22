To generate a map with robots and run BFS, run the main method in MainRobotEx class.
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

SIDE_LENGTH,ROBOT_COUNT and INCLUDE_DISTANCE_ON_ROBOT_SQUARE are to be determined when running the program.

To create a tree and calculate its circumference, first input its length (=number of layers in the tree). Then, for root node input number of children. Then, for every node in the Tree you will have to input number of children it has and for every child process will be repeated(Leaf node has 0 children). This will continue until all nodes have fully initialized with children. You will then recieve the circumference of the tree.

To create a graph and calcuate whether it's well-connected, you must enter number of nodes. Each node is represented with a natural number 1->number of nodes inputted. Then, you will need to input each adjacancy(For ex: if node1 connects to node2, input 1 and then 2). Since the graph is directed, Connections are in a single direction source -> destination. After the graph is ready, input -1 to finish input proccess and you will recieve an answer on whether the graph is well connected.
