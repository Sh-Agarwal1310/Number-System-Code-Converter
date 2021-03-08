import java.io.*;
import java.util.*;

class Main{

    static Stack<Integer> stackPostFixEvaluation;

    public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please choose the convertion type : ");
        System.out.println("(Enter only the option str.lengther ) \n\n");
        System.out.println("1. Binary to Decimal");
        System.out.println("2. Binary to Octal");
        System.out.println("3. Binary to Hexadecimal");
        System.out.println("4. Decimal to Binary");
        System.out.println("5. Decimal to Octal");
        System.out.println("6. Decimal to Hexadecimal");
        System.out.println("7. Octal to Decimal");
        System.out.println("8. Octal to Binary");
        System.out.println("9. Hexadecimal to Decimal");
        System.out.println("10. Hexadecimal to Binary");
        System.out.println("11. Binary to Gray Code");
        System.out.println("12. Gray Code to Binary");
        System.out.println("13. Evaluate Postfix Expression");
        // System.out.println("_. Evaluate Prefix Expression");
        // System.out.println("_. Evaluate Infix Expression");
        System.out.println("14. Infix to Postfix");
        System.out.println("15. Prefix to Infix");
    

        int choice = input.nextInt();
        String inputString = input.nextLine();

        switch(choice){
            case 1:
                System.out.println(binaryToDecimal(inputString));
                break;
            case 2:
                System.out.println(binaryToOctal(inputString));
                break;
            case 3:
                System.out.println(binaryToHexadecimal(inputString));
                break;

            case 4:
                System.out.println(decimalToBinary(inputString));
                break;
            case 5:
                System.out.println(decimalToOctal(inputString));
                break;
            case 6:
                System.out.println(decimalToHexadecimal(inputString));
                break;

            case 7:
                System.out.println(octalToDecimal(inputString));
                break;
            case 8:
                System.out.println(octalToBinary(inputString));
                break;


            case 9:
                System.out.println(hexadecimalToDecimal(inputString));
                break;
            case 10:
                System.out.println(hexadecimalToBinary(inputString));
                break;


            case 11:
                binaryToGray(inputString);
                break;
            case 12:
                grayToBinary(inputString);
                break;

            case 13:
                postfixEvaluation(inputString);
                break;

            case 14:
                infixToPostfix(inputString);
                break;

            case 15:
                prefixToInfix(inputString);
                break; 
            default:
                System.out.println("Invalid choice");
                break;
        }
        
    }


    public static double binaryToDecimal(String binaryString){
        int index=0;
        for(; index < binaryString.length() ; index++){
            if(binaryString.charAt(index) == '.'){
                break;
            }
            
        }

        float answer = 0;
        int length = index;
        int j=0;

        // Conversion for values before decimal
        for(int i = length-1 ; i>=0; i--){
            answer += (binaryString.charAt(i)-48) * Math.pow(2 , j );
            j++;
        }

        // Conversion for values after decimal
        int k=1;
        for(int i = length+1 ; i < binaryString.length() ; i++){
            answer += (binaryString.charAt(i)-48) * (1/Math.pow(2 , k ));
            k++;
        }
        
        return answer;
    }

    public static String binaryToOctal(String binaryString){
        String str = Double.toString(binaryToDecimal(binaryString));
        return decimalToOctal(str);
    }


    public static String binaryToHexadecimal(String binaryString){
        String str = Double.toString(binaryToDecimal(binaryString));
        return decimalToHexadecimal(str);
    }



    public static String decimalToBinary(String decimalString){
        int number = Integer.parseInt(decimalString);
        String answerString = "";
        while (number > 0)  
        { 
            answerString  = Integer.toString(number % 2) + answerString; 
            number = number / 2;
        }
        return answerString;
    }

    public static String decimalToOctal(String decimalString){
        int number = Integer.parseInt(decimalString);
        String answerString = "";
        while (number > 0)  
        { 
            answerString  = Integer.toString(number % 8) + answerString; 
            number = number / 8;
        }
        return answerString;
    }


    public static String decimalToHexadecimal(String decimalString){

        int number = Integer.parseInt(decimalString);
        String answerString = "";
        while (number > 0)  
        { 
            int remainder = number % 16;
            String letter ="";
            if(remainder<=9)
            answerString  = Integer.toString(remainder) + answerString; 
            else{
                if(remainder ==10){
                    letter = "A";
                }
                else if(remainder ==11){
                    letter = "B";
                }
                else if(remainder ==12){
                    letter = "C";
                }
                else if(remainder ==13){
                    letter = "D";
                }
                else if(remainder ==14){
                    letter = "E";
                }
                else if(remainder ==15){
                    letter = "F";
                }
                answerString  = letter + answerString; 
            }
            
            number = number / 16;
        }
        return answerString;
    }

    public static double octalToDecimal(String binaryString){
        int index=0;
        for(; index < binaryString.length() ; index++){
            if(binaryString.charAt(index) == '.'){
                break;
            }
            
        }

        float answer = 0;
        int length = index;
        int j=0;

        // Conversion for values before decimal
        for(int i = length-1 ; i>=0; i--){
            answer += (binaryString.charAt(i)-48) * Math.pow(8 , j );
            j++;
        }

        // Conversion for values after decimal
        int k=1;
        for(int i = length+1 ; i < binaryString.length() ; i++){
            answer += (binaryString.charAt(i)-48) * (1/Math.pow(8 , k ));
            k++;
        }
        return answer;
    }
    
    public static String octalToBinary(String octalString){
        String str = Double.toString(octalToDecimal(octalString));
        return decimalToBinary(str);
    }
    
    public static double hexadecimalToDecimal(String hexadecimalString){
        int index=0;
        for(; index < hexadecimalString.length() ; index++){
            if(hexadecimalString.charAt(index) == '.'){
                break;
            }
            
        }

        float answer = 0;
        int length = index;
        int j=0;

        // Conversion for values before decimal
        for(int i = length-1 ; i>=0; i--){
            answer += (hexadecimalString.charAt(i)-48) * Math.pow(16 , j );
            j++;
        }

        // Conversion for values after decimal
        int k=1;
        for(int i = length+1 ; i < hexadecimalString.length() ; i++){
            answer += (hexadecimalString.charAt(i)-48) * (1/Math.pow(16 , k ));
            k++;
        }
        return answer;
    }


    public static String hexadecimalToBinary(String hexadecimalString){
        String str = Double.toString(hexadecimalToDecimal(hexadecimalString));
        return decimalToBinary(str);
    }

    public static void binaryToGray(String binaryString){
        int answer;
        // String grayAnswer = Character.toString(binaryString.charAt(0));
        String grayAnswer ="";
        grayAnswer += binaryString.charAt(0);

        for(int i=1; i<binaryString.length(); i++){
            answer = (binaryString.charAt(i)-48) ^ (binaryString.charAt(i-1)-48);
            grayAnswer += Integer.toString(answer);
        }

        System.out.println(grayAnswer);
    }


    public static void grayToBinary(String grayString){
        String binaryAnswer ="";
        binaryAnswer += grayString.charAt(0);

        for(int i=1; i < grayString.length(); i++){

            if(grayString.charAt(i) == '0'){
                binaryAnswer += binaryAnswer.charAt(i-1);
            }

            else{
                if(binaryAnswer.charAt(i-1) == '0'){
                    binaryAnswer += "1";
                }
                else{
                    binaryAnswer += "0";
                }
            }
        }

        System.out.println(binaryAnswer);
    }

    public static void postfixEvaluation(String str){
        stackPostFixEvaluation = new Stack<Integer>();
		
		for(int i=0; i < str.length(); i++){

			if(!(str.charAt(i) == '+') && !(str.charAt(i) == '-') && !(str.charAt(i) == '*') && !(str.charAt(i) == '/')){
				stackPostFixEvaluation.push(str.charAt(i)-48);
			} else {
				//operator input
				evaluateExpressionForPostfix(Character.toString(str.charAt(i)));
			}
		}
		System.out.print(stackPostFixEvaluation.peek());

	}

	public static void evaluateExpressionForPostfix(String ch){
		if(ch.equals("+")){
			int operator2 = stackPostFixEvaluation.pop();
			int operator1 = stackPostFixEvaluation.pop();
			stackPostFixEvaluation.push(operator1+operator2);
			return;
		}
		else if(ch.equals("-")){
			int operator2 = stackPostFixEvaluation.pop();
			int operator1 = stackPostFixEvaluation.pop();
			stackPostFixEvaluation.push(operator1-operator2);
			return;
		}
		else if(ch.equals("*")){
			int operator2 = stackPostFixEvaluation.pop();
			int operator1 = stackPostFixEvaluation.pop();
			stackPostFixEvaluation.push(operator1*operator2);
			return;
		}
		else{
			int operator2 = stackPostFixEvaluation.pop();
			int operator1 = stackPostFixEvaluation.pop();
			stackPostFixEvaluation.push(operator1/operator2);
			return;
		}
	}

    // public static void prefixEvaluation(String str){

    // }
    // public static void infixEvaluation(String str)
    // to be completed later

    public static void infixToPostfix( String str){
        Stack<Character> stk = new Stack<>();
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);


			if((ch >= 'A' && ch<='Z')||(ch>='a' && ch<='z')){
				System.out.print(ch);
			}

			else if(ch=='('){
				stk.push(ch);
			}

			else if(ch==')'){
				while(!stk.empty() && stk.peek()!='('){
					System.out.print(stk.pop());
				}
				stk.pop();
			}

			else{
				while(!stk.empty() && priorityInfixToPostfix(ch) <=  priorityInfixToPostfix(stk.peek())){
					System.out.print(stk.pop());
				}
				stk.push(ch);
			}
		}
		while(!stk.empty()){
			System.out.print(stk.pop());
		}

	}

	public static int priorityInfixToPostfix(char ch){
		if(ch=='^'){
			return 3;
		}
		else if(ch=='*' || ch=='/'){
			return 2;
		}
		else if(ch=='+' || ch=='-'){
			return 1;
		}
		else{
			return 0;
		}
	}

    public static void prefixToInfix( String str){
        Stack<String> stk = new Stack<>();
	
		if(str.charAt(str.length()-1) >= 'A' && str.charAt(str.length()-1)<='Z'){
			stk.push(Character.toString(str.charAt(str.length()-1)));
		for(int i= str.length()-2 ; i>=0 ; i--){
			if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
				stk.push(Character.toString(str.charAt(i)));
			}
			else if(stk.size()>=2){
				String operand1 = stk.pop();
				String operand2 = stk.pop();
				String exp = makeExpressionPrefixToInfix(operand1 , Character.toString(str.charAt(i)), operand2);
				stk.push(exp);
			}
		}
		}
		System.out.println(stk.peek());
	}

	public static String makeExpressionPrefixToInfix(String operand1, String operater , String operand2 ){
		String s = "("+operand1+operater+operand2+")";
		return(s);
	}
    

}