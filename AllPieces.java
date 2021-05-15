package FloorBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.PatternSyntaxException;

public class AllPieces
{
	TreeMap<Double, FloorPiece> tmap = 
        new TreeMap<Double, FloorPiece>();
        
	String [] FinalResultSet = new String[200];
	int uniqueCounter = 0;
	String [] uniqueResult = new String [200];
	AllPieces()
	{
		//System.out.println("Within constructor of AllPieces....");
	}
	
    void AddElement(FloorPiece object)
	{
    	Double key = Double.valueOf(object.getValue());
    	FloorPiece tmpObj = tmap.get(key);
    	
    	if ( tmpObj != null)
    	{
    		 tmpObj.incrementCount();
    	} else
    	{
    		tmap.put(key, object);
    	}
		
	}//End AddElement
    
    void removeElement(Double key)
    {
       	//Double key = Double.valueOf(object.getValue());
    	FloorPiece tmpObj = tmap.get(key);
       	if ( tmpObj != null)
    	{
    		if( tmpObj.getCount() > 0)
    			tmap.get(key).decrementCount();
    		//tmpObj.decrementCount();
    		else
    			tmap.remove(tmpObj);
    	}
    	else
    	{
    		System.out.println(" removeElement,  No object found for key: " + key);
    	}
    }
    
    /** Calculate the number of combinations that adds up to count */
    void calcNumberOfPieces( double sizeOfcontainer)
    {
    	String [] resultSet = new String[500]; //new String[100]{"0"};
    	double key =  sizeOfcontainer;
    	double minValue = 0;
    	double [] arrayValues = new double[500];
    	int resultCounter = 0;
    	if(tmap.firstEntry() == null)
    	{
    		System.out.println(" No more data in the tree, exiting ....  ");
      	  	System.exit(0);
    	}//End if
    	
    	//The least value
    	FloorPiece objFirstEntry  = new FloorPiece(tmap.firstEntry().getValue());
    	
    	//Set to the least value in the tree...
    	minValue = objFirstEntry.getValue();
    	if(minValue == sizeOfcontainer)
    	{
    		System.out.println("This is the only fit: " + minValue);
    		return;
    	}
    	int i = 0;  	
    	//Calculate the number of pieces....
    	// This gets the greatest number less than or equal to sizeOfcontainer
    
    	FloorPiece ObjFloorEntry  = (FloorPiece) tmap.floorEntry(key).getValue();
    	if (ObjFloorEntry.getValue() == key)
    		FinalResultSet[resultCounter++] = Double.toString(key);
    	System.out.println(" Minimum length of the piece: " + minValue + " Max length available less than desired value:"  + ObjFloorEntry.getValue()); // + " resultset: " + resultSet[0]);
    	   	
    	Set<Entry<Double, FloorPiece>> set = tmap.entrySet();
    	Iterator<Entry<Double, FloorPiece>> iterator=  set.iterator();
    	List <FloorPiece>listA = new  ArrayList<FloorPiece>();
    	double finalLength = 0;
    	int arrayIndex = 0;
    	while(iterator.hasNext()){
    	
    	  //tmap.Entry =  
    	  Map.Entry<Double, FloorPiece> mentry =  (Map.Entry<Double, FloorPiece>)iterator.next();
    	  FloorPiece Obj = new FloorPiece((FloorPiece)mentry.getValue());
  	      
    	  //Read all the objects into a set from first entry to the floor value....
    	  if(Obj.getValue() <= ObjFloorEntry.getValue())
    	  {
    	      //listA.add(Obj);
    	      int count = Obj.getCount();
    	      while(count != 0)
    	      {
    	    	  //System.out.println(" Count: " + count +  " Added values: " + Obj.getValue());
    	    	  listA.add(Obj);
    	    	  arrayValues[arrayIndex++] = Obj.getValue();  
    	    	  count--;
    	      }
    	  }
    	  else
    	    	break;
    	  }
    	  String resultSet1 = new String();
    	  //resultCounter = 0;
    	  //System.out.println(" ArrayIndex is: " + arrayIndex);
    	  	for (int j = 0; j< arrayIndex ; j++)
    		{
    			finalLength = arrayValues[j];
    			resultSet1 = String.valueOf(finalLength);
    			int incInnerLoop = 1;
    			for(int k = j+1; k<= arrayIndex;)
    			{
    				 finalLength = finalLength + arrayValues[k];
    				 resultSet1 = resultSet1 + ", " + arrayValues[k];
    				 if(finalLength == sizeOfcontainer)
    				 {
    					 
    					 //Found a result set
    					// System.out.println("Found the resultset: " + resultSet1);
    					 FinalResultSet[resultCounter] = resultSet1;
    					 //finalLength = arrayValues[j];
    					 resultCounter++;
    					 break;
    				 }
    				 
    				 if(finalLength >= sizeOfcontainer)
    				 {
    					 incInnerLoop++;
    					 k = j+incInnerLoop;
    					 finalLength = arrayValues[j];
    		    		 resultSet1 = String.valueOf(finalLength);
    				 }
    				 else
    					 k++;
       			}
    		
    		}
    	  	if(resultCounter > 0)
    		{
    	  		DisplayResults(resultCounter);
    	  		//MaintainData();
    		}
    	  	
    	  	else
    	  		System.out.println(" No matches found....");
    	  	
}//End calcNumberOfPieces
    
 
   void  MaintainData()
    {
	   // This function removes the selected result set from the map and will not be considered for future data. 
	   //
	   System.out.println(" Within MaintainData");
	   
	   System.out.println("Please enter the set selected to remove the available lot...");
	   System.out.println("Enter floor length:");
	   Scanner keyboard = new Scanner(System.in);
	   int arrayIndex = keyboard.nextInt();
	  // for(int i = 0; i <=uniqueResult[arrayIndex].length() ; i++)
		//   removeElement(uniqueResult[arrayIndex][i]);
		   
	   
	   
	   
    }//End MaintainData()
    
