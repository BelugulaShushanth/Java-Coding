package designPatterns.behavioural.chainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();
        manager.setNextApprover(director);
        director.setNextApprover(ceo);
        manager.approve(600);
        manager.approve(1200);
        manager.approve(14000);
    }
}
