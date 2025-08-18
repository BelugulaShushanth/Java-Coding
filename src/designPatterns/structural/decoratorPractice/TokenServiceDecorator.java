package designPatterns.structural.decoratorPractice;

public abstract class TokenServiceDecorator implements TokenService{
    protected TokenService tokenService;
    public TokenServiceDecorator(TokenService tokenService){
        this.tokenService = tokenService;
    }


    @Override
    public String getToken() {
        return tokenService.getToken();
    }
}

class LoggingService extends TokenServiceDecorator{

    public LoggingService(TokenService tokenService) {
        super(tokenService);
    }

    public String getToken(){
        System.out.println("Fetching token");
        String token = tokenService.getToken();
        System.out.printf("Token fetched: "+token);
        return token;
    }
}

class CachingService extends TokenServiceDecorator{

    private String cachedToken = null;

    public CachingService(TokenService tokenService) {
        super(tokenService);
    }

    public String getToken(){
        if(cachedToken != null){
            System.out.println("Fetching token from cache");
            return cachedToken;
        }
        System.out.println("Token is not present in cache creating new..");
        cachedToken = tokenService.getToken();
        return cachedToken;
    }
}