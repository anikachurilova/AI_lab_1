import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception
    {

        BufferedReader readerr = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String str = readerr.readLine();

            JSONParser jsonParser = new JSONParser();
            try (FileReader reader = new FileReader("JSONExample.json"))
            {
                Object obj = jsonParser.parse(reader);

                JSONArray employeeList = (JSONArray) obj;
                for(Object emp : employeeList){
                    if(str.matches(parsePatternObject( (JSONObject) emp ).getKey())){
                        System.out.println(parsePatternObject( (JSONObject) emp ).getValue());
                        break;
                  }//  else {
//                       System.out.println("Do you want me to " + str);
//                    }

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


    private static Pair<String,String> parsePatternObject(JSONObject obj)
    {
        JSONObject patternObject = (JSONObject) obj.get("phrases");

        String pattern = (String) patternObject.get("pattern");

        String answer = (String) patternObject.get("answer");

        Pair<String,String> p = new MutablePair<>(pattern,answer);
        return p;

    }


}