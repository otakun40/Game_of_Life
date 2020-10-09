package life;

import java.util.Random;

public class Universe{
    private boolean[][] field;
    private final int universeSize;
    private final int seed;

    public Universe(int n, int seed) {
        this.universeSize = n;
        this.seed = seed;
        initStartedField();
    }

    private void initStartedField() {
        Random random = new Random(seed);
        field = new boolean[universeSize][universeSize];

        for (int y = 0; y < universeSize; y++) {
            for (int x = 0; x < universeSize; x++) {
                field[y][x] = random.nextBoolean();
            }
        }
    }

    public void printField() {
        for (boolean[] y : field) {
            for (boolean x : y) {
                System.out.print(x ? "O" : " ");
            }
            System.out.println();
        }
    }

    public boolean[][] getField() {
        return field;
    }

    public int getUniverseSize() {
        return universeSize;
    }

    public void setField(boolean[][] field) {
        for (int i = 0; i < universeSize; i++) {
            System.arraycopy(field[i], 0, this.field[i], 0, universeSize);
        }
    }
}
