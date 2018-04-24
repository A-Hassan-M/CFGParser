package Tokenizer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexer {

	private ArrayList<Tag> regexs;
	private ArrayList<MyMap> maps;
	private String data;

	public Regexer(String data) {
		super();
		this.data = data;
		maps = new ArrayList<>();
		regexs = new ArrayList<>();
		try {
			FileReader file = new FileReader("text.txt");
			BufferedReader br = new BufferedReader(file);
			String line = "";
			String temp[];
			while ((line = br.readLine()) != null) {
				Tag t = new Tag();
				temp = line.split("@");
				t.regex = temp[1];
				t.tag = temp[0];
				regexs.add(t);
			}

			br.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
/*
	public ArrayList<MyMap> getTag(String data) {
		Data= data;
		// System.err.println(regexs.size());
		for (Tag regex : regexs) {
			Pattern p = Pattern.compile(regex.regex);
			Matcher m = p.matcher(data);
			// System.out.println("regex= "+regex.regex);
			while (m.find()) {
				// Scanner s = new Scanner(System.in);
				// s.next();
				MyMap map = new MyMap();
				String temp1 = data.substring(0, m.start());
				String temp2 = data.substring(m.end());
				String temp3 = "";

				map.tag = regex.tag;
				map.value = m.group();
				map.value = data2.substring(m.start(), m.end());
				map.start = m.start();
				map.end = m.end();

				for (int i = 0; i < map.value.length(); i++) {
					if (i < map.value.length() - 1 || (i == map.value.length() && map.value.charAt(i) != ' ')) {
						temp3 += "@";
					} else {
						temp3 += " ";
					}

				}

				if (regex.regex.equals("(\\n)")) {
					map.value = "End of Line";
					// temp3+=" ";
				}
				// System.err.println(m.group());
				data = temp1.concat(temp3 + temp2);
				// System.out.println(data);
				p = Pattern.compile(regex.regex);
				m = p.matcher(data);
				maps.add(map);
			}

		}
		Collections.sort(maps);
		checkTokens();
		ArrayList<String> temps = new ArrayList<>();
		Scanner s = new Scanner(data);
		while (s.hasNext()) {
			temps.add(s.next());
		}
		s.close();
		for (int i = 0; i < temps.size(); i++) {
			if (!temps.get(i).contains("@")) {
				System.out.println("Syntax Error near " + temps.get(i) + " " + data2.indexOf(temps.get(i)));

			}
		}
		return maps;
	}
*/

	public ArrayList<MyMap> Lexcial() {
		
		int priotry = 0;
		for (Tag regex : regexs) {
			Pattern p = Pattern.compile(regex.regex);
			Matcher m = p.matcher(data);
			while (m.find()) {
				MyMap map = new MyMap();
				map.tag = regex.tag;
				map.value = m.group();
				map.start = m.start();
				map.end = m.end();
				map.prio = priotry;
				if (regex.regex.equals("(\\n)")) {
					map.value = "End of Line";
				}
				maps.add(map);
			}
			priotry ++;
		}
		Collections.sort(maps);
		checkTokens();
		ArrayList<String> temps = new ArrayList<>();
		Scanner s = new Scanner(data);
		while (s.hasNext()) {
			temps.add(s.next());
		}
		s.close();
		findErrors();
		return maps;
	}

	private void findErrors() {
		int removedLength = 0;
		String data2 = data;
		for (MyMap map : maps) {
			String temp1 = data.substring(0,map.start-removedLength);
			String temp2 = data.substring(map.end-removedLength);
			removedLength += map.end - map.start-1;
			data =temp1+" "+temp2; 
		}
		Scanner s = new Scanner(data);
		String error;
		while (s.hasNext()) {
			error = s.next();
			System.out.println("Syntax Error near " + error + " " + data2.indexOf(error));
		}		
	}

	private void checkTokens() {

		MyMap validToken = maps.get(0);
		int i = 1;
		for (MyMap myMap : maps) {
			System.err.println(myMap.toString());
		}
		while (i < maps.size()) {
			if (maps.get(i).start < validToken.end /*&& maps.get(i).end <= validToken.end*/) {
				maps.remove(i);
			} else {
				validToken = maps.get(i);
				i++;
			}
		}
	}

}
