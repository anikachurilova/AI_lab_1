import java.io.*;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;

public class Main {

    static String[] randomQuestions = new String[]{
            "Why are you asking that?",
            "Why do you think so?",
            "Are you sure?",
            "I don't think this is a good idea",
            "I'd like to know this info too!",
            "Do you really want to know that?",
            "Do you think I should know the answer?",
            "Sorry, haven't enough time to talk with you."};

    public static void main(String[] args) throws Exception
    {

        BufferedReader readerr = new BufferedReader(new InputStreamReader(System.in));
        boolean endOfDialog = false;
        while (!endOfDialog) {
            String str = readerr.readLine().toLowerCase();
            JSONParser jsonParser = new JSONParser();
            try (FileReader reader = new FileReader("JSONExample.json")) {
                try (FileReader reader1 = new FileReader("unknownPhrases.json")) {
                    Object obj = jsonParser.parse(reader);
                    Object obj1 = jsonParser.parse(reader1);

                    String[] words = str.split(" ");
                    JSONArray employeeList = (JSONArray) obj;
                    JSONArray employeeList1 = (JSONArray) obj1;

                    boolean patternFound= false;

                    //модальні і загальні питання
                    for (Object emp : employeeList1) {
                        if (str.matches(parsePatternObject((JSONObject) emp).getKey())) {
                            Pair<String, String[]> result = parsePatternObject((JSONObject) emp);
                            int l = result.getRight().length;

                            if(result.getRight()[((int) (Math.random() * l))].equals("Bye:(")){
                                endOfDialog = true;
                            }
                            String sentence="";
                           for(int i=2;i<words.length;i++){
                               sentence+=words[i]+" ";
                           }
                            System.out.println(result.getRight()[((int) (Math.random() * l))] + words[1]+replacedString(words[0])+ sentence);
                            patternFound=true;
                            break;
                        }
                    }
                    //якщо є шаблон звичайний
                    if(!patternFound) {
                        for (Object emp : employeeList) {
                            if (str.matches(parsePatternObject((JSONObject) emp).getKey())) {
                                Pair<String, String[]> result = parsePatternObject((JSONObject) emp);
                                int l = result.getRight().length;
                                System.out.println(result.getRight()[((int) (Math.random() * l))]);
                                patternFound = true;
                                if(result.getRight()[((int) (Math.random() * l))].equals("Bye:(")){
                                    endOfDialog = true;
                                }
                                break;
                            }
                        }
                    }

                    if(!patternFound){

                        System.out.println(randomQuestions[(int)(Math.random()*8)]);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    private static String replacedString(String str){
        return str.replace("?","").replace("i","you").replace("you","i"). replace("myself","yourself").replace("yourself", "myself")
                .replace("mine","yours").replace("yours","mine").replace("my","your").replace("your","my").replace("me","you");
    }

    private static Pair<String,String[]> parsePatternObject(JSONObject obj) throws ParseException {
        JSONObject patternObject = (JSONObject) obj.get("phrases");
        // System.out.println(patternObject);
        String pattern = (String) patternObject.get("pattern");


        Object ob  = patternObject.get("answer");
        String[] array = ob.toString().replace("[","").replace("]","").replace("\"","").split(",");

        //JSONArray answer = (JSONArray) patternObject.get("answer");
        Pair<String,String[]> p = new MutablePair<>(pattern,array);
        return p;
    }


}