package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MapPrinter {
    private int robotToken;
    private int unreachableToken;
    private int maxDigitsPerNumber;
    private char robotChar;
    private char obstacleChar;
    private char pathChar;
    public MapPrinter(int robotToken,
                      int unreachableToken,
                      int maxDigitsPerNumber,
                      char robotChar,
                      char obstacleChar,
                      char pathChar) {
        this.robotChar = robotChar;
        this.obstacleChar = obstacleChar;
        this.pathChar = pathChar;
        if (maxDigitsPerNumber > 0){
            this.maxDigitsPerNumber = maxDigitsPerNumber;
        }
        else {
            this.maxDigitsPerNumber = 1;
        }
        if (robotToken == unreachableToken) {
            System.out.println("Robot token and unreachableToken must be different. Initializing robot = -2, unreachable = -1");
            this.robotToken = -2;
            this.unreachableToken = -1;
            return;
        }
        if (robotToken == 0){
            System.out.println("Robot token can't be 0. Initialized to -2");
            this.robotToken = -2;
        }
        else {
            this.robotToken = robotToken;
        }
        this.unreachableToken = unreachableToken;
    }

    public void setMaxDigitsPerNumber(int maxDigitsPerNumber) {
        this.maxDigitsPerNumber = maxDigitsPerNumber;
    }

    public void setRobotToken(int robotToken) {
        if (robotToken == 0){
            System.out.println("Robot token can't be 0. Initialized to -2");
            this.robotToken = -2;
        }
        else if (robotToken == unreachableToken){
            System.out.println("Robot token and unreachableToken must be different");
        }
        else {
            this.robotToken = robotToken;
        }
    }

    public void setUnreachableToken(int unreachableToken) {
        if (robotToken == unreachableToken){
            System.out.println("Robot token and unreachableToken must be different");
        }
        else {
            this.unreachableToken = unreachableToken;
        }
    }

    public void printSearchedMap(int[][] map, List<Node> robots,boolean includeRobotDistance){
        HashMap<Integer, HashSet<Integer>> robotCords = new HashMap<>();
        for (Node robot: robots){
            if (!robotCords.containsKey(robot.x)){
                robotCords.put(robot.x, new HashSet<>());
            }
            robotCords.get(robot.x).add(robot.y);
        }
        for (int x = 0; x < map.length; x++){
            for (int y = 0; y < map[x].length; y++){
                int number = map[x][y];
                int copy = number;
                if (number == unreachableToken){
                    copy = 1;
                }
                if (robotCords.getOrDefault(x,new HashSet<>()).contains(y)){
                    copy *= 10;
                    if (!includeRobotDistance){
                        copy = 1;
                    }
                }
                StringBuilder toPrint = new StringBuilder();
                for (int i = 1; i < maxDigitsPerNumber - Math.log10(copy); i++){
                    toPrint.append(" ");
                }
                if (robotCords.getOrDefault(x,new HashSet<>()).contains(y)){
                    if (includeRobotDistance){
                        toPrint.append(number);
                    }
                    toPrint.append(robotChar);
                }
                else if (number == unreachableToken){
                    toPrint.append(obstacleChar);
                }
                else {
                    toPrint.append(number);
                }
                System.out.print(toPrint);
            }
            System.out.println();
        }
    }
    public void printRawMap(short[][] map){
        for (int x = 0; x < map.length; x++){
            for (int y = 0; y < map[0].length; y++){
                if (map[x][y] == unreachableToken){
                    System.out.print(obstacleChar + " ");
                }
                else if (map[x][y] == robotToken){
                    System.out.print(robotChar + " ");
                }
                else {
                    System.out.print(pathChar + " ");
                }
            }
            System.out.println();
        }
    }

}
