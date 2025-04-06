package ca.mcmaster.se2aa4.mazerunner;

/**
 * Strategy interface for maze-solving algorithms.
 * Implementing classes define how to solve a maze and return a path.
 * 
 * Author: Midhousha Anura
 * Assignment: 2AA4 Assignment 3
 * Date: March 31, 2025
 */
public interface MazeSolvingStrategy {
    /**
     * Solves the maze and returns a string representing the path taken.
     *
     * @param maze The maze to solve.
     * @return A string of moves (e.g., "RFLFRF") representing the solution path.
     */
    String solve(Maze maze);
}
