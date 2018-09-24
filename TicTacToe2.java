import java.util.*;
public class TicTacToe2
{

   //beast
    public static void main(String[] args)
    {Scanner sc = new Scanner(System.in);
        String[][] currentBoard = new String[3][3];
        for (int r =0; r<3; r++)
        {for (int c =0; c<3; c++)
            {currentBoard[r][c] = "";
            }
        }
        String winner = new String("No one");
        println("Hello! Let's play a game of Tic Tac Toe. You'll be \"O's\" and I'll be \"X's\". ");
        println("This is how the board is numbered:");
        println(" 0 | 1 | 2 ");
        println("-----------");
        println(" 3 | 4 | 5 ");
        println("-----------");
        println(" 6 | 7 | 8 ");
        println("Let's see who goes first by flipping a coin. Head or Tails?");

        if(coinToss(sc.nextLine()).equals("player"))
        {println("You are going first!");
            while (winner.equals("No one"))
            {
                
                //player turn
               

                println("Where would you like to place your \"O\"?");
                currentBoard = player(currentBoard, sc.nextInt());
                printBoard(currentBoard);
                winner = checkWinner(currentBoard, winner);
                if (!winner.equals("No one"))
                {break;
                }
                

                
                

                
                //computer turn
                

                println("computer will now make its turn");
                currentBoard = computer(currentBoard, (int)(9*Math.random()));
                printBoard(currentBoard);
                winner = checkWinner(currentBoard, winner);
                if (!winner.equals("No one"))
                {break;
                }
                
                
                
                

            }
            println("And the winner is " +winner);
        }
        else 
        {println("Computer goes first");
            while (winner.equals("No one"))
            { 
                
                //computer turn
               
                println("computer will now make its turn");
                currentBoard = computer(currentBoard, (int)(9*Math.random()));
                printBoard(currentBoard);
                winner = checkWinner(currentBoard, winner);
                if (!winner.equals("No one"))
                {break;
                }
                

                //player turn
               

                println("Where would you like to place your \"O\"?");
                currentBoard = player(currentBoard, sc.nextInt());
                printBoard(currentBoard);
                winner = checkWinner(currentBoard, winner);
                if(!winner.equals("No one"))
                {break;
                }
                

            }
            println("And the winner is " +winner);
        }

    }

    public static void printBoard(String[][] currentBoard)
    { for(int i =0; i<currentBoard.length; i++)
        {for(int b = 0; b<currentBoard[i].length; b++)
            {if (b<2)
                {System.out.print( currentBoard[i][b] + " | ");
                }
                else
                {System.out.print( currentBoard[i][b]);
                }
            }
            println("");
            if (i<2)
                println("---------");
        }
    }

    public static String checkWinner(String[][] currentBoard, String winner)
    {   
         if (!currentBoard[0][0].equals("") && !currentBoard[0][1].equals("") && !currentBoard[0][2].equals("") && !currentBoard[1][0].equals("") && !currentBoard[1][1].equals("") && !currentBoard[1][2].equals("") && !currentBoard[2][0].equals("") && !currentBoard[2][1].equals("") && !currentBoard[2][2].equals(""))
         {winner = "no one! It's a tie";
         }
        for (int i =0; i<3; i++)
        {if (currentBoard[i][0].equals("X") && currentBoard[i][1].equals("X") && currentBoard[i][2].equals("X"))
            {winner = "Computer!";
                return winner;
            }
           else if (currentBoard[0][i].equals("X") && currentBoard[1][i].equals("X") && currentBoard[2][i].equals("X"))
            {winner = "Computer!";
                return winner;
            }
           else if (currentBoard[0][0].equals("X") && currentBoard[1][1].equals("X") && currentBoard[2][2].equals("X")) 
            {winner = "Computer!";
                return winner;
            }
           else if (currentBoard[2][0].equals("X") && currentBoard[1][1].equals("X") && currentBoard[0][2].equals("X")) 
            {winner = "Computer!";
                return winner;
            }
           else if (currentBoard[i][0].equals("O") && currentBoard[i][1].equals("O") && currentBoard[i][2].equals("O")) 
            {winner = "you!";
                return winner;
            }
           else if (currentBoard[0][i].equals("O") && currentBoard[1][i].equals("O") && currentBoard[2][i].equals("O")) 
            {winner = "you!";
                return winner;
            }
           else if (currentBoard[0][0].equals("O") && currentBoard[1][1].equals("O") && currentBoard[2][2].equals("O")) 
            {winner = "you!";
                return winner;
            }
           else if (currentBoard[2][0].equals("O") && currentBoard[1][1].equals("O") && currentBoard[0][2].equals("O")) 
            {winner = "you!";
                return winner;
            }
            
        }

        
        return winner;

    }

    public static String[][] player(String[][] currentBoard, int a)

    //have the user input an int, then change the int to a 2D array input
    {Scanner sc = new Scanner(System.in);
        int pNum = 0;
        for (int i = 0; i<currentBoard.length; i++)
        {for (int b = 0; b<currentBoard[1].length; b++)
            {
                if (pNum==a)
                {if(!currentBoard[i][b].equals(""))
                    {println("Hey doofus, that spot is already taken. What other spot do you want?");
                        player(currentBoard, sc.nextInt());

                    }
                    else
                    { currentBoard[i][b]= "O";
                    }
                }
                pNum++;
            }
        }

        return currentBoard;

    }

    public static String[][] computer(String[][] currentBoard, int c)
    {
        int cNum =0;
        for (int i= 0; i<currentBoard.length; i++)
        {for (int b=0; b<currentBoard[1].length; b++)

            {
                if(cNum == c)
                { if(!currentBoard[i][b].equals(""))
                    {computer(currentBoard, (int)(9*Math.random()));
                    }
                    else 
                    {
                        currentBoard[i][b] = "X";
                    }
                }
                cNum++;
            }
        }
        return currentBoard;
    }

    public static void println(String sent)
    {
        System.out.println(sent);
    }

    public static String coinToss(String user )
    { String first = new String();
        double x = Math.random();
        if (user.equals("head")||user.equals("heads")||user.equals("Head")||user.equals("Heads"))
        {// player will go first if x is greater than .5
            if(x>.5)
            {first = "player";
            }
            else
            {first = "computer";
            }
        }
        else
        {//player will go first if x is less than .5
            if (x<.5)
            {first = "player";
            }
            else
            {first = "computer";
            }
        }

        return first;

    }
}