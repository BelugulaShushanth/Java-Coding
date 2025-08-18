package designPatterns.structural.decoratorPractice;

public class Main {
    public static void main(String[] args) {
        TokenService tokenService = new LoggingService(new CachingService(new AzureTokenService()));
        tokenService.getToken();
        tokenService.getToken();
    }
}
