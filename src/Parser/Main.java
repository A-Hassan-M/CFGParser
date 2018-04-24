package Parser;

import Parser.NonTerminals.Node;
import Parser.NonTerminals.Source;
import Parser.NonTerminals.TerminalNode;
import Parser.NonTerminals.Token;
import Tokenizer.MyMap;
import Tokenizer.Regexer;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String data = "";
        ArrayList<Node> tokens;
        tokens = new ArrayList<>();
        try {
            FileReader file = new FileReader("output.txt");
            BufferedReader br = new BufferedReader(file);
            String line;

            while ((line = br.readLine()) != null) {
                String type = line.split(": ")[0];
                String value = line.split(": ")[1];
                tokens.add(new TerminalNode(type,value));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Source source = new Source();
        source.matches(tokens);
        System.out.println(source.getValue());
//        if (data != "") {
//            PrintStream out;
//            try {
//                out = new PrintStream(new FileOutputStream("output.txt"));
//                System.setOut(out);
//            } catch (FileNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            Regexer regexer = new Regexer(data);
//            ArrayList<MyMap> temp = regexer.Lexcial();
//            for (MyMap myMap : temp) {
//                if(myMap.value.contains("\n"))
//                {
//                    int template = myMap.value.indexOf("\n");
//                    myMap.value=myMap.value.substring(template+1);
//                }
//                System.out.println("< " + myMap.tag + ">:-  " + myMap.value + " -");
//            }
//        } else {
//            System.out.println("No data in file or error open file");
//        }
    }
}
