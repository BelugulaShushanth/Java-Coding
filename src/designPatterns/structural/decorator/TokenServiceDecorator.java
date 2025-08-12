package designPatterns.structural.decorator;

public abstract class TokenServiceDecorator implements TokenService {
    protected final TokenService wrappee;
    public TokenServiceDecorator(TokenService wrappee) {
        this.wrappee = wrappee;
    }
    @Override
    public String getToken() {
        return wrappee.getToken();
    }
}

class LoggingTokenService extends TokenServiceDecorator {
    public LoggingTokenService(TokenService wrappee) {
        super(wrappee);
    }
    @Override
    public String getToken() {
        System.out.println("[log] Fetching token");
        String token = wrappee.getToken();
        System.out.println("[log] Got token: " + token);
        return token;
    }
}

class CachingTokenService extends TokenServiceDecorator {
    private String cachedToken = null;

    public CachingTokenService(TokenService wrappee){
        super(wrappee);
    }

    @Override
    public String getToken() {
        if (cachedToken != null) {
            System.out.println("[cache] Returning cached token");
            return cachedToken;
        }
        System.out.println("[cache] No cached token, fetching...");
        cachedToken = wrappee.getToken();
        return cachedToken;
    }
}
