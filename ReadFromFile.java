package FloorBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.PatternSyntaxException;

public class ReadFromFile {
	
	AllPieces allPiecesObj = new AllPieces();
	ReadFromFile()
	{
		//System.out.println(" Constructor of ReadFromFile ......");
	}//ReadFromFile
	
	//Get all the available plank sizes from the file and path given below. 
	void getInput()
	{
		Scanner sc = null;
		try {
			sc = new Scanner(new File(".\\myPlanksize.txt")).useDelimiter("\\s*,\\s*");
		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			System.out.println("Exception in ReadFromFile");
			e.printStackTrace();
		};
		
  		while (sc.hasNext()) {
         String aString = (String)sc.next();
        
         //convert into double
         aString = convertIntoDouble(aString);
         FloorPiece Obj = new FloorPiece(aString);
         allPiecesObj.AddElement(Obj);
         //System.out.println(aString);
         
		}
		sc.close();
	}
	protected String convertIntoDouble(String aString) 	
	{
		if(aString.contains("-"))
	
		{
		 try{
		 String[]  first_subStrings = aString.split("-");
		 int wholeNumber = Integer.parseInt(first_subStrings[0]);
	  	 String[] second_subStrings = first_subStrings[1].split("/");
		 int n = Integer.parseInt(second_subStrings[0]);
		 int d = Integer.parseInt(second_subStrings[1]);
		 double fraction = (double)n/d;
		 fraction = fraction + wholeNumber;
		 aString = String.valueOf(fraction);
		 
		 }catch(ArrayIndexOutOfBoundsException e)
		 {
			 e.printStackTrace();
			 
		 }
		}
		
		else if(aString.contains("."))
		{
			try{
				 String[]  first_subStrings = aString.split("\\."); 
				 int wholeNumber = Integer.parseInt(first_subStrings[0]);
			  	 int decimalPart = Integer.parseInt(first_subStrings[1]);
				 
				 double fraction = (double)decimalPart/16;
				 fraction = fraction + wholeNumber;
				 aString = String.valueOf(fraction);
				 
				 }
				 catch(PatternSyntaxException e)
				 {
					 e.printStackTrace();
				 }
				 catch(ArrayIndexOutOfBoundsException e)
				 {
					 e.printStackTrace();
					 
				 }
		}
		return aString;
	}

	protected AllPieces getAllPieces()
	{
		return allPiecesObj;
	}
 
}//End Class ReadFromFile
