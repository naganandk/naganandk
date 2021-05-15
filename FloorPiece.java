package FloorBuilder;
import java.io.File;
import java.util.regex.PatternSyntaxException;
class FloorPiece
{
	protected	double mLength;
	protected	int iLength = -1;
	protected	int iCount=1;
	
	FloorPiece()
	{
	  System.out.println("Within Floor piece....");	
	}
	FloorPiece(String s)
	{
		String [] s1 = null;
		try{
		  mLength = Double.parseDouble(s);
		  iLength = (int)mLength;
		}catch(NumberFormatException e){
			System.out.println(" FloorPiece, unable to convert into numeric e: " + e);
		}
	}//End FloorPiece
	
	FloorPiece( FloorPiece obj)
	{
	  mLength = obj.mLength;
	  iLength = obj.iLength;
	  iCount= obj.iCount;
	}//End FloorPiece
	
	
	
	protected void incrementCount()
	{
		iCount++;
	}
	
	protected void decrementCount()
	{
		iCount--;
	}
	
	protected int getCount()
	{
		return iCount;
	}
	
	int getLength()
	{
		return iLength;
	}//End getLength
	
	double getValue()
	{
		return mLength;
	}
}//End FloorPiece