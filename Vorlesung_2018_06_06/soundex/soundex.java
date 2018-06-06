package soundex;

public class soundex {
	
	public static void main(String[] args) {
		System.out.print("Mittelmann: ");
		System.out.println(berechne("Mittelmann"));
		System.out.print("Mittelmann: ");
		System.out.println(berechne("Medaillen"));
	} 
	
	public static char[] berechne(String in) {
		//                      ABCDEFGHIJKLMNOPQRSTUVWXYZ
		String soundexValues = "01230120022455012623010202";
		
		in = in.toUpperCase();
		char[] rt = "A000".toCharArray();
		
		int rtP = 0;
		int inP = 0;
		
		char temp = '0';
		
		rt[rtP++] = in.charAt(inP++);
		
		while (inP < in.length() && rtP < rt.length) {
			temp = soundexValues.charAt((in.charAt(inP) - 'A'));
			
			if (temp != '0' && in.charAt(inP) != in.charAt(inP - 1)) {
				rt[rtP++] = temp;
			}
			
			inP ++;
		}
		
		return rt;
	}

}
