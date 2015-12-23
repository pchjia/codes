public class Counter{
    private String id = "";
    private int count = 0;

    // construction method
    Counter(String id){
        this.id = id;
        this.count = 0;
    };

    // increate count by 1
    public void increment(){
        this.count += 1;
    }

    // times that the object has been increated
    public int tally(){
        return this.count;
    };

    // parse Object to String
    public String toString(){
        return id + ": " + count;
    }
}
