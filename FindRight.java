package FloorBuilder;
import java.io.File;
import java.util.Scanner;

public class FindRight {
	 public static void main(String[] args)
	  {
		 double floorSize = 5.0;
		 ReadFromFile fileObj = new ReadFromFile();
		 fileObj.getInput();
		 //fileObj.display();
		 AllPieces allPiecesObj = fileObj.getAllPieces();
		 allPiecesObj.DisplayAllElements();
		 Scanner keyboard = new Scanner(System.in);
		 int count = 1;
		 while(count++ < 5)
		 {	
			 System.out.println("Enter floor length:");
			 floorSize = keyboard.nextDouble();
			 allPiecesObj.calcNumberOfPieces(floorSize);
			 System.out.println("\n\n");
		 }//End while
	  }
} //End FindRight