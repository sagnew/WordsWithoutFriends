import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;


public class Dictionary {

	public Dictionary() throws FileNotFoundException
	{
		FileReader reader2 = new FileReader("wordList.txt");
		Scanner in2 = new Scanner(reader2);
		
		for(int count1=0; in2.hasNextLine(); count1++)
		{
		    words.add(in2.nextLine());
		}
			
		in2.close();
	}
	
	public boolean confirm(String word)
	   {
	   
		  word = word.toLowerCase();
	      int index = 0, maximum = words.size(), first = 0, minCheckNum = 0, 
	      maxCheckNum = 0, lowest = 0, highest = words.size();
	      
		  index = (words.size())/2;
		  
	      while(true)
	      {
			if(words.get(index).compareTo(word)>0)
			  {
				  maximum = index;
			      index = index/2;  
			  }
			else
			   if(words.get(index).compareTo(word)<0)
				 {
					first = index+1;
					index = ((index+maximum)/2);
				 }
			  else
				if(words.get(index).equals(word))
			       return true;
			
			if(first>=maximum)
			{
			   return false;
			}
			
		  }
	   
	   }
	   
	   public ArrayList<String> getWords()
	   {
	   
			return words;
	   
	   }
	   
	
	private ArrayList<String> words = new ArrayList<String>();

}
