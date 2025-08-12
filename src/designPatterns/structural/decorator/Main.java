package designPatterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        // Basic AWS token service
        TokenService aws = new AwsTokenService();

        // Wrap with caching and logging decorators
        TokenService decorated = new LoggingTokenService(
                new CachingTokenService(aws)
        );

        // This call logs, caches, and returns token
        String token1 = decorated.getToken();
        String token2 = decorated.getToken(); // served from cache

    }
}
