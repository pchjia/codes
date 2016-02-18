import java.util.HashMap;

public class SpaceVector {
    private HashMap<Integer, Double> hm;

    public SpaceVector() {
        hm = new HashMap<Integer, Double>();
    }

    public int size() {
        return hm.size();
    }

    public void put(int j, double x) {
        hm.put(j, x);
    }

    public double get(int j) {
        if (hm.get(j) == null) {
            return 0.0;
        }
        return hm.get(j);
    }

    public double dot(double[] that) {
         double sum = 0.0;
         for (int i: hm.keySet()) {
             sum += this.get(i) * that[i];
         }
         return sum;
    }
}
