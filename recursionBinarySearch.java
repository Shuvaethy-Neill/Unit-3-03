/****************************************************************************
 * Created by: Shuvaethy Neill
 * Created on: April 2019
 * Created for: ICS4U
 * Binary search program that uses recursion
 ****************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class recursionBinarySearch {
	public static void main(String[] args) { 
		
		Scanner userInput = new Scanner(System.in);
		Random randGen = new Random();
		//create array
		int[] valuesArray = new int[250]; 
		
		System.out.print("Generated values:\n");
		
		int randNum;
		
		//fill array with random values and print
		for(int counter = 0; counter < valuesArray.length; counter++) {
			randNum = randGen.nextInt(500) + 1;
			valuesArray[counter] = randNum;
			System.out.println(randNum);
			
		}
		
		//print sorted values
		System.out.println("\nSorted values: ");
		NumberSort(valuesArray);
		
		do {
			//get number to search for from user
			System.out.println("\nEnter a number from 1 to 500 to search in values: ");
			int userNum = userInput.nextInt();
			
			//if the input is negative or greater than 500 (invalid)
			if(userNum < -1 || userNum > 500) {
				System.out.print("\nSorry that is an invalid input!");
			}
			else {
				//searches for number
				String search = NumSearch(valuesArray, userNum, 0, valuesArray.length - 1);
				System.out.print("\n" + search);
				break;
				
			}
			
		} while(true);
		
		//lets user add a number to the list of sorted values
		System.out.println("Enter a number you would like to add to the list: ");
		int newValue = userInput.nextInt();
		
		//create new array with room for one more value than old array
		int[] newArray = new int[valuesArray.length + 1];
		
		int valuesArrayIndex = 0;
		int newArrayIndex = 0;
		
		//checks if the values in the old sorted array are less than the user input and if so, puts them in the new array
		while(newArrayIndex<newArray.length) {
			if(valuesArray[valuesArrayIndex]<newValue) {
				newArray[newArrayIndex] = valuesArray[valuesArrayIndex];
				newArrayIndex ++;
				valuesArrayIndex ++;
			}
			else {
				//user input in array
				newArray[newArrayIndex] = newValue;
				newArrayIndex++;
				break;
			}
	
		}
		//continues to put other values after user input into new array from old array
		while(newArrayIndex<newArray.length) {
		newArray[newArrayIndex] = valuesArray[valuesArrayIndex];
		newArrayIndex++;
		valuesArrayIndex++;
		}
		
		//print out new array with user input
		for(int counter = 0; counter < newArray.length; counter++) {
			System.out.println(newArray[counter]);
		}
	}
	
	public static void NumberSort(int array[]) {
		// sorts elements in the array in numerical order from least to greatest
		int arrayLength = array.length;
		
		for(int nextNumber = 0; nextNumber < arrayLength; nextNumber ++) {
			for(int prevNumber = 0; prevNumber < arrayLength; prevNumber++) {
				if(array[nextNumber] < array[prevNumber]) {
					int sub = array[nextNumber];
					array[nextNumber] = array[prevNumber];
					array[prevNumber] = sub;
				}
			}
		}
		//prints out array
		for(int counter = 0; counter < arrayLength; counter++) {
			System.out.println(array[counter]);
		}
	} 
	
	public static String NumSearch(int array[], int srchNum, int lowIndex, int highIndex) {
		// searches for user number and returns whether or not the number is found
		
		if (lowIndex <= highIndex) {
			//finds the middle value
			int midIndex = (lowIndex + highIndex)/2;
			
			//if the number is equal to the middle value
			if(srchNum == array[midIndex]) {
				return "Found at " + (midIndex+1) + "\n";
			} 
			//if the number is greater than the mid then shorten the range by changing lowIndex
			else if(srchNum > array[midIndex]) {
				lowIndex = midIndex + 1;
			} 
			//if the number is less than the mid then shorten the range by changing highIndex
			else if(srchNum < array[midIndex]) {
				highIndex = midIndex - 1;
			}
		}
			
		else {
			return "Not found";
		}
		
		return NumSearch(array, srchNum, lowIndex, highIndex);
	}
}
