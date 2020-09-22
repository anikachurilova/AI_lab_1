import java.io.*;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;

public class Main {



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
                    boolean allPatternsMatched = false;
//                    if(endOfDialog){
//                        break;
//                    }

                    for (Object emp : employeeList1) {
                        if (str.matches(parsePatternObject((JSONObject) emp).getKey())) {
                            Pair<String, String[]> result = parsePatternObject((JSONObject) emp);
                            int l = result.getRight().length;
                            //    String sentence="";
//                           for(int i=2;i<words.length;i++){
//                               sentence+=words[i]+" ";
//                           }
                            if(result.getRight()[((int) (Math.random() * l))].equals("Bye:(")){
                                endOfDialog = true;
                            }
                            System.out.println(result.getRight()[((int) (Math.random() * l))] + replacedString(str.toLowerCase()));
                            patternFound=true;
                            allPatternsMatched = true;
                            break;
                        }
                    }
                    if(!patternFound) {
                        for (Object emp : employeeList) {
                            //якщо є щось простеньке по шаблону
                            if (str.matches(parsePatternObject((JSONObject) emp).getKey())) {
                                Pair<String, String[]> result = parsePatternObject((JSONObject) emp);
                                int l = result.getRight().length;
                                System.out.println(result.getRight()[((int) (Math.random() * l))]);
                                patternFound = true;
                                allPatternsMatched = true;
                                if(result.getRight()[((int) (Math.random() * l))].equals("Bye:(")){
                                    endOfDialog = true;
                                }
                                break;
                            }
                        }
                        if(!patternFound){
                            //питання типу where why whose what
//                            String sentence="";
//                            for(int i=3;i<words.length;i++){
//                                sentence+=words[i]+" ";
//                            }

                            System.out.println("Do you wanna know "+ replacedString(str.toLowerCase()));
                            allPatternsMatched = true;
                        }
                    }
                    if (!allPatternsMatched){
                        System.out.println("Give me more information, please, I can't fully understand you :(");
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
        return str.replace("i","you").replace("you","i"). replace("myself","yourself").replace("yourself", "myself")
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

/*    private static String changePronouns(String word){
        switch (word){
            case "i":
                word="you";
                break;
            case "you":
                word="i";
                break;
            case "myself":
                word="yourself";
                break;
            case "yourself":
                word="myself";
                break;
            case "mine":
                word="yours";
                break;
            case "yours":
                word="mine";
                break;
            case "my":
                word="your";
                break;
            case "your":
                word="my";
                break;
            case "me":
                word="you";
                break;
            default:
                break;
        }
        return word;
    }
    */

//    private static Pair<String,String> parseUnknownPatternObject(JSONObject obj)
//    {
//        System.out.println("Obj is "+obj);
//        JSONObject patternObject = (JSONObject) obj.get("unknownPhrases");
//        System.out.println(patternObject);
//        String pattern = (String) patternObject.get("pattern");
//
//        String answer = (String) patternObject.get("answer");
//
//        Pair<String,String> p = new MutablePair<>(pattern,answer);
//        return p;
//    }


}