import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(path = "/snakesAndLadders")
public class StudentController
{
    @Autowired
    private GameDAO gameDAO;

    @Autowired
    private Game game;

    //Http Get method to get the student list in JSON format
    @GetMapping(path="/start", produces = "application/json")
    public String getStarted(@RequestBody String s1)
    {
        if (s1.equals("START")){
            int[][] board = new int[10][10];
            init(board);
            int[][] ladders = new int[5][2];
            initladders(ladders);

            int[][] snakes = new int[5][2];
            initsnakes(snakes);
            Game game = new Game(board,ladders,snakes);
        }
        return "READY";
    }

    //Http Post method to add the student in the student list
    @PostMapping(path= "/next", consumes = "application/json", produces = "application/json")
    public String next(@RequestBody int diceValue)
    {

       int retVal = gameDAO.setPosition(game,diceValue);


        return String.valueOf(retVal);
    }

    void init(int[][] b){
        int cnt = 1;
        for(int i=0; i < 10; i++){
            for(int j=0; j < 10; j++){
                b[i][j] = cnt;
                cnt++;
            }
        }
    }

    void initladders(int[][] l){
        for(int i=0; i < 5; i++){
            l[i][0] = i*2 + 1;
            l[i][1] = i*3 + 1;
        }
    }

    void initsnakes(int[][] s){
        for(int i=0; i < 5; i++){
            l[i][0] = i*5 + 1;
            l[i][1] = i*4 + 1;
        }
    }
}




