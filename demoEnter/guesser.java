package demoEnter;

import java.util.Scanner;

class Guesser{
    int guessNum;

    public int getguessNumber(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Guesser Kindly guess the number");
        guessNum =  sc.nextInt();
        return guessNum;
    }
}


class Player {
    int playerNum;

    public int getPlayerNum() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Player Kindly guess the number");
        playerNum = sc.nextInt();
        return playerNum;
    }
}

class Umpire {
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    public void collectNumFromGuesser(){
        Guesser g = new Guesser();
        numFromGuesser = g.getguessNumber();


    }

    public void collectNumFromPlayer(){
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();

        numFromPlayer1 = p1.getPlayerNum();
        numFromPlayer2 = p2.getPlayerNum();
        numFromPlayer3 = p3.getPlayerNum();
    }

    public void compare (){
        if(numFromGuesser == numFromPlayer1){
            System.out.println("Player 1 won");
        } else if (numFromGuesser == numFromPlayer2) {
            System.out.println("Player 2 won");
        }else if (numFromGuesser == numFromPlayer3) {
            System.out.println("Player 3 won");
        }else{
            System.out.println("No one won the game.");
        }
    }
}
public class guesser {

    public static void main(String[] args) {
        Umpire u = new Umpire();
        u.collectNumFromGuesser();
        u.collectNumFromPlayer();
        u.compare();
    }
}
