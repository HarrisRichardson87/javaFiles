package academy.learnprogramming;
import java.text.*;
public class Main {
    public static void main(String[] args) {
        System.out.println(isCatPlaying(false,25));
    }

    public static boolean isCatPlaying(boolean summer, int temperature){
        if(summer == true && temperature >= 25 && temperature <=45){
            return true;
        }
        return false;
    }



}


