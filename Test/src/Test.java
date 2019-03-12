// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

import java.util.ArrayList;
public class Test
{
	
	public static void main (String[] args) {
		Test mainProgram = new Test();
		int[] tess = {2,3,4,5,6};
		
	System.out.println(		mainProgram.generalizedGCD(5, tess));
	}
	 public int generalizedGCD(int num, int[] arr)
	    {
	        ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
	        
	        for (int i = 0; i < arr.length; i++) {
	            if (findIfDivides(arr[i], arr)) {
	                listOfIntegers.add(new Integer(arr[i]));
	               // System.out.println(arr[i]);
	            }
	        }
	        
	        return findGreatestNumber(listOfIntegers);
	    } 
    
    public boolean findIfDivides(int num, int[] arr) {
        
        boolean yes = true;
        
            for (int j = 0; j < arr.length; j++) {
            	System.out.print(arr[j] / num);
                if (arr[j] % num != 0) {
                   yes = false;
                }
            }
        
        System.out.println("*************");
        return yes;
    }
    
    public int findGreatestNumber(ArrayList<Integer> listOfIntegers) {
        int largest = 1;
        
        for (Integer single: listOfIntegers) {
        	System.out.println(single);
            if (single > (Integer)largest) {
                largest = single;
            }
        }
        
        return largest;
    }
    // METHOD SIGNATURE ENDS
}