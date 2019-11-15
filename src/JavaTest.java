public class JavaTest {
	
	
	
	public static double calculate(String sum) {
		double answer = 0;
		
		String[] result = sum.split("\\s");
		
		while (result.length > 3) {	
			String[] tempArray;
			
			if (sum.contains("(")) {
				int i=0;
				for (String s: result) {
					if (s.equalsIgnoreCase("(")) {
						tempArray = new String[3];
						tempArray[0] = result[i+1];
						tempArray[1] = result[i+2];
						tempArray[2] = result[i+3];
						
						String subEq = "( " + tempArray[0] + " " + tempArray[1] + " " + tempArray[2] + " )";
						double aNumber = calSubEquation(tempArray);
						sum = sum.replace(subEq, "" + aNumber);	
						
						break;
					}
					i++;
				}
			}
			else if (sum.contains("*") || sum.contains("/")) {					
				
				int i=0;
				for (String s: result) {
					if (s.equalsIgnoreCase("*") || s.equalsIgnoreCase("/")) {
						tempArray = new String[3];
						tempArray[0] = result[i-1];
						tempArray[1] = s;
						tempArray[2] = result[i+1];
						
						String subEq = tempArray[0] + " " + tempArray[1] + " " + tempArray[2];
						double aNumber = calSubEquation(tempArray);
						sum = sum.replace(subEq, "" + aNumber);	
						
						break;
					}
					i++;
				}
			}
			else {
				
				int i=0;
				for (String s: result) {
					if (s.equalsIgnoreCase("+") || s.equalsIgnoreCase("-")) {
						tempArray = new String[3];
						tempArray[0] = result[i-1];
						tempArray[1] = s;
						tempArray[2] = result[i+1];
						
						String subEq = tempArray[0] + " " + tempArray[1] + " " + tempArray[2];
						double aNumber = calSubEquation(result);
						sum = sum.replace(subEq, "" + aNumber);	
						break;
					}
					i++;
				}
				
			}
			
			result = sum.split("\\s");
		}
		
		answer = calSubEquation(result);
		
		return answer;
	}
	
	private static double calSubEquation(String[] result) {
		double answer = 0;
		
		double firstNum = 0;
		double secondNum = 0;
		String operator = null;
		
		firstNum = Double.parseDouble(result[0]);
		operator = result[1];
		secondNum = Double.parseDouble(result[2]);
		
		if (operator.equals("+")) {
			answer = firstNum + secondNum;
		}
		else if (operator.equals("-")) {
			answer = firstNum - secondNum;
		}
		else if (operator.equals("*")) {
			answer = firstNum * secondNum;
		}
		else if (operator.equals("/")) {
			answer = firstNum / secondNum;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {  		
		System.out.println("1.	1 + 1 = " + calculate("1 + 1"));
		System.out.println("2.	2 * 2 = " + calculate("2 * 2"));
		System.out.println("3.	1 + 2 + 3 = " + calculate("1 + 2 + 3"));
		System.out.println("4.	6 / 2 = " + calculate("6 / 2"));
		System.out.println("5.	11 + 23 = " + calculate("11 + 23"));
		System.out.println("6.	11.1 + 23 = " + calculate("11.1 + 23"));
		System.out.println("7.	1 + 1 * 3 = " + calculate("1 + 1 * 3"));
		System.out.println("8.      ( 11.5 + 15.4 ) + 10.1 = " + calculate("( 11.5 + 15.4 ) + 10.1"));
		System.out.println("9.	23 - ( 29.3 - 12.5 ) = " + calculate("23 - ( 29.3 - 12.5 )"));
    }  
}
