/* Main.java

Main file of program to
create Tutorial Website objects

MUST HAVE tutorials.txt present in
project folder

Sorted arrays will then create 2 new text files in project folder

last edited March 20, 2021
 */


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{ // begin Main class
    public static void main(String[] args) throws Exception
    { // begin main()

        // initializes array to hold objects from file
        TutorialWebsite[] tutorialWebsites = new TutorialWebsite[20];

        // allows java to read the file
        java.io.File x = new File("Tutorials.txt");
        Scanner y = new Scanner(x);

        // creates 4 new files to write sorted arrays to
        java.io.File ascendingCsv = new File("AscendingArray.csv");
        java.io.File descendingCsv = new File("DescendingArray.csv");
        java.io.File ascendingTxt = new File("AscendingArray.txt");
        java.io.File descendingTxt = new File("DescendingArray.txt");

        TutorialWebsite temp = new TutorialWebsite();

        int i = 0;

        // while loop to write lines from text file into TutorialWebsite object
        //and put the TutorialWebsite objects into an array

        while (y.hasNext())
        { // begin while (y.hasNext())

            String lang = y.nextLine();
            String description = y.nextLine();
            String url = y.nextLine();

            temp = new TutorialWebsite(lang, description, url);

            tutorialWebsites[i] = temp;

            i++;

        } // end while (y.hasNext())

        // prints the unsorted array of TutorialWebsite objects
        System.out.println("Here is the unsorted array. \n");
        printArray(tutorialWebsites);

        // prints the selection sorted array in ascending order
        System.out.println("Here is the array in ascending order. \n");
        printArray(selectionSort(tutorialWebsites));
        toFile(selectionSort(tutorialWebsites), ascendingCsv); // writes array to ascending csv file
        toFile(selectionSort(tutorialWebsites), ascendingTxt); // writes array to ascending txt file

        // prints the insertion sorted array in descending order
        System.out.println("Here is the array in descending order. \n");
        printArray(insertionSort(tutorialWebsites));
        toFile(insertionSort(tutorialWebsites), descendingCsv); // writes array to descending csv file
        toFile(insertionSort(tutorialWebsites), descendingTxt); // writes array to descending txt file

    } // end main()


    // method to print array of TutorialWebsite objects

    public static void printArray(TutorialWebsite[] array)
    { // begin printArray()

        int i;

        for (i = 0; i < array.length; i++)
        { // begin for

            System.out.print(array[i]);

        } // end for


    } // end printArray()


    // Selection Sort method to sort array of objects in ascending order

    public static TutorialWebsite[] selectionSort(TutorialWebsite[] array)
    { // begin selectionSort()

        for (int i = 0; i < array.length - 1; i++)
        {  // begin for

            int index = i;

            for (int j = i + 1; j < array.length; j++)
            {  // begin for

                if (array[j].compareTo(array[index]) < 0)
                { // begin if

                    index = j;

                } // end if

            } // end for

            TutorialWebsite smallerSite = array[index];
            array[index] = array[i];
            array[i] = smallerSite;

        }  // end for

        return array;

    } // end selectionSort()


    // Insertion sort method to sort array of objects in descending order

    public static TutorialWebsite[] insertionSort(TutorialWebsite[] array)
    { // begin insertionSort

        // initializes temp object for the for loop
        TutorialWebsite temp = new TutorialWebsite();

        for (int i = 1; i < array.length; i++)
        {  // begin for

            for(int j = i ; j > 0 ; j--)
            { // begin for
                if(array[j].compareTo(array[j-1]) > 0)
                {   //  Begin for(int j = i ; j > 0 ; j--)

                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;

                }   // end for

            }  // end for

        }  // End for (int i = 1; i < input.length; i++)

        return array;

    } // end insertionSort


    // method to write sorted arrays to a file

    public static void toFile(TutorialWebsite[] array, File x) throws Exception
    { // begin toFile

        PrintWriter y = new PrintWriter(x);
        int count = 0;

        String printLine = "";
        TutorialWebsite[] list = new TutorialWebsite[20];

        while (count < array.length)
        { // start while (count < length)
            printLine = "";
            printLine = printLine + array[count].getLang() + ",";
            printLine = printLine + array[count].getDescription() + ",";
            printLine = printLine + array[count].getUrl();

            y.println(printLine);
            System.out.println(printLine);
            count = count + 1;

        } // end while (count < length)

        y.close();

    } // end toFile

} // end Main class


