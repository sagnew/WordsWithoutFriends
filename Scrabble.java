import java.util.ArrayList;
import java.util.Random;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;

/**
* Scrabble.java A class designed to be used by a client program together to play a game very similar to the popular word game "Scrabble." 
It is a 2 player game between a human player and the computer player to score points off of words by placing tiles that represent letters on the board.
* @author Sam Agnew
*@version 1.0 
*/

public class Scrabble
{

	public Scrabble()
	{
		initialize();
	}
	
	/**
	*Initializes the instance variables. This is called in the Constructor, and is not meant to be implemented by client programs.
	*/
	public void initialize()
	{
		
		for(int x = 0; x<15; x++)
		{
		 
			for(int y = 0; y<15; y++)
			{
			   board[x][y] = ' ';
			   boardNums[x][y] = 1;
			}
		 
		}
		
		board[7][7] = '*';
		
		//This adds all of the letter tiles in Scrabble to the collection of letters
		for(int count = 0; count < 9; count++)
			letters.add('a');
		for(int count = 9; count<11; count++)
		    letters.add('b');
		for(int count = 11; count<13; count++)
		    letters.add('c');
		for(int count = 13; count<17; count++)
		    letters.add('d');
		for(int count = 17; count<29; count++)
		    letters.add('e');
		for(int count = 29; count<31; count++)
		    letters.add('f');
		for(int count = 31; count<34; count++)
		    letters.add('g');
		for(int count = 34; count<36; count++)
		    letters.add('h');
		for(int count = 36; count<45; count++)
		    letters.add('i');
		letters.add('j');
		letters.add('k');
		for(int count = 47; count<51; count++)
		    letters.add('l');
		for(int count = 51; count<53; count++)
		    letters.add('m');
		for(int count = 53; count<59; count++)
		    letters.add('n');
		for(int count = 59; count<67; count++)
		    letters.add('o');
		for(int count = 67; count<69; count++)
		    letters.add('p');
		letters.add('q');
		for(int count = 70; count<76; count++)
		    letters.add('r');
		for(int count = 76; count<80; count++)
		    letters.add('s');
		for(int count = 80; count<86; count++)
		    letters.add('t');
		for(int count = 86; count<90; count++)
		    letters.add('u');
		for(int count = 90; count<92; count++)
		    letters.add('v');
		for(int count = 92; count<94; count++)
		    letters.add('w');
		letters.add('x');
		for(int count = 95; count<97; count++)
		    letters.add('y');
		letters.add('z');
		for(int count = 98; count<100; count++)
		    letters.add(' ');
			
		   for(int y = 0; y<7; y++)
		   {
		   int rand = getRand(letters.size());
		   yourRack.add(letters.get(rand));
		   letters.remove(rand);
		   //System.out.println(yourRack.get(y));
		   }
		   
		   for(int z = 0; z<7; z++)
		   {
		   enemyRack.add(letters.get(getRand(letters.size())));
		   letters.remove(z);
		   //System.out.println(enemyRack.get(z));
		   }
		   
		   for(int count = 0; count<100; count++)
		      tempLetters.add('!');
			  
		   for(int count = 0; count<7; count++)
		      tempRack.add('!');
			  
		   for(int count = 0; count<7; count++)
		      tempEnemyRack.add('!');
		   
	}
	
