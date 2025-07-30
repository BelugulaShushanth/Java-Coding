package designPatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class CloneablePrototype implements Cloneable{

    private List<String> data;

    public CloneablePrototype(List<String> data){
        this.data = data;
    }

    @Override
    public CloneablePrototype clone() throws CloneNotSupportedException{
        return new CloneablePrototype(new ArrayList<>(this.data));
    }
}
