package Parser;

import Parser.NonTerminals.Node;
import Parser.NonTerminals.Source;
import Parser.NonTerminals.TerminalNode;
import Tokenizer.MyMap;
import Tokenizer.Regexer;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String data = "";
        try {
            FileReader file = new FileReader("testcase.txt");
            BufferedReader br = new BufferedReader(file);
            String line = "";

            while ((line = br.readLine()) != null) {
                data += line + "\n";
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data != "") {
            PrintStream out;
            try {
                out = new PrintStream(new FileOutputStream("output.txt"));
                System.setOut(out);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Regexer regexer = new Regexer(data);
            ArrayList<MyMap> temp = regexer.Lexcial();
            for (MyMap myMap : temp) {
                if(myMap.value.contains("\n"))
                {
                    int template = myMap.value.indexOf("\n");
                    myMap.value=myMap.value.substring(template+1);
                }
                System.out.println("< " + myMap.tag + " >: " + myMap.value);
            }
        } else {
            System.out.println("No data in file or error open file");
        }

        try {
            PrintStream out = new PrintStream(new FileOutputStream("CompiledCode.txt"));
            System.setOut(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Node> tokens;
        tokens = new ArrayList<>();
        try {
            FileReader file = new FileReader("output.txt");
            BufferedReader br = new BufferedReader(file);
            String line;

            while ((line = br.readLine()) != null) {
                String type = line.split(": ")[0];
                String value = line.split(": ")[1];
                if(type.equals("< EOL >"))continue;
                tokens.add(new TerminalNode(type,value));
            }
            tokens.add(new TerminalNode("< EOF >",""));
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Source source = new Source();
        try {
            source.errorsFile = new PrintWriter("errors.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(source.matches(tokens, false) == 0){
            System.out.println("Syntax error see the errors file for more info");
        }else {
            try {
                System.out.println(source.getValue());
            }catch (Exception e){
                System.out.println("Syntax error");
            }
        }
        source.errorsFile.close();
    }
}
