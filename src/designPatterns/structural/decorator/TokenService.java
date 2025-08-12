package designPatterns.structural.decorator;

public interface TokenService {
    String getToken();
}

class AwsTokenService implements TokenService {
    public String getToken() {
        return "AWS"+Math.random();
    }
}

class AzureTokenService implements TokenService {
    public String getToken() {
        return "AZURE"+Math.random();
    }
}

