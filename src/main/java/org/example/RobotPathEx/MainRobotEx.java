package org.example.RobotPathEx;

import java.util.List;

public class MainRobotEx {
    final static int SIDE_LENGTH = 10; //Size of maze will be SIDE_LENGTH * SIDE_LENGTH
    final static double CHANCE_OF_OBSTACLE = 0.3; //Chance of a square being an obstacle from 0-1
    final static int ROBOT_COUNT = 5; //Number of robots
    final static int ROBOT_TOKEN = -2; //Temp marking for robot spots
    final static int UNREACHABLE_TOKEN = -1; //Temp marking for obstacle spots
    final static int MAX_DIGITS_PER_NUM = 5; //Recommended to do +1 for readable results. For ex: If largest collective distance is 100, then MDPN will be 4. Used to format map printing
    final static char ROBOT_CHAR = 'R'; //Character marking a robot
    final static char OBSTACLE_CHAR = '-'; //Character marking an obstacle
    final static char PATH_CHAR = '.'; //Character marking a path in raw map
    final static boolean INCLUDE_DISTANCE_ON_ROBOT_SQUARE = true;
    public static void main(String[] args) {
        MazeGenerator mazeGenerator = new MazeGenerator(SIDE_LENGTH,CHANCE_OF_OBSTACLE,ROBOT_COUNT, (short) ROBOT_TOKEN, (short) UNREACHABLE_TOKEN);
        mazeGenerator.generateMaze();
        short[][] rawMap = mazeGenerator.getMap();
        List<Node> robots = mazeGenerator.convertToGraph();
        BFSRunner bfsRunner = new BFSRunner(ROBOT_TOKEN,UNREACHABLE_TOKEN);
        int[][] map = bfsRunner.runBFS(robots, SIDE_LENGTH);
        MapPrinter mapPrinter = new MapPrinter(ROBOT_TOKEN,UNREACHABLE_TOKEN,MAX_DIGITS_PER_NUM,ROBOT_CHAR,OBSTACLE_CHAR,PATH_CHAR);
        System.out.println("Original map:");
        mapPrinter.printRawMap(rawMap);
        System.out.println("Collective distances after BFS:");
        mapPrinter.printSearchedMap(map,robots,INCLUDE_DISTANCE_ON_ROBOT_SQUARE);
    }
}