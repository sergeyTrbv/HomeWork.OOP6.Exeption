public class Main {
    public static void main(String[] args) {


        boolean success = Data.validate("login", "parol", "parol");

        if (success) {
            System.out.println("Данные корректны");
        } else {
            System.out.println("Данные не корректны");
        }
    }
}