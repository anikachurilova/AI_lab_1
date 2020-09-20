import java.io.*;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
public class Main {
//
//    public static void main(String[] args) throws IOException {
////         String str = "Hello my name is Valerie";
////         if(str.matches("Hello my name is (.*)")){
////             System.out.println("Hey");
////         }
//
//        BufferedReader reader =
//                new BufferedReader(new InputStreamReader(System.in));
//        while (true){
//            String str = reader.readLine();
//
//            if(str.matches("Hello (.*)")){
//                System.out.println("Hey");
//            }else if(str.matches("My name is (.*)") || str.matches("I am (.*)")){
//                System.out.println("Nice to meet you");
//            }else if(str.matches("Bye (.*)") || str.matches("Goodbuy (.*)")){
//                System.out.println("Bye:(");
//                break;
//            }
//            // System.out.println(name);
//        }
//
//
//
//    }


    public static void main(String[] args) throws Exception
    {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isFound = false;
        while (true){
            String str = reader.readLine();
            // getting phoneNumbers
            JSONArray ja = (JSONArray) jo.get("phoneNumbers");
            System.out.println("u");
            // iterating phoneNumbers
            Iterator itr2 = ja.iterator();

        while (itr2.hasNext()) {
            Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                if (pair.getValue().equals(str)) {
                    System.out.println("YYYYYYYYYYYYYYYEA");
                    break;
                }
            }
        }
//        }
//            if(str.matches("Hello (.*)")){
//                String firstName = (String) jo.get("firstName");
//                System.out.println(firstName);
//            }else if(str.matches("My name is (.*)") || str.matches("I am (.*)")){
//                System.out.println("Nice to meet you");
//            }else if(str.matches("Bye (.*)") || str.matches("Goodbuy (.*)")){
//                System.out.println("Bye:(");
//                break;
//            }
            // System.out.println(name);
        }
        // getting firstName and lastName
        //String firstName = (String) jo.get("firstName");
      //  String lastName = (String) jo.get("lastName");

       // System.out.println(firstName);
        //System.out.println(lastName);

        // getting age
        //long age = (long) jo.get("age");
        //System.out.println(age);

        // getting address
//        Map address = ((Map)jo.get("address"));
//
//        // iterating address Map
//        Iterator<Map.Entry> itr1 = address.entrySet().iterator();
//        while (itr1.hasNext()) {
//            Map.Entry pair = itr1.next();
//            System.out.println(pair.getKey() + " : " + pair.getValue());
//        }
//
//        // getting phoneNumbers
//        JSONArray ja = (JSONArray) jo.get("phoneNumbers");
//
//        // iterating phoneNumbers
//        Iterator itr2 = ja.iterator();
//
//        while (itr2.hasNext())
//        {
//            itr1 = ((Map) itr2.next()).entrySet().iterator();
//            while (itr1.hasNext()) {
//                Map.Entry pair = itr1.next();
//                System.out.println(pair.getKey() + " : " + pair.getValue());
//            }
//        }
    }
}