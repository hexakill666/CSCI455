package main.assignment4;

import java.util.HashMap;
import java.util.Map;

/**
 * store the score for each letter
 */
public class ScoreTable {

    // score map
    private Map<Character, Integer> scoreTable;

    /**
     * initiate the score map
     */
    public ScoreTable(){
        scoreTable = new HashMap<Character, Integer>(){{
            put('a', 1);
            put('e', 1);
            put('i', 1);
            put('o', 1);
            put('u', 1);
            put('l', 1);
            put('n', 1);
            put('s', 1);
            put('t', 1);
            put('r', 1);
            put('d', 2);
            put('g', 2);
            put('b', 3);
            put('c', 3);
            put('m', 3);
            put('p', 3);
            put('f', 4);
            put('h', 4);
            put('v', 4);
            put('w', 4);
            put('y', 4);
            put('k', 5);
            put('j', 8);
            put('x', 8);
            put('q', 10);
            put('z', 10);
        }};
    }

    /**
     * calculate the total score for a given word
     * @param word
     * @return total score
     */
    public int getWordScore(String word){
        int score = 0;
        for(int a = 0; a < word.length(); a++){
            score += scoreTable.get(Character.toLowerCase(word.charAt(a)));
        }
        return score;
    }

}
