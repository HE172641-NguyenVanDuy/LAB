
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MyCar implements ICar{

    @Override
    public int f1(List<Car> t) {
        int sum = 0;
        
        for (Car c : t) {
            sum+= c.getRate();
        }
        return sum/t.size();
    }

    @Override
    public void f2(List<Car> t) {
        int maxIndex = 0;
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < t.size(); i++) {
            if(t.get(i).getRate() > max) {
                max = t.get(i).getRate();
                maxIndex = i;
            }
            if(t.get(i).getRate() < min) {
                min  = t.get(i).getRate();
                minIndex = i;
            }
        }
        Collections.swap(t, maxIndex, minIndex);
    }

    @Override
    public void f3(List<Car> t) {
        Collections.sort(t, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                if(o1.getMaker().equals(o2.getMaker())) {
                    if(o1.getRate() > o2.getRate()) return -1;
                    else return 1;
                }
                else return o1.getMaker().compareTo(o2.getMaker());
            }
            
        });
    }
    
}
