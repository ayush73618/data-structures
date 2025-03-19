package com.company.string;

public class ClearDigitFromString {
    public static String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<s.length();i++){
            sb.append(s.charAt(i)+"");
            if(Character.isDigit(s.charAt(i))){
                if(sb.length()>1){
                    sb.setLength(sb.length()-2);
                }
                else{
                    sb.setLength(sb.length()-1);
                }

            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {

        //Remove Digit as well as leftSide of Digit ;

        String input = "a1b2c3";
        //output="";

        String input2 = "ab1c1d1";
        //output="a";
        //here first we will remove 1 and b then 1 and c and 1 and d

        String input3 = "aabbcc111111";
        //output = "";

        //here 1c then again 1c 1b 1b 1a 1a so empty string;

        System.out.println(clearDigits(input2));
    }
}
