package com.company.string;

public class RemoveAllOccurenceOfASubstring {

    public String removeOccurrencesStackBasedApproach(String s, String part) {
        char[] input = s.toCharArray();
        char[] target = part.toCharArray();
        char[] resultStack = new char[input.length];
        int stackSize = 0, targetLength = target.length;
        char targetEndChar = target[targetLength - 1];

        for (char currentChar : input) {
            resultStack[stackSize++] = currentChar;

            if (currentChar == targetEndChar && stackSize >= targetLength) {
                int i = stackSize - 1, j = targetLength - 1;

                while (j >= 0 && resultStack[i] == target[j]) {
                    i--;
                    j--;
                }

                if (j < 0) {
                    stackSize = i + 1;
                }
            }
        }
        return new String(resultStack, 0, stackSize);
    }
    public static String removeOccurrences(String s, String part) {

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<s.length();i++){
            sb.append(s.charAt(i)+"");
            if(sb.length()>=part.length() && sb.substring(sb.length()-part.length()).equals(part)){
                sb.setLength(sb.length()-part.length());
            }

        }


        return sb.toString();
    }
    public static void main(String[] args) {

        //input 1 ="daabcbaabcbc"
        //input 2 ="abc"
        //output  ="dab"

    }
}
