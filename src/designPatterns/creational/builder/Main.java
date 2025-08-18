package designPatterns.creational.builder;

public class Main {
    public static void main(String[] args) {
        User user = new User.UserBuilder(1, "Shushanth", "pwd123")
                .setPhoneNumber(123456789L)
                .build();

        System.out.println(user);
    }
}
