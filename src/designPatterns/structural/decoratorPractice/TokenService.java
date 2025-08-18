package designPatterns.structural.decoratorPractice;

public interface TokenService {
    String getToken();
}

class AWSTokenService implements TokenService{

    @Override
    public String getToken() {
        return "AWS"+Math.random();
    }
}

class AzureTokenService implements TokenService{

    @Override
    public String getToken() {
        return "Azure"+Math.random();
    }
}
