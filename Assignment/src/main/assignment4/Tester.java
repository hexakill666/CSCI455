package main.assignment4;

import java.util.Map;

public class Tester {

    public static void main(String[] args) {
        try {
            String input = "duotdeg";
            AnagramDictionary dictionary = new AnagramDictionary("src/main/assignment4/tinyDictionary.txt");
            Rack rack = new Rack(dictionary, new ScoreTable());
            Map.Entry<String, int[]> entry = rack.preProcessRack(input);
            System.out.println(Rack.allSubsets(entry.getKey(), entry.getValue(), 0));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
