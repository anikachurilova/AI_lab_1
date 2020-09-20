import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


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
        }



    }
}