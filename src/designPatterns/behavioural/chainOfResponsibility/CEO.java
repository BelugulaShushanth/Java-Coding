package designPatterns.behavioural.chainOfResponsibility;

public class CEO extends Approver{


    @Override
    public void approve(double amount) {
        System.out.println("CEO approved");
    }
}
