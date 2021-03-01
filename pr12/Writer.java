package org;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

@Component
public class Writer {

    private String a;
    private String b;

    Writer(String a, String b){
        this.a = a;
        this.b = b;
    }
    @PostConstruct
    public void init() {
        StringBuilder word = new StringBuilder();
        File f1 = new File("c://1212/" + a + ".txt");
        File f2 = new File("c://1212/" + b + ".txt");
        if (f1.exists()) {
            try {
                Scanner scan = new Scanner(f1);
                PrintWriter pw = new PrintWriter(f2);
                while (scan.hasNext()) {
                    word.append(scan.next());
                }
                scan.close();
                int hash = word.hashCode();
                pw.print(hash);
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                PrintWriter pw = new PrintWriter(f2);
                pw.print("null");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @PreDestroy
    public void delete(){
        File f1 = new File("c://1212/" + a + ".txt");
        f1.delete();
    }
}
