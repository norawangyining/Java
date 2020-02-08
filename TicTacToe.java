
/* This is a tic-tac-toe program.
 * 
 * Developer: Yining Wang 
 * 
 */
import java.util.*;
import java.util.List; 
import java.io.*;

public class TicTacToe{
    static ArrayList<Integer> Player0Pos; //make player's positions able to used by other method inside the class.
    static ArrayList<Integer> Player1Pos;
    static int player0win =0; //players' # of winning rounds
    static int player1win =0;
    static boolean playAgain = false;
    static char[][] gameBoard1to9= {
            {'+','-','-','+','-','-','+','-','-','+'},
            {'|','1',' ','|','2',' ','|','3',' ','|'}, 
            {'+','-','-','+','-','-','+','-','-','+'},
            {'|','4',' ','|','5',' ','|','6',' ','|'},
            {'+','-','-','+','-','-','+','-','-','+'},
            {'|','7',' ','|','8',' ','|','9',' ','|'},
            {'+','-','-','+','-','-','+','-','-','+'}
        };
    static char[][] gameBoard;
    static List<Integer> correctPos = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9)); //Correct user input for moves.
    static int countRound = 0; //a variable updating the number of rounds.

    public static void main(String[] args){
        //welcome message
        System.out.println(" ☺ Welcome to Nora's Tic-Tac-Toe program! ☺ ");
        System.out.println(" ");
        System.out.println("In this game, the player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row is the winner.");
        System.out.println("You and your friends will enter numbers(1-9) as shown below, which refers to each empty sqaure.");
        printGameBoard(gameBoard1to9);
        System.out.println(" ");
        System.out.println("KEEP IN MIND:");
        System.out.println("✰ Player 0 always owns mark 'O'");
        System.out.println("✰ Player 1 always owns mark 'X'");
        System.out.println("✰ If you want to continue playing, please don't switch players.");
        System.out.println("");
        System.out.println("Now, enjoy your game!");
        System.out.println("");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("");
        
        activateGame(gameBoard);
        while(playAgain){  //re-activate the game as long as the userwants to play it agian.
            playAgain = false;
            activateGame(gameBoard);
        }
        System.out.println("");
        
        //Game Summary
        System.out.println("------------------------------------------------------------------");
        System.out.println("Check out your GAME RECORD!");
        System.out.println("");
        System.out.println("✱ Your guys has played for "+countRound+" round(s)." );
        System.out.println("✱ Player 0 wins for "+player0win+ " round(s).");
        System.out.println("✱ Player 1 wins for "+player1win+ " round(s).");
        System.out.println("");
        if (player0win > player1win){
            System.out.println("❀❀❀ Congratulations to our ultimate winner: player 0! ❀❀❀");
        }else if (player1win > player0win){
            System.out.println("❀❀❀ Congratulations to our ultimate winner: player 1! ❀❀❀");
        }else{
            System.out.println("Good news! You're all winners! ( • ̀ω•́ )✧");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
       
    }
    
    public static void printGameBoard(char[][] gameBoard){
        //a method printout the gameboard
        for(char[] row: gameBoard){
            for(char col: row){
                System.out.print(col);
            }
            System.out.println();
        }
    }
    public static void placeMove(char[][] gameBoard, int move, String user){
        char symbol = ' ';
        if (user.equals("player 0")){
            symbol = 'O';
            Player0Pos.add(move);
        }else if(user.equals("player 1")){
            symbol = 'X';
            Player1Pos.add(move);
        }
        switch(move){
           case 1:
               gameBoard[1][1] = symbol;
               break;
           case 2:
               gameBoard[1][4]=symbol;
               break;
           case 3:
               gameBoard[1][7] = symbol;
               break;
           case 4:
               gameBoard[3][1]=symbol;
               break;
           case 5:
               gameBoard[3][4] = symbol;
               break;
           case 6:
               gameBoard[3][7]=symbol;
               break;
           case 7:
               gameBoard[5][1]=symbol;
               break;
           case 8:
               gameBoard[5][4] = symbol;
               break;
           case 9:
               gameBoard[5][7]=symbol;
               break;}      
   
    }
    /*A Method That Checks If A Winner Or A draw Has Born*/
    public static String checkWinner(){
        //list winning conditions
        List topRow = Arrays.asList(1,2,3);
        List middleRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List middleCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List crossLR = Arrays.asList(1,5,9);
        List crossRL = Arrays.asList(3,5,7);
        //????Why
        List<List> winningCon = new ArrayList<List>(){
            {
                add(topRow);
                add(middleRow);
                add(bottomRow);
                add(leftCol);
                add(middleCol);
                add(rightCol);
                add(crossLR);
                add(crossRL);      
            }
        };
        for(List l: winningCon){
            if(Player0Pos.containsAll(l)){
                player0win++;
                return "✧*｡٩(ˊωˋ*)و✧* The winner of this round goes to Player 0, congrats! ";
            }else if(Player1Pos.containsAll(l)){
                player1win++;
                return "✧*｡٩(ˊωˋ*)و✧* The winner of this round goes to Player 1, congrats!";
            }else if(Player0Pos.size() +Player1Pos.size()==9){
                return "Game end, no one wins.";
            }
        }
        return "";    
    }
    
    public static char[][] createEmptyBoard(){
        char[][] emptyBoard = {
            {'+','-','-','+','-','-','+','-','-','+'},
            {'|',' ',' ','|',' ',' ','|',' ',' ','|'}, 
            {'+','-','-','+','-','-','+','-','-','+'},
            {'|',' ',' ','|',' ',' ','|',' ',' ','|'},
            {'+','-','-','+','-','-','+','-','-','+'},
            {'|',' ',' ','|',' ',' ','|',' ',' ','|'},
            {'+','-','-','+','-','-','+','-','-','+'}
        };
        return emptyBoard;
    }
    
    /*A method to check the validity of user input*/
    public static int checkUserInput(int move, Scanner scanner){
            //Catch the exceptions that the user input is not integers
            boolean bError = true;
            while(bError){
                if (scanner.hasNextInt())
                    move = scanner.nextInt();
                else {
                    System.out.println("Wrong input! Please re-enter a correct position(1-9).");
                    scanner.next();
                    continue;
                }
                bError = false;
            }
            //To catch the exceptions that user's input is not in [0,9].
            while(!correctPos.contains(move)){
                System.out.println("Oops! Your input is not from 1-9, please enter the correct move.");
                move =scanner.nextInt();
            }
            //To catch the exceptions that user may place a move that has been taken.              
            while(Player0Pos.contains(move)||Player1Pos.contains(move)){
                System.out.println("Error! Your move has been taken, please enter a correct position.");
                move =scanner.nextInt();
            }
            return move;
 
    }
    public static void activateGame(char[][] gameBoard ){
        countRound++;
        System.out.println("ROUND "+ countRound);
        //build a 2-D array to represent the game board
        Player0Pos = new ArrayList<Integer>();
        Player1Pos = new ArrayList<Integer>();
        gameBoard = createEmptyBoard();
        printGameBoard(gameBoard);
        
        //the while loop ask the users for position entil one of them reaches a success, or the game ended in a draw.
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Player 0, enter your move(1-9):");
            int P0move = 0;
            P0move = checkUserInput(P0move, scanner);
            //System.out.println(P0move);
            placeMove(gameBoard, P0move, "player 0");
            printGameBoard(gameBoard);
            String result;
            result = checkWinner();
            if (result.length()>0){
                System.out.println(result);
                //ask the user if they want to play it again.
                System.out.println("Want to play again? Enter 'y' if you want to, or enter anyother character to exit.");
                char restart = scanner.next().charAt(0); 
                if (restart=='y'){
                    playAgain=true;}
                else{
                    playAgain =false;
                    System.out.println("");
                    System.out.println("Game end.Thank you for playing.");
                }
                    
                break;
            }
      
            System.out.println("Player 1, enter your move(1-9):");
            int P1move = 0;
            P1move = checkUserInput(P1move, scanner);
            //System.out.println(P1move);
            placeMove(gameBoard, P1move, "player 1");
            printGameBoard(gameBoard);
            result = checkWinner();
            if (result.length()>0){
                System.out.println(result);
                //ask the user if they want to play it again.
                System.out.println("Would you like to play again? Enter 'y' if you want to, otherwise, enter 'n'.");
                char restart = scanner.next().charAt(0); 
                if (restart=='y'){
                    playAgain=true;}
                else{
                    playAgain =false;
                    System.out.println("Game end. Thank you for playing.");
                }
                    
                break;
            }
        }   
    }
        
    
   
}