	/**
	*Prints out the board, this is called every turn in the client program, and prints the updated board. 
	*/
	public void printBoard()
	{
	 
	int x, y, z, w;  
    
	System.out.print("\n     A     B     C     D     E     F     G     H     I     J     K     L     M     N     O   \n");
	System.out.print("   _________________________________________________________________________________________ \n");
	System.out.print("  |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |\n");
   
		for(x=14; x>=0; x--)
		{
		if(x<10)
			System.out.print(x + " ");
		else
			System.out.print(x);
			
			for(y = 0; y<15; y++)
			{
			System.out.print("|  ");   
			System.out.print(board[x][y]);
			System.out.print("  ");
			}   
		
		System.out.print("|\n");
        System.out.print("  |_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|");
		if(x!=0)
          System.out.print("\n  |     |     |     |     |     |     |     |     |     |     |     |     |     |     |     |\n");
       
		if(x==0)
		{
         System.out.print("\n   ");    
		}
		
     }//end loop 
	 
	}//end printBoard()
	
	
	/**
	*Finds out how many points a given word is worth
	*@param word The word that is going to be scored. 
	*@param bonus boolean variable to determine if bonus points will be included.
	*@return The number of points gained by using the entered word
	*/
	public int getScore(String word, boolean bonus)
	{
	
	   int score = 0;
	   int num = 1, num2 = 1;
	   
	   for(int x = 0; x < word.length(); x++)
	   {
	     
		if(bonus)
	    {
		 if(getRand(100)%4==0&&getRand(100)%5==0)
	       num = 2;
		 else if(getRand(100)%6==0&&getRand(100)%4==0&&getRand(100)%5==0)
	       num = 3;
	     else 
		   num = 1;
		 
		 if(num!=1)
		   System.out.print("Bonus points for the letter " + word.charAt(x) + " ! \7");
		 }
		 else
		    num = 1;
			
	      switch(word.charAt(x))
		  {
		     
			 case 'a': score += 1*num; break;
			 
			 case 'b': score += 3*num; break;
			 
			 case 'c': score += 3*num; break;
			 
			 case 'd': score += 2*num; break;
			 
			 case 'e': score += 1*num; break;
			 
			 case 'f': score += 4*num; break;
			 
			 case 'g': score += 2*num; break;
			 
			 case 'h': score += 4*num; break;
			 
			 case 'i': score += 1*num; break;
			 
			 case 'j': score += 8*num; break;
			 
			 case 'k': score += 5*num; break;
			 
			 case 'l': score += 1*num; break;
			 
			 case 'm': score += 3*num; break;
			 
			 case 'n': score += 1*num; break;
			 
			 case 'o': score += 1*num; break;
			 
			 case 'p': score += 3*num; break;
			 
			 case 'q': score += 10*num; break;
			 
			 case 'r': score += 1*num; break;
			 
			 case 's': score += 1*num; break;
			 
			 case 't': score += 1*num; break;
			 
			 case 'u': score += 1*num; break;
			 
			 case 'v': score += 4*num; break;
			 
			 case 'w': score += 4*num; break;
			 
			 case 'x': score += 8*num; break;
			 
			 case 'y': score += 4*num; break;
			 
			 case 'z': score += 10*num; break;
			 
			}
			 
		}
		
	   if(bonus)
	   {
		if(getRand(100)%5==0&&getRand(100)%2==0&&getRand(100)%2==0&&getRand(100)%2==0)
		   num2 = 2;
		if(getRand(100)%5==0&&getRand(100)%4==0&&getRand(100)%3==0&&getRand(100)%3==0)
		   num2 = 3;
		else
		   num2 = 1;
		if(getRand(100)%6==0&&getRand(100)%5==0&&getRand(100)%4==0&&getRand(100)%3==0&&getRand(100)%2==0)
		{   num2 = 0; System.out.println("You are very unlucky! You gain 0 points for this word!\7\7");}
		   
		if(num2!=1&&num2!=0)
			System.out.println("Gained random bonus points! \7");
		}
		else
		   num2 = 1;
		return score*num2;
	   
	}
	
	/**
	*Converts a character to a number. This is to be used for the board coordinates, and user input.
	*@param ch The character to be converted.
	*@return The number corresponding to that character.
	*/
	public int charToNum(char ch)
	{
	
            int num = 0;
    
            switch(ch)
            {
            
             case 'A':   num = 0; break;
        
             case 'B':   num = 1; break;
             
             case 'C':   num = 2; break;
             
             case 'D':   num = 3; break;   
             
             case 'E':   num = 4; break;   
        
             case 'F':   num = 5; break;   
             
             case 'G':   num = 6; break;   
             
             case 'H':   num = 7; break;       
        
             case 'I':   num = 8; break;    
             
             case 'J':   num = 9; break;   
			 
			 case 'K':   num = 10; break;   
			 
			 case 'L':   num = 11; break;   
			 
			 case 'M':   num = 12; break;   
			 
			 case 'N':   num = 13; break;   
			 
			 case 'O':   num = 14; break;   
             
             default: break;
                
             }//end switch(ch) 
             
             return num;
	
	}
	
	/**
	*Generates a pseudo-random number between 0 and max inclusive
	*@param max The highest number that can be generated.
	*@return The generated random number
	*/
	public int getRand(int max)
	{
	
		Random rand = new Random();
		return rand.nextInt(max);
		
	}
	
	/**
	*Places a tile on the board
	*@param num The number of the tile that will be placed. 
	*@param row The row coordinate. 
	*@param col The column coordinate.
	*@param dir The direction in which the word will appear on the board.
	*/
	public void placeTile(int num, int row, int col, int dir)
	{
	
	  if(row<0||row>14||col<0||col>14)
	    return;
	
	  if(tempBoard[row][col]==' '||tempBoard[row][col]=='*')
	  {
	  
	    if(tempRack.get(num)!=' ')
		{
		   tempBoard[row][col] = tempRack.get(num);
		   tempRack.remove(num);
		   tempRack.add('!');
		}
		else
		{
		   System.out.println("What would you like the blank tile to represent?");
		   Scanner scan1 = new Scanner(System.in);
		   tempBoard[row][col] = scan1.next().charAt(0);
		   tempRack.remove(num);
		   tempRack.add('!');
		}
		
	}
	  else 
	  {
	  
	     if(dir==0)
		 {
		    placeTile(num, row, col+1, dir);
			return;
		 }
		 else if(dir==1)
		 {
		    placeTile(num, row-1, col, dir);
			return;
		 }
	  
	  }
	  
	}
	
