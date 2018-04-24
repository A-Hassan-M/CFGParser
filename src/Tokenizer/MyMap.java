package Tokenizer;

import java.util.ArrayList;

public class MyMap implements Comparable<MyMap>{
	public String tag;
	public String value;
	public int start;
	public int end;
	public int prio;
	public MyMap() {
		super();
	}
	@Override
	public int compareTo(MyMap map) {
		int diff = this.start-map.start;
		if(diff == 0)
			return this.prio-map.prio;
		return diff;
	}
	@Override
	public String toString() {
		return "MyMap [tag=" + tag + ", value=" + value + ", start=" + start + ", end=" + end + ", prio=" + prio + "]";
	}
	
	
	
	
	
}