    /** Display content using Iterator*/
    void DisplayResults(int resultCounter)
    {
    	//System.out.println(" Within the function: DisplayResults, resultCounter: " + resultCounter);
    	if(resultCounter > 1)
    	{
    		uniqueCounter = 0;
			for(int k = 1; k<resultCounter; k++)
			{
				//for(int j= k ;FinalResultSet[j]!= null; j++)
				if(FinalResultSet[k-1].compareTo(FinalResultSet[k]) != 0)
				{
					uniqueResult[uniqueCounter] = FinalResultSet[k-1];
					System.out.println("ResultSet[" + uniqueCounter + "]:" + convertToFraction(uniqueResult[uniqueCounter])); //+ " FinalResultSet[" + k + "]:"+ FinalResultSet[k] );
					uniqueCounter++;
				}
			}
			// if the last two values in the array are the same then we need to print the last values...
			if(resultCounter > 1 && FinalResultSet[resultCounter-2].compareTo(FinalResultSet[resultCounter-1]) == 0)
			{
				uniqueResult[uniqueCounter] = FinalResultSet[resultCounter-2];
				System.out.println(" ResultSet[" + uniqueCounter + "]:" + convertToFraction(uniqueResult[uniqueCounter]));
			}
    	}
    	else
    		System.out.println("ResultSet[" + (resultCounter - 1)+ "]:" + convertToFraction(FinalResultSet[resultCounter-1]));
    		
    }//End DisplayResults
    
    String convertToFraction( String aString)
    {
    	String tmpString = null;
    	try{
			
    		String[] strArray = aString.split(",");
    		int index;
    		for(index=0; index < strArray.length; index++ );
    		{
    		//---
    		 String[]  first_subStrings = strArray[index].split("\\.");
			 int wholeNumber = Integer.parseInt(first_subStrings[0]);
		  	 int decimalPart = Integer.parseInt(first_subStrings[1]);
			 
			 String fraction = (String)Integer.toString(decimalPart * 16);
			 fraction = fraction + "//16";
			 tmpString = tmpString + Integer.toString(wholeNumber) + fraction ;
			 System.out.println("convertedString :" + tmpString);
    		}

    		}
			 catch(PatternSyntaxException e)
			 {
				 e.printStackTrace();
			 }
			 catch(ArrayIndexOutOfBoundsException e)
			 {
				 e.printStackTrace();
				 
			 }
	    		return tmpString;
    }//End convertToFraction
    
 /** Display content using Iterator*/
 void DisplayAllElements()
 {
	  System.out.println(" ****** DisplayAllElements()....");
	  Set<Entry<Double, FloorPiece>> set = tmap.entrySet();
	  Iterator<Entry<Double, FloorPiece>> iterator=  set.iterator();
	  int i = 0;
	  while(iterator.hasNext()) {
	     //tmap.Entry =  
	    Map.Entry<Double, FloorPiece> mentry =  (Map.Entry<Double, FloorPiece>)iterator.next();
		 
	    // Map.Entry = new (Map.Entry)iterator.next();
	    System.out.print( i++  + ". " + ((FloorPiece)mentry.getValue()).getValue() + " count:"  +
	    				((FloorPiece)mentry.getValue()).getCount() +  "\n" );
	     
	  }//End while 
 }//End DisplayAllElements...
 
}//End class