	/**
	*Refills each player's rack if it is less than 7 tiles
	*/
	public void refillRacks()
	{
	
		//System.out.println("Refill!");
	   for(int count = 0; count<yourRack.size(); count++)
	   {
	      if(yourRack.get(count)=='!')
		     yourRack.remove(count);
	   }
	
	   while(yourRack.size()!=7)
	   {
	      
	      int rand = getRand(letters.size());
		  yourRack.add(letters.get(rand));
		  letters.remove(rand);
		  
	   }
	   
	   for(int count = 0; count<enemyRack.size(); count++)
	   {
	      if(enemyRack.get(count)=='!')
		     enemyRack.remove(count);
	   }
	
	   while(enemyRack.size()!=7)
	   {
	      
	      int rand = getRand(letters.size());
		  if(letters.get(rand)!=' ')
		    {
			enemyRack.add(letters.get(rand));
			letters.remove(rand);
		    }
	   }
	   
	}

	/**
	*Returns the player's rack
	*@return The player's rack
	*/	
	public ArrayList<Character> getRack()
	{
		return yourRack;
	}
	
	/**
	*Returns the enemy's rack
	*@return The enemy's rack
	*/	
	public ArrayList<Character> getEnemyRack()
	{
		return enemyRack;
	}
	
	/**
	*Returns the board
	*@return The board
	*/	
	public char[][] getBoard()
	{
	   return board;
	}
	
	/**
	*Returns the remaining letters
	*@return The remaining letters
	*/	
	public ArrayList<Character> getLetters()
	{
	   return letters;
	}
	
	/**
	*Stores the current instance variables in temporary instance variables
	*/	
	public void storeBoard() //keeps the current board and racks saved in case the use enters an invalid word
	{
	   
	   for(int v = 0; v<15;v++)
	   { 
	      
		  for(int w = 0; w<15;w++)
		     tempBoard[v][w] = board[v][w];
		  
	   }
	   
	   for(int x = 0; x<yourRack.size();x++)
	   {
	      tempRack.set(x, yourRack.get(x));
	   }
	   
	   for(int y = 0; y<yourRack.size();y++)
	   {
	     if(yourRack.size()>=tempLetters.size())
		    break;
		 else
	      tempLetters.set(y, letters.get(y));
	   }
	   
	}
	
	/**
	*Stores the current instance variables in temporary instance variables used for the enemy's turn
	*/	
	public void storeBoard2() //keeps the current board and racks saved in case the use enters an invalid word
	{
	
	   tempBoard = new char[15][15];
	   
	   for(int v = 0; v<15;v++)
	   { 
	      
		  for(int w = 0; w<15;w++)
		     tempBoard[v][w] = board[v][w];
		  
	   }
	   
	   for(int x = 0; x<tempEnemyRack.size();x++)
	   {
	      enemyRack.set(x, tempEnemyRack.get(x));
	   }
	   
	   for(int y = 0; y<enemyRack.size();y++)
	   {
	   
	     if(enemyRack.size()>=letters.size())
		    break;
		 else
	      letters.set(y, tempLetters.get(y));
	   }
	   
	}
	
	/**
	*Returns the temporary board
	*@return The temporary board
	*/	
	public char[][] getTempBoard()
	{
	   return tempBoard;
	}
	
	/**
	*Returns the temp rack
	*@return The temporary rack
	*/	
	public ArrayList<Character> getTempRack()
	{
	   return tempRack;
	}
	
	/**
	*Returns the temp rack
	*@return The temporary rack
	*/	
	public ArrayList<Character> getTempLetters()
	{
	   return tempLetters;
	}
	
	/**
	*Stores the temporary instance variables in the regular instance variables
	*/
	public void fixBoard()
	{
	   for(int v = 0; v<15;v++)
	   { 
	      
		  for(int w = 0; w<15;w++)
		     board[v][w] = tempBoard[v][w];
		  
	   }
	   
	   for(int x = 0; x<yourRack.size();x++)
	   {
	      yourRack.set(x, tempRack.get(x));
	   }
	   
	   for(int y = 0; y<yourRack.size();y++)
	   {
	      letters.set(y, tempLetters.get(y));
	   }
	}
	
	/**
	*Stores the temporary instance variables in the regular instance variables used for enemy's turn
	*/
	public void fixBoard2()
	{
	   for(int v = 0; v<15;v++)
	   { 
	      
		  for(int w = 0; w<15;w++)
		    board[v][w] = tempBoard[v][w];
		  
	   }
	   
	   for(int x = 0; x<tempEnemyRack.size();x++)
	   {
	      tempEnemyRack.set(x, enemyRack.get(x));
	   }
	   
	   for(int y = 0; y<tempEnemyRack.size();y++)
	   {
	      tempLetters.set(y, letters.get(y));
	   }
	}
	
