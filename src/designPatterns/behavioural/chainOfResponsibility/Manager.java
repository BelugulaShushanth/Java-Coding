package designPatterns.behavioural.chainOfResponsibility;

public class Manager extends Approver{


    @Override
    public void approve(double amount) {
        if(amount < 1000){
            System.out.println("Manager approved");
        }
        else {
            next.approve(amount);
        }
    }
}
