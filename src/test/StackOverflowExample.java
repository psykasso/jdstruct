package test;

public class StackOverflowExample {

    public static void dummy() {
        dummy();
    }

    public static void main(String[] args) {
        dummy();
    }
}