	/**
	*Validates the board, and makes sure that all moves are legal. This is to be used by the Client program 
	*@return True or false whether the board is legal or not.
	*/
	public boolean checkBoard() throws FileNotFoundException
	{
	   String word = "";
	   int xStartIndex = 0, yStartIndex = 0, xEndIndex = 0, yEndIndex = 0;
	   Dictionary dict = new Dictionary();
	   
	   for(int x=0;x<15;x++)
	   {
	   
	      for(int y=0;y<15;y++)
		  {
		     
			 if(tempBoard[x][y]!=' ')
			 {
			    word = "";
			    int tempX = x;
				int tempY = y;
				//System.out.println(x + " " + y);
				
			    while(tempBoard[tempX][tempY]!=' ')
				{
				   //System.out.println(1);
				   xStartIndex = tempX;
				   yStartIndex = tempY;
				   tempY--;
				   if(tempY<0)
					  break;
				}
				
				tempY = y;
				
				while(tempBoard[tempX][tempY]!=' ')
				{
				   //System.out.println(2);
				   xEndIndex = tempX;
				   yEndIndex = tempY;
				   tempY++;
				   if(tempY>14)
					  break;
				}
				
				for(int start = yStartIndex; start<=yEndIndex; start++)
				{
				   //System.out.println(3);
				   word += tempBoard[x][start] + "";
				}
				
				//System.out.println(word);
				
				if(dict.confirm(word)==false)
				{
				   
				   if(word.length()>1)
					  {
					        return false;
					  }
				        
				   if(x>0&&x<14)
				   {
				      
				      if(word.length()==1&&(tempBoard[x-1][y]==' '&&tempBoard[x+1][y]==' '))
				      {
				        return false;
				      }
					  
				   } 
				   else if(x==0)
				   {
				   
				      if(word.length()==1&&tempBoard[x+1][y]==' ')
				      {
				        return false;
				      }
					  
				   }
				   else if(x==14)
				   {
				      if(word.length()==1&&tempBoard[x-1][y]==' ')
				      {
				        return false;
				      }
				   }
				}//end confirm if block
				
				word = "";
				
				while(tempBoard[tempX][y]!=' ')
				{
				   //System.out.println(4);
				   xStartIndex = tempX;
				   yStartIndex = tempY;
				   tempX--;
				   if(tempX<0)
					  break;
				}
				
				tempX = x;
				
				while(tempBoard[tempX][y]!=' ')
				{
				
				   //System.out.println(5);
				   xEndIndex = tempX+1;
				   yEndIndex = tempY;
				   tempX++;
				   if(tempX>14)
					  break;
				   
				}
				
				for(int end = xEndIndex-1; end>=xStartIndex; end--)
				{
				   //System.out.println(6);
				   word += tempBoard[end][y] + "";
				}
				
				//System.out.println(word);
				
				if(dict.confirm(word)==false)
				{
				   
				   if(word.length()>1)
					  {
					        return false;
					  }
				        
				   if(y>0&&y<15)
				   {
				      
				      if(word.length()==1&&tempBoard[x][y-1]==' '&&tempBoard[x][y+1]==' ')
				      {
				        return false;
				      }
				   } 
				   else if(y==0)
				   {
				   
				      if(word.length()==1&&tempBoard[x][y+1]==' ')
				      {
				        return false;
				      }
					  
				   }
				   else if(y==15)
				   {
				      if(word.length()==1&&tempBoard[x][y-1]==' ')
				      {
				        return false;
				      }
				   }
				}//end confirm if block
				
				word = "";
				
			 }
			 
		  }
	   
	   }
	   //System.out.println("True");
	   return true;
	}//end checkBoard()
	
