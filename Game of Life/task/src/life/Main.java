package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int universeSize = scanner.nextInt();
        int seed = scanner.nextInt();
        int generations = scanner.nextInt();

        Universe universe = new Universe(universeSize, seed);
        Generation.changeOfGenerations(universe, generations);
        universe.printField();
    }
}
