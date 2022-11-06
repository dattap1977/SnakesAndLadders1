import org.springframework.stereotype.Repository;

import com.example.game.Game;

@Repository
public class GameDAO
{


    //In below static block, we are adding three students


    //method to return the student list
    public StudentPOJO getAllStudents()
    {
        return list;
    }

    //method to add the student in the list
    public int setPosition(Game game,int diceVal) {
        game.setPosition(game.getPosition() + diceVal);
        for(int i=0; i < game.getLadders().length; i++) {
            if (game.getPosition() == game.getLadders()[i][0]){
                game.setPosition(game.getLadders()[i][1]);
            }
        }

        for(int i=0; i < game.getSnakes().length; i++) {
            if (game.getPosition() == game.getSnakes()[i][1]){
                game.setPosition(game.getSnakes()[i][0]);
            }
        }
    }
}
