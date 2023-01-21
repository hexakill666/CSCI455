package main.assignment4;

import java.util.*;

/**
   A Rack of Scrabble tiles
 */
public class Rack {

   // anagram map
   private AnagramDictionary dictionary;
   // score map
   private ScoreTable scoreTable;

   /**
    * initiate the anagram map and the score map
    * @param dictionary
    * @param scoreTable
    */
   public Rack(AnagramDictionary dictionary, ScoreTable scoreTable){
      this.dictionary = dictionary;
      this.scoreTable = scoreTable;
   }

   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
      each subset is represented as a String that can have repeated characters in it.
      @author Claire Bono
    */
   public static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();

      // multiset is empty
      if (k == unique.length()) {
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k + 1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";
      // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {
         // for each of the subsets we found in the recursive call
         for (int i = 0; i < restCombos.size(); i++) {
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));
         }
         // append another instance of 'a' to the first part
         firstPart += unique.charAt(k);
      }
      
      return allCombos;
   }

   /**
    * preprocess the rack to fulfill the parameters of allSubsets method
    * @param rack
    * @return a map whose key is the unique letters and value is the count of unique letters
    */
   public Map.Entry<String, int[]> preProcessRack(String rack){
      StringBuilder sb = new StringBuilder();
      List<Integer> multi = new ArrayList<>();
      Map<Character, Integer> map = new HashMap<>();
      // go through the word to record unique letters and count the frequency of unique letters
      for(int a = 0; a < rack.length(); a++){
         if(map.containsKey(rack.charAt(a))){
            map.put(rack.charAt(a), map.get(rack.charAt(a)) + 1);
         }
         else{
            map.put(rack.charAt(a), 1);
         }
      }
      // prepare the key and value of return map
      for(Character c : map.keySet()){
         sb.append(c);
         multi.add(map.get(c));
      }
      // make a map whose key is the unique letters and value is the count of unique letters
      return new AbstractMap.SimpleEntry<>(sb.toString(), multi.stream().mapToInt(Integer::intValue).toArray());
   }

   /**
    * find all scrabble for a given rack
    * @param rack
    * @return a list of sorted scrabble
    */
   public List<Map.Entry<Integer,String>> getSortedScrabble(String rack){
      // preprocess the rack
      Map.Entry<String, int[]> rackPair = preProcessRack(rack);
      List<Map.Entry<Integer,String>> scrabbleList = new ArrayList<>();
      // find all subsets of the rack
      for(String subset : allSubsets(rackPair.getKey(), rackPair.getValue(), 0)){
         // get anagrams of the rack
         List<String> anagramList = dictionary.getAnagramsOf(subset);
         // add the anagram to scrabble list
         for(String word : anagramList){
            scrabbleList.add(new AbstractMap.SimpleEntry<>(scoreTable.getWordScore(word), word));
         }
      }
      // sort the scrabble list
      scrabbleList.sort((pair1, pair2) -> pair2.getKey().equals(pair1.getKey()) ? pair1.getValue().compareTo(pair2.getValue()) : pair2.getKey() - pair1.getKey());
      return scrabbleList;
   }

}