	/**
	*Returns the word that the user most recently entered
	*@param start The index that the word started on
	*@param other The index of the other coordinate that the word is on
	*@param dir The direction in which the word is on the board.
	*@return The user's entered word
	*/
	public String getEnteredWord(int start, int other, int dir)
	{
	
	  try
	  {
	   String word = "";
	   int startIndex = 0;
	   int endIndex = 0;
	   if(dir==0)
	      endIndex = 14;
	   int temp = start;
	   boolean looper = true;
	   
	   if(other>=15)
		     other = 14;
	   else if(other<1)
		     other = 0;
	   
	   if(dir==0)
	   {
	    
		  if(temp<1)
				   { startIndex = 0; looper = false;}
		  else if(temp>13)
				{	endIndex = 14;  looper = false;}
				
		  if(other>14)
		     other = 14;
	      else if(other<1)
		     other = 0;
				
	    while(tempBoard[other][temp]!=' '&&looper)
				{
				   //System.out.println(1);
				   startIndex = temp;
				   temp--;
				   if(temp<1)
				   { startIndex = 0; break; }
				}			
		
		temp = start;
		
		 if(temp<1)
			    { startIndex = 0; looper = false; }
		  else if(temp>13)
				{	endIndex = 14; looper = false; }
				
	   while(tempBoard[other][temp]!=' '&&looper)
				{//System.out.println(2);
				   endIndex = temp;
				   temp++;
				   if(temp>13)
				   { endIndex = 14; break; }
				   else if(temp<1)
				   { endIndex = 0; break; }//
				}
		
		for(int count = startIndex; count<=endIndex; count++)
				{
				   word += tempBoard[other][count] + "";
				   //System.out.println("Char at [" + x + "][" + start + "] is " + board[x][start] );
				}
				
	   
	   }
	   else if(dir==1)
	   {
	      
		  if(other>14)
		     other = 14;
	      else if(other<1)
		     other = 0;
		  
		  if(temp<1)
				   { startIndex = 0; looper = false; }
		  else if(temp>13)
				{ endIndex = 14; looper = false;}
		  
		  while(tempBoard[temp][other]!=' '&&looper)
				{//System.out.println(3);
				   startIndex = temp;
				   temp--;
				   if(temp<1)
				   { startIndex = 0; break; }//
				   else if(temp>13)
				   { startIndex = 14; break; }
				}
		   
		temp = start;
		
		if(temp<1)
				   { startIndex = 0; looper = false; }
		  else if(temp>13)
				{	endIndex = 14; looper = false; }
				
	     while(tempBoard[temp][other]!=' '&&looper)
				{//System.out.println(4);
				   endIndex = temp;
				   temp++;
				   if(temp>13)
				   { endIndex = 14; break; }
				else if(temp<1)
				   { endIndex = 0; break; }//
				}
		
		for(int count = endIndex; count>=startIndex; count--)
				{
				   word += tempBoard[count][other] + "";
				   //System.out.println("Char at [" + x + "][" + start + "] is " + board[x][start] );
				}
		  
	   }
	   
	   System.out.print(startIndex + " " + endIndex);
	   System.out.println(" Word = " + word);
	   
	   if(word.length()>word.replace(" ", "").length())
	      return "!";
	   
	   
	   return word;
	   }
	   catch(ArrayIndexOutOfBoundsException e)
	   {
	      return "!";
	   }
	   
	}//end getEnteredWord()
	
	
	/**
	*Determines if the user placed a word in an illegal spot on the board, by comparing the length of the entered word to the number of tiles they placed
	*@param onBoard The index that the word started on.
	*@param length The number of tiles the user placed.
	*@return true or false if the move is valid or not
	*/
	public boolean checkLength(String onBoard, int length)// makes sure the user entered a word using tiles on the board
	{
	
		  //System.out.println("word length = " + onBoard + " counter = " + length);
		  
	      if(onBoard.length()<=length)
		     return false;
		  else 
		     return true;
	}
	
	/**
	*Adds the number of points from the user's entered word to the player's(or computer player's) total score.
	*@param whichPlayer The number representing which player is gaining the points
	*@param word The word that was entered
	*/
	public void addScore(int whichPlayer, String word)
	{
	
	   int addedScore = 0;
		
	   if(whichPlayer==0)
	   {
		  addedScore = getScore(word, true);
	      playerScore += addedScore;
		  System.out.println("You gain " + addedScore + " points");
	   }
	   if(whichPlayer==1)
	   {
	      addedScore = getScore(word, true);
	      enemyScore += addedScore;
		  System.out.println("Opponent gains " + addedScore + " points");
	   }
	   
	}
	
	/**
	*Return's the player's current score
	*@return The player's score
	*/
	public int getYourScore()
	{
	   return playerScore;
	}
	
	/**
	*Return's the opponent's current score
	*@return The opponent's score
	*/
	public int getEnemyScore()
	{
	   return enemyScore;
	}
	
	/**
	*Searches through the board, and determines which letters are available to use for a word.
	*@return An array containing all of the letters that can be used to make a word.
	*/
	public ArrayList<Character> getAvailableLetters()
	{
	
	   ArrayList<Character> availableLetters = new ArrayList();
	
	   for(int x = 0; x<15; x++)
	   {
	      
		  for(int y = 0; y<15; y++)
		  {
		  
		  if(x>0&&x<14&&y>0&&y<14){
			if(board[x][y]!=' ')
			{
			
			   if(board[x][y+1]!=' '&&board[x+1][y]!=' '&&board[x][y-1]!=' '&&board[x-1][y]!=' ')
			      break;
				  
			   if(board[x][y+1]==' '&&board[x][y-1]==' ')
			      availableLetters.add(board[x][y]);
			   else if(board[x+1][y]==' '&&board[x-1][y]==' ')
			      availableLetters.add(board[x][y]);
			
			} }
		  
		  }
		  
	   }
	   
	   /*for(int lol = 0; lol<availableLetters.size();lol++)
	      System.out.println(availableLetters.get(lol));*/
	  	   
	   return availableLetters;
	   
	}
	
