package life;

import java.util.Arrays;

public class Generation {

    private static Universe universeToChange;

    public static void changeOfGenerations(Universe universe, int generations) {
        universeToChange = universe;

        int universeSize = universeToChange.getUniverseSize();
        int cellNeighbours = 0;

        boolean[][] currentField = universe.getField();
        boolean[][] newField = new boolean[universeSize][universeSize];

        for (int i = 0; i < generations; i++) { //iterating generations

            for (int y = 0; y < universeSize; y++) {                               //iterating cells
                for (int x = 0; x < universeSize; x++) {                           //iterating cells

                    //counting neighbours of current cell
                    for (int j = y - 1; j <= y + 1; j++) {
                        for (int k = x - 1; k <= x + 1; k++) {
                            if (j == y && k == x) {
                                continue;
                            }   else if (currentField[getValidPosition(j)][getValidPosition(k)]) {
                                cellNeighbours++;
                            }
                        }
                    }

                    //set next generation cell
                    newField[y][x] = currentField[y][x] ? cellNeighbours >= 2 && cellNeighbours <= 3 :
                            cellNeighbours == 3;

                    cellNeighbours = 0;
                }
            }

            universe.setField(newField);

            for (boolean[] b: newField) {
                Arrays.fill(b, false);
            }
        }
    }

    private static int getValidPosition(int i) {
        return i < 0 ? universeToChange.getUniverseSize() - 1 : i == universeToChange.getUniverseSize() ? 0 : i;
    }
}
