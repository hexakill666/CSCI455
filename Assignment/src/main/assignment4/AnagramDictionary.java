package main.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */
public class AnagramDictionary {

   /**
    * Representation invariants:
    * 1. the key must be a sorted string
    * 2. there is no duplicate dictionary words in the value
    */

   // anagram map
   private Map<String, Set<String>> anagramMap;

   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
      @throws IllegalDictionaryException  if the dictionary has any duplicate words
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException, IllegalDictionaryException {
      anagramMap = new HashMap<>();
      // try to read the word through scanner
      try(Scanner scanner = new Scanner(new File(fileName))){
         // if it still has the word
         while(scanner.hasNext()){
            // read the word
            String word = scanner.next();
            // sort the word
            String sortedWord = word.chars().sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            // if the sorted word has already existed
            if(anagramMap.containsKey(sortedWord)){
               // if the word has already existed to its sorted word, it means the dictionary has duplicate words
               if(anagramMap.get(sortedWord).contains(word)){
                  throw new IllegalDictionaryException("ERROR: Illegal dictionary: dictionary file has a duplicate word: " + word);
               }
               // otherwise add the word to its sorted word
               anagramMap.get(sortedWord).add(word);
            }
            // otherwise add the sorted word as key and the word as value
            else{
               anagramMap.put(sortedWord, new HashSet<String>(){{
                  add(word);
               }});
            }
         }
      }
   }

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param string string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String string) {
      // sort the word
      String sortedRack = string.chars().sorted()
              .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
              .toString();
      // return the list of anagrams which belongs to the sorted word
      return new ArrayList<>(anagramMap.getOrDefault(sortedRack, new HashSet<>()));
   }

}