	/**
	*Searches through the dictionary, and determines which words can be made using the available letters.
	*@return An array containing all of the words that can be made using the letters on the opponents rack, and on the board/
	*/
	public ArrayList<String> getDictWords() throws FileNotFoundException 
	{
		
		Dictionary dict = new Dictionary();
		ArrayList<String> words = dict.getWords();
		ArrayList<String> dictWords = new ArrayList();
		ArrayList<String> dictWords2 = new ArrayList();
		ArrayList<Character> currentRack = new ArrayList();
		int charCount = 0; //This variable keeps track of how many characters the rack contains that are in the current word
		ArrayList<Character> lettersOnBoard = getAvailableLetters();
		boolean continuer = true, breaker = false, doubleLetter = false, missingLetterOnBoard = false, breaker2 = false;
		char missingLetter = '!';
		int yzNum = 0;
		
		for(int yz = 0; yz<lettersOnBoard.size(); yz++)
		{
		   if(lettersOnBoard.get(yz)=='z')
		    {  yzNum = 0; break; }
			
			if(yz==lettersOnBoard.size()-1)
			{
			   yzNum = words.size() - 78958;
			}
		      
		}
		
		for(int yz = 0; yz<enemyRack.size(); yz++)
		{
		   if(enemyRack.get(yz)=='z')
		    {  yzNum = 0; break; }
		      
		}
		
		for(int yz = 0; yz<lettersOnBoard.size(); yz++)
		{
		   if(lettersOnBoard.get(yz)=='y')
		    {  yzNum = yzNum; break; }
			
			if(yz==lettersOnBoard.size()-1)
			{
			   yzNum = words.size() - 78502;
			}
		      
		}
		
		for(int yz = 0; yz<enemyRack.size(); yz++)
		{
		   if(enemyRack.get(yz)=='y')
		    {  yzNum = 0; break; }
		      
		}
		
		
		for(int x = 0; x<words.size() - yzNum; x++)
		{
		
		   if(words.get(x).length()>7)
		      continue;
		   
		   missingLetter = '!';
		   charCount = 0;
		   continuer = true; 
		   breaker = false;
		   breaker2 = false;
		   doubleLetter = false;
		   missingLetterOnBoard = false;
		   
		   for(int z = 0; z<words.get(x).length(); z++)
		   {
		       for(int w = 0; w<lettersOnBoard.size(); w++)
			   {
				  if(words.get(x).charAt(z)==lettersOnBoard.get(w))
				  {	 breaker = true; continuer = false; break; }
			   }
			   
			   if(breaker)
			      break;
		   }
		   
		   if(continuer)
			  continue;
		   
		   currentRack = new ArrayList();
		   
		   for(int lol = 0; lol<enemyRack.size(); lol++)
		      currentRack.add(enemyRack.get(lol));
		
		//System.out.println(words.get(x));
			
		   for(int check = 0; check<words.get(x).length(); check++)
		   {
			  
			  for(int y = 0; y<currentRack.size();y++)
			  {
			     if(currentRack.get(y)==words.get(x).charAt(check))
				 { charCount++; currentRack.remove(y); break; }
				 else
				    continue;
			  }//end current tile loop
			  
			  if(check==7)
			     break;
		   }//end current word loop
		   
		   for(int v = 0; v<words.get(x).length(); v++)
		   {
		     for(int count2 = 0; count2<enemyRack.size(); count2++)
			 {
			    if(words.get(x).charAt(v)==enemyRack.get(count2))
				{   break; }
				
				if(count2==enemyRack.size()-1)
				{   
				missingLetter = words.get(x).charAt(v); 
				breaker2 = true; 
				break; 
				}   
				
			 }
			 
			 if(breaker2)
			    break;
		   }
		   
		   for(int yetAnotherCount = 0;yetAnotherCount<lettersOnBoard.size();yetAnotherCount++)
		   {
		      if(lettersOnBoard.get(yetAnotherCount)==missingLetter)
			   { missingLetterOnBoard = true; break;}
		   }
		   
		   //System.out.print(missingLetterOnBoard);
		   
		   if(charCount==words.get(x).length()-1&&missingLetterOnBoard)
		   {
		     //System.out.print("ML: " + missingLetter + "| " );
		     //System.out.println(words.get(x) + " " + charCount + " | ");
		    if(dictWords.isEmpty()==false) 
			{
			  if(getScore(words.get(x), false)>=getScore(dictWords.get(0), false))
			     dictWords.add(0, words.get(x));
			  else
			     dictWords.add(words.get(x));
				 
			} 
			else
				 {
				    dictWords.add(words.get(x));
				 }
				 
		   }
		   /*else if(charCount==words.get(x).length())
		      dictWords.add(words.get(x));*/
		   else
		      continue;
		   
		}//end main for loop
	
		  //System.out.println(dictWords.toString() + " " + dictWords.size());

		System.out.print("Enemy rack: " + enemyRack.toString());
		
		if(dictWords.size()==0)
		{   throwAwayEnemyRack(); return getDictWords(); }
		else
		   return dictWords;
	
	}
	
