public class StringUtils {
	
	public static String repC(char c, int count) {
		String result = "";
		while(count>0) {
			result+=c;
			count--;
		}
		return result;
	}
	
	public static String repStr(String s, int count) {
		String result = "";
		while(count>0) {
			result+=s;
			count--;
		}
		return result;
	}
	
	public static String space(int length) {
		return repC(' ', length);
	}
	
	public static String centerStr(String s, int width) {
		String result = "";
		boolean odd = (width%2==1);
		
		if(s!=null) {
			int pad = (width-s.length())/2;
			odd = (width%2)==1;
			
			result = space(pad)+s+space(pad+(odd?1:0));
		}
		
		return result;
	}
	
}

