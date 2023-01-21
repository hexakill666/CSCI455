package main.assignment4;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * scrabble driver program
 */
public class WordFinder {

    public static void main(String[] args) {
        Rack rack;
        // specify the dictionary
        String fileName = args.length > 0 ? args[0] : "sowpods.txt";
        try{
            // initiate the rack
           rack = new Rack(new AnagramDictionary(fileName), new ScoreTable());
        }
        // if the dictionary file is not found, then print the error and exit
        catch(FileNotFoundException e){
            System.out.println("ERROR: Dictionary file \"" + fileName + "\" does not exist.");
            System.out.println("Exiting program.");
            return;
        }
        // if the dictionary is illegal, then print the error and exit
        catch(IllegalDictionaryException e){
            System.out.println(e.getMessage());
            System.out.println("Exiting program.");
            return;
        }

        System.out.println("Type . to quit.");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Rack? ");
            // read the input
            String input = scanner.next();
            // if the input is ".", then exit
            if(".".equals(input)){
                break;
            }
            // get the sorted scrabble list
            List<Map.Entry<Integer,String>> res = rack.getSortedScrabble(input);
            System.out.println("We can make " + res.size() + " words from \"" + input + "\"");
            // if the size of scrabble list is larger than 0
            if(res.size() > 0){
                System.out.println("All of the words with their scores (sorted by score):");
                // then print the scrabble
                for(Map.Entry<Integer,String> entry : res){
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        }
    }

}
