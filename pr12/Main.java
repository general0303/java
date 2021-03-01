package org;

public class Main {

    public static void main(String[] args) {
        Writer writer = new Writer("A", "B");
        writer.init();
        writer.delete();
    }
}
