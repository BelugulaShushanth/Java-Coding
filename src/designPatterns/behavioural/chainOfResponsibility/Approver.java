package designPatterns.behavioural.chainOfResponsibility;

public abstract class Approver {
    protected Approver next;
    public void setNextApprover(Approver next){
        this.next = next;
    }
    public abstract void approve(double amount);
}
