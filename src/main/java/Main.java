
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Main {

    public static void main(String[] args) throws IOException {
//         String str = "Hello my name is Valerie";
//         if(str.matches("Hello my name is (.*)")){
//             System.out.println("Hey");
//         }

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String str = reader.readLine();

            if(str.matches("Hello (.*)")){
                System.out.println("Hey");
            }else if(str.matches("My name is (.*)") || str.matches("I am (.*)")){
                System.out.println("Nice to meet you");
            }else if(str.matches("Bye (.*)") || str.matches("Goodbuy (.*)")){
                System.out.println("Bye:(");
                break;
            }
            // System.out.println(name);



            //First Employee
            JSONObject employeeDetails = new JSONObject();
            employeeDetails.put("firstName", "Lokesh");
            employeeDetails.put("lastName", "Gupta");
            employeeDetails.put("website", "howtodoinjava.com");

            JSONObject employeeObject = new JSONObject();
            employeeObject.put("employee", employeeDetails);

            //Second Employee
            JSONObject employeeDetails2 = new JSONObject();
            employeeDetails2.put("firstName", "Brian");
            employeeDetails2.put("lastName", "Schultz");
            employeeDetails2.put("website", "example.com");

            JSONObject employeeObject2 = new JSONObject();
            employeeObject2.put("employee", employeeDetails2);

            //Add employees to list
            JSONArray employeeList = new JSONArray();
            employeeList.add(employeeObject);
            employeeList.add(employeeObject2);

            //Write JSON file
//            try (FileWriter file = new FileWriter("employees.json")) {
//
//                file.write(employeeList.toJSONString());
//                file.flush();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }



    }
}