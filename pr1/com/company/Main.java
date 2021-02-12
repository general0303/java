package com.company;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Consumer consumer = s -> {
            String s1 = "";
            int count = 0;
            for (String str : s) {
                String result = new StringBuilder(str).reverse().toString();
                result = result.replaceAll("(.)(?=.*\\1)", "");
                result = new StringBuilder(result).reverse().toString();
                if (result.length() > count){
                    s1 = str;
                    count = result.length();
                }
            }
            return s1;
        };
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i<n; i++){
            s[i]= scanner.next();
        }
        System.out.print(consumer.print(s));
    }
}
