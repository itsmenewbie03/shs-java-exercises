import java.util.Scanner;

/*
 * CLOCK CIPHER ENCODE/DECODE
 * 
 * AUTHOR: SALVADOR, 1 M. LIGAYAO
 * */
public class Main {

	public static void main(String[] args) {
	
		//declare variables
		String input;
		Scanner in = new Scanner(System.in);
		String output = "";
		System.out.print("Please enter text to encode: ");
		input = in.nextLine().toUpperCase();
		if(input.trim().length()>0) {
			char[] tae = input.toUpperCase().toCharArray();
			for(int i=0; i < tae.length; i++) {
				switch(tae[i]){
				case ' ':
				output += "00";
				output += ":";
				break;
				case 'A':
				output += "A";
				output += tae[i] = 'M';
				output += ":";
				break;
				
				case 'B':
				output += tae[i] = '1';
				output += ":";
				break;
				
				case 'C':
				output += tae[i] = '2';
				output += ":";
				break;
				
				case 'D':
				output += tae[i] = '3';
				output += ":";
				break;
				
				case 'E':
				output += tae[i] = '4';
				output += ":";
				break;
				
				case 'F':
				output += tae[i] = '5';
				output += ":";
				break;
				
				case 'G':
				output += tae[i] = '6';
				output += ":";
				break;
				
				case 'H':
				output += tae[i] = '7';
				output += ":";
				break;
				
				case 'I':
				output += tae[i] = '8';
				output += ":";
				break;
				
				case 'J':
				output += tae[i] = '9';
				output += ":";
				break;
				
				case 'K':
				output += "1";
				output += tae[i] = '0';
				output += ":";
				break;
				
				case 'L':
				output += "1";
				output += tae[i] = '1';
				output += ":";
				break;
				
				case 'M':
				output += "1";
				output += tae[i] = '2';
				output += ":";
				break;
				
				case 'N':
				output += "1";
				output += tae[i] = '3';
				output += ":";
				break;
				
				case 'O':
				output += "1";
				output += tae[i] = '4';
				output += ":";
				break;
				
				case 'P':
				output += "1";
				output += tae[i] = '5';
				output += ":";
				break;
							
				case 'Q':
				output += "1";
				output += tae[i] = '6';
				output += ":";
				break;
				
				case 'R':
				output += "1";
				output += tae[i] = '7';
				output += ":";
				break;
				
				case 'S':
				output += "1";
				output += tae[i] = '8';
				output += ":";
				break;
				
				case 'T':
				output += "1";
				output += tae[i] = '9';
				output += ":";
				break;
				
				case 'U':
				output += "2";
				output += tae[i] = '0';
				output += ":";
				break;
				
				case 'V':
				output += "2";
				output += tae[i] = '1';
				output += ":";
				break;
				
				case 'W':
				output += "2";
				output += tae[i] = '2';
				output += ":";
				break;
				
				case 'X':
				output += "2";
				output += tae[i] = '3';
				output += ":";
				break;
			
				case 'Y':
				output += "2";
				output += tae[i] = '4';
				output += ":";
				break;
				
				case 'Z':
				output += "P";
				output += tae[i] = 'M';
				output += ":";
				break;
			}	
		}
			System.out.println("Clock Ciphered Text: "+output);
		} else {
			System.out.println("Invalid input!");
			in.close();
		}
	}

}

