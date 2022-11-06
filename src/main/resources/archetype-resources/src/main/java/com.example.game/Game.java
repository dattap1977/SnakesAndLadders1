

public class Game{
    private int[][] board = new int[10][10];

    public int[][] getLadders() {
        return ladders;
    }

    public void setLadders(int[][] ladders) {
        this.ladders = ladders;
    }

    public int[][] getSnakes() {
        return snakes;
    }

    public void setSnakes(int[][] snakes) {
        this.snakes = snakes;
    }

    private int[][] ladders = new int[5][2]'
    private int[][] snakes = new int[5][2];    '
    public Game(int[][] board,int[][] ladders,int[][] snakes){

        this.board = board;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int position;


}