package designPatterns.behavioural.chainOfResponsibility;

public class Director extends Approver{


    @Override
    public void approve(double amount) {
        if(amount < 10000){
            System.out.println("Director approved");
        }
        else {
            next.approve(amount);
        }
    }
}
