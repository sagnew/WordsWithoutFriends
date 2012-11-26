import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Integer;

public class Executable {

	public static void main(String[] args) throws FileNotFoundException, InputMismatchException 
	{
		
		                                                                                                     
                                                                                                     
System.out.println(" __      __                 __      ____                                  ");
System.out.println("/\\ \\  __/\\ \\               /\\ \\    /\\  _`\\                                ");
System.out.println("\\ \\ \\/\\ \\ \\ \\   ___   _ __ \\_\\ \\   \\ \\ \\ \\_\\    __      ___ ___      __   ");
System.out.println(" \\ \\ \\ \\ \\ \\ \\ / __`\\/\\`'__\\'_` \\   \\ \\ \\ _   /'__`\\  /' __` __`\\  /'__`\\ ");
System.out.println("  \\ \\ \\_/ \\_\\ \\\\ \\ \\ \\ \\ \\/\\ \\ \\ \\   \\ \\ \\/, \\\\ \\ \\.\\_/\\ \\/\\ \\/\\ \\/\\  __/ ");
System.out.println("   \\ `\\___ ___/ \\____/\\ \\_\\ \\___,_\\   \\ \\____/ \\__/.\\_\\ \\_\\ \\_\\ \\_\\ \\____\\");
System.out.println("    '\\/__//__/ \\/___/  \\/_/\\/__,_ /    \\/___/ \\/__/\\/_/\\/_/\\/_/\\/_/\\/____/");
System.out.println("");                                                                          
		
		Dictionary dict = new Dictionary();
		Scrabble currentGame = new Scrabble();
		Scanner scan;
		int tile = 1, row = 0, col = 0, firstTurn = 0, dir = 0;
		String colChar = "", tile1 = "";
			
		ArrayList<String> dictWords = null;
		dictWords = dict.getWords();
		
		int counter = 0, firstCol = 0, firstRow = 0, lastCol = 0, lastRow = 0; 
		boolean finisher = false, continuer = false;
		
		while(true)
		{
		   System.out.println("Your score: " + currentGame.getYourScore() + " \nOpponent's score: " + currentGame.getEnemyScore());
		   System.out.println(currentGame.getRack());
		   counter = 0;
		   currentGame.refillRacks();
		   currentGame.printBoard();
		   //System.out.println("storeBoard() called 26");
		   currentGame.storeBoard();
		   System.out.println(currentGame.getRack().get(0) + " " + currentGame.getTempRack().get(0));
		   while(true)
		   {/*   */
			 System.out.println(currentGame.getRack().get(0) + " " + currentGame.getTempRack().get(0));
		     System.out.println("Which tile would you like to place on the board? Enter 0 to finish.");
			 System.out.println("Enter the NUMBER cooresponding to the tile!");
			 
		     for(int count=0;count<currentGame.getTempRack().size();count++)
			  {
			    if(currentGame.getTempRack().get(count)!='!')
				   System.out.println((count+1) + ":" + currentGame.getTempRack().get(count));
			  }
			  
			  if(counter==0&&firstTurn!=0)
			    System.out.println("8: discard your rack for a new rack(lose a turn)");
			  
			  System.out.println("\nNote to user: When you choose the first tile, you will be able to place it at a particular spot on the board.");
			  System.out.println("All subsequent tiles that you place after the first tile will be placed automatically according to the direction you choose.");
			  
			  try
			  {
			  scan = new Scanner(System.in);
			  tile = scan.nextInt();
			  }
			  catch(InputMismatchException e)
			  {
			  
			   do
			   {
			   System.out.println("Invalid input! Please enter an integer!");
			   scan = new Scanner(System.in);
			   tile1 = scan.next();
			   }while(currentGame.isNumeric(tile1)==false);
			  
			   tile = Integer.parseInt( tile1 );
			  
			  }
			  
			  if(tile==8&&counter==0&&firstTurn!=0)
			  {   
			  currentGame.throwAwayPlayerRack();
			  continuer = true;
			  break;
			  
			  }
			  if(counter==0)  
			  {/*   */
			   
			   if(tile!=0)
			   {
			     //System.out.println(currentGame.getRack().get(0) + " " + currentGame.getTempRack().get(0));
			     if(firstTurn!=0)
			     {
				  
			      System.out.println("Where would you like to place this tile?");
			      scan = new Scanner(System.in);
			      colChar = scan.next();
			      colChar = colChar.toUpperCase();
			      col = currentGame.charToNum(colChar.charAt(0));
				  try
				  {
				  scan = new Scanner(System.in);
			      row = scan.nextInt();
				  }
				  catch(InputMismatchException e)
				  {
			  
				  do
				  {
				  System.out.println("Invalid input! Please enter an integer!");
				  scan = new Scanner(System.in);
				  tile1 = scan.next();
				  }while(currentGame.isNumeric(tile1)==false);
			  
				  row = Integer.parseInt( tile1 );
			  
				  }
				  
				  
				  currentGame.placeTile(tile-1, row, col, dir);
				  System.out.println("Would you like to go horizontal or vertical?");
				  System.out.println("0: horizontal 1: vertical");
				  
				  try
				  {
				  scan = new Scanner(System.in);
				  dir = scan.nextInt();
				  }
				  catch(InputMismatchException e)
				  {
			  
				  do
				  {
				  System.out.println("Invalid input! Please enter an integer!");
				  scan = new Scanner(System.in);
				  tile1 = scan.next();
				  }while(currentGame.isNumeric(tile1)==false);
			  
				  dir = Integer.parseInt( tile1 );
			  
				  }
				  
				  firstCol = col;
				  firstRow = row;
				  
			     }
			     else if(firstTurn==0)
				   	 {/*   */
						row = 7;
						col = 7;
						firstCol = 7;
						firstRow = 7;
					    currentGame.placeTile(tile-1, row, col, 0);
						System.out.println("Would you like to go horizontal or vertical?");
						System.out.println("0: horizontal 1: vertical");
						try
						{
						scan = new Scanner(System.in);
						dir = scan.nextInt();
						}
						catch(InputMismatchException e)
						{
			  
						do
						{
						System.out.println("Invalid input! Please enter an integer!");
						scan = new Scanner(System.in);
						tile1 = scan.next();
						}while(currentGame.isNumeric(tile1)==false);
			  
						dir = Integer.parseInt( tile1 );
			  
						}
					 }
					 
			   //currentGame.printBoard();
			  
			   }
			   else if(tile==0)
			   {/*   */
			      currentGame.refillRacks();
				  lastCol = col;
				  lastRow = row;
				  //System.out.println("getEnteredWord() called 89");
				  
				  if(dir==0)
				     System.out.println(currentGame.getEnteredWord(firstRow, firstCol, dir));
				  else if(dir==1)
				      System.out.println(currentGame.getEnteredWord(firstCol, firstRow, dir));
				  break;
				  
			   }
			   
			  }
			  else if(counter!=0)
			  {
			     if(tile!=0)
				 {
				    System.out.println(currentGame.getRack().get(0) + " " + currentGame.getTempRack().get(0));
					if(dir==0)
			           currentGame.placeTile(tile-1,row,col+counter, dir);
					else if(dir==1)
					        currentGame.placeTile(tile-1,row-counter,col, dir);
					
				 }
				 else if(tile==0)
				 {
				 //System.out.println("getEnteredWord() called 112");
				 String entered = "";
				 
				  if(dir==0)
				      entered = currentGame.getEnteredWord(firstCol, firstRow, dir);
				  else if(dir==1)
				      entered = currentGame.getEnteredWord(firstRow, firstCol, dir);
					  
				  if(counter==1)
					counter--;
					  
				  if(firstTurn==0)
					counter--;
					
				  if(currentGame.checkBoard()==false||currentGame.checkLength(entered, counter)==false)
				  {/*   */
				    System.out.println(currentGame.getRack().get(0) + " " + currentGame.getTempRack().get(0));
					System.out.println();
				    System.out.println("The tiles you have placed are invalid! Please try again.");
					System.out.println();
				    counter = 0;
					//System.out.println("storeBoard() called 112");
					currentGame.storeBoard();
					continue;
				  }
				  else 
				  {
				     if(firstTurn==0)
					    firstTurn = 1;
				     currentGame.fixBoard();
					 currentGame.addScore(0, entered);
				  }
				  
			      currentGame.refillRacks();
				  lastCol = col;
				  lastRow = row;
				  break;
				 }
				 
			  }
			 
			  counter++;
			  
		   }
		   
		   //currentGame.getAvailableLetters();
		   currentGame.fixBoard2();
		   currentGame.enemyTurn(0);
		   
		   tile = 1;
		   currentGame.lettersLeft();
		   if(currentGame.getLetters().size()<10)
		   {   
		   System.out.println("Game is over!");
		   finisher = true;
		   break;
		   }
		   
		   if(continuer)
		      continue;
		   
		   if(finisher)
		     break;
		   
		}
		
		currentGame.endGame();
		
	}

}