package prepare_java;

import java.util.Scanner;

class Solution{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}

class MyRegex {
    String address = "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";
    String pattern = String.format("(%1$s\\.){3}%1$s", address);
}