	/**
	*Places an enemy's tile on the board
	*@param num The number of the tile that will be placed. 
	*@param row The row coordinate. 
	*@param col The column coordinate.
	*@param dir The direction in which the word will appear on the board.
	*/
	public void placeEnemyTile(int num, int row, int col, int dir)
	{
	
	  if(row<0||row>14||col<0||col>14)
	    return;
	
	  if(tempBoard[row][col]==' '||tempBoard[row][col]=='*')
	  {
	  
	    if(enemyRack.get(num)!=' ')
		{
		   tempBoard[row][col] = enemyRack.get(num);
		   enemyRack.remove(num);
		   enemyRack.add('!');
		}
		else
		{
		   System.out.println("What would you like the blank tile to represent?");
		   Scanner scan1 = new Scanner(System.in);
		   tempBoard[row][col] = scan1.next().charAt(0);
		   enemyRack.remove(num);
		   enemyRack.add('!');
		}
		
	  }
	  else 
	  {
	  
	     if(dir==0)
		 {
		    placeEnemyTile(num, row, col+1, dir);
			return;
		 }
		 else if(dir==1)
		 {
		    placeEnemyTile(num, row-1, col, dir);
			return;
		 }
	  
	  }
	  
	}
	
	/**
	*This function represents the enemy's turn, it calls all of the search functions the computer player will use to form words to place on the board.
	*@param tryCount The number of times the function has been recursively called. This is used to iterate through the words in the list returned by getDictWords() if one of the words happens to be illegal.
	*/
	public void enemyTurn(int tryCount) throws FileNotFoundException
	{
	   ArrayList<String> wordsToUse = getDictWords();
	   int dir = 0, missRow = 0, missCol = 0, spot = 0;//spot is the index of the word that the missing letter is at
	   boolean breaker = false;
	   char missingLetter = '!';
	   //System.out.println("enemyTurn() called tryCount = " + tryCount);
	 
	   if(tryCount>=wordsToUse.size()/2)
	   {   
	   tryCount = 0;
	   throwAwayEnemyRack();
	   }
	   ArrayList<Character> currentWord = new ArrayList();
	   
	   for(int i = 0; i<wordsToUse.get(tryCount).length(); i++)
	   {
	      currentWord.add(wordsToUse.get(tryCount).charAt(i));
	   }
	   
	    for(int v = 0; v<wordsToUse.get(tryCount).length(); v++)
		   {
		     for(int count2 = 0; count2<enemyRack.size(); count2++)
			 {
			    if(wordsToUse.get(tryCount).charAt(v)==enemyRack.get(count2))
				{   break; }
				
				if(count2==enemyRack.size()-1)
				{   
				missingLetter = wordsToUse.get(tryCount).charAt(v); ///////////
				spot = v;
				breaker = true; 
				break; 
				}   
				
			 }
			 
			 if(breaker)
			    break;
		   }
	   
	   for(int row1 = 0; row1<15; row1++)
	   { //this nested for loop finds out where the missing letter is on the board.
	    
		   for(int col1 = 0; col1<15; col1++)
		   {
		      
			  if(missingLetter==board[row1][col1])
			  {
			  
			   if(row1>0&&row1<14&&col1>0&&col1<14)
			   {
				if(board[row1][col1+1]==' '&&board[row1][col1-1]==' ')
				{	
				dir = 0;
				missRow = row1;
				missCol = col1;
				}
				else if(board[row1+1][col1]==' '&&board[row1-1][col1]==' ')
				{	
				dir = 1;
				missRow = row1;
				missCol = col1;
				}
			   }
				
			  }
			  
		   }
		
	   }
	   //System.out.println(wordsToUse.get(tryCount));
	   
	   int startRow = 0 , startCol = 0;
	   //System.out.println(spot + " spot");
	   if(dir==0)
	   {
	      startRow = missRow;
		  startCol = missCol - spot;
	   }
	   else if(dir==1)
	   {
	   startRow = missRow + spot;
	   startCol = missCol;
	   }
	   int num = 0, counter = 0;
	   while(currentWord.size()>0)
	   {
	      
		 for(int go = 0; go<enemyRack.size(); go++) 
		 {
		    if(enemyRack.get(go)==currentWord.get(0))
			{
			   num = go;
			   break;
			}
			
			if(go==enemyRack.size()-1)
			{   num = -1; }
		 }
		  
		 if(dir==0) { 
		   if(num!=-1)
		    placeEnemyTile(num, startRow, startCol + counter, dir); }
		 else if(dir==1){
		   if(num!=-1)
		    placeEnemyTile(num, startRow + counter, startCol, dir); }
			
		 currentWord.remove(0);
		  
	   }
	   
	   if(getEnteredWord(startCol, startRow, dir).equals("!"))
	   {  enemyTurn(tryCount+1); return; }
	   
	   if(checkBoard()==true)
	   {   
	   System.out.print(wordsToUse.get(tryCount));
	   fixBoard2(); 
	   //System.out.println("checkBoard() was true"); 
	   
	   if(startCol>14)
	      startCol = 14;
	   if(startCol<1)
	      startCol = 0;
	   if(startRow>14)
	      startRow = 14;
	   if(startRow<1)
	      startRow = 0;
	   
	   if(dir==0)
	      addScore(1, getEnteredWord(startCol, startRow, dir));
	   else if(dir==1)
	      addScore(1, getEnteredWord(startRow, startCol, dir));
	   refillRacks(); 
	   }
	   else
	   {
	   storeBoard2();
	   enemyTurn(tryCount+1);
	   return;
	   //System.out.println("checkBoard() was false"); 
	   }
		  
	   refillRacks();
	   
	}
	
	/**
	*Adds all of the letters in the player's rack back to the "bag"(letters ArrayList) and refills it with new letters
	*/
	public void throwAwayPlayerRack()
	{
	   for(int x = 0; x<yourRack.size(); x++)
	   {
	      if(yourRack.get(x)!='!')
	         letters.add(yourRack.get(x));
	   }
	   yourRack.clear();
	   
	   for(int count = 0; count<yourRack.size(); count++)
	   {
	      if(yourRack.get(count)=='!')
		     yourRack.remove(count);
	   }
	
	   while(yourRack.size()!=7)
	   {
	      
	      int rand = getRand(letters.size());
		  yourRack.add(letters.get(rand));
		  letters.remove(rand);
		  
	   }
	  
	}
	
	/**
	*Adds all of the letters in the enemy's rack back to the "bag"(letters ArrayList) and refills it with new letters
	*/
	public void throwAwayEnemyRack()
	{ 
	   
	   //System.out.println("new enemy rack!");
	   /*for(int x = 0; x<enemyRack.size(); x++)
	   {
	      if(enemyRack.get(x)!='!')
	         letters.add(enemyRack.get(x));
	   }*/
	   
	   for(int x = 0; x<tempEnemyRack.size(); x++)
	   {
	      if(tempEnemyRack.get(x)!='!')
	         letters.add(tempEnemyRack.get(x));
	      
	   }
	   
	   enemyRack.clear();
	   tempEnemyRack.clear();
	   
	   for(int count = 0; count<7; count++)
	   {
	      int rand = getRand(letters.size());
		  tempEnemyRack.add(letters.get(rand));
		  enemyRack.add(letters.get(rand));
		  letters.remove(rand);
	   }
	   
	}
	
	/**
	*Prints out how many letters are left in the bag
	*/
	public void lettersLeft()
	{
	   System.out.println(letters.size() + " letters left in the bag!");
	}
	
	/**
	*This function is called at the end of the game, and prints who has won.
	*/
	public void endGame() throws FileNotFoundException
	{	
		if(playerScore>enemyScore)
		   System.out.println("Congrats! You win with a score of !" + playerScore);
		else if(enemyScore>playerScore)
		   System.out.println("You lose! Please try again...you will probably lose again though!");
		else
		   System.out.println("I guess that's a tie? That means you lose anyway!");
	}
	
	/**
	*Checks to see whether a String is numeric or not.
	*@param str The string to check
	*@return The boolean decision on whether or not str is numeric.
	*/
	public static boolean isNumeric(String str) throws NumberFormatException
	{  
     try  
     {  
       int d = Integer.parseInt(str);  
     }  
     catch(NumberFormatException nfe)  
     {  
       return false;  
     }  
     return true;  
    }  
	
	
	private char[][] board = new char[15][15];
	private char[][] tempBoard = new char[16][16]; //saves the board before it is changed every turn in case the board needs to be changed back
	private int[][] boardNums = new int[15][15];
	private ArrayList<Character> letters = new ArrayList<Character>();
	private ArrayList<Character> yourRack = new ArrayList<Character>();
	private ArrayList<Character> enemyRack = new ArrayList<Character>();
	private ArrayList<Character> tempEnemyRack = new ArrayList<Character>();
	private ArrayList<Character> tempRack = new ArrayList<Character>();
	private ArrayList<Character> tempLetters = new ArrayList<Character>();
	private int playerScore = 0;
	private int enemyScore = 0;
	//private Dictionary dict = new Dictionary();
	
}