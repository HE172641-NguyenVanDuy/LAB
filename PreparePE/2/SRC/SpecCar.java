
public class SpecCar extends Car{
    private int type;

    public SpecCar() {
    }

    public SpecCar(String maker, int price,int type) {
        super(maker, price);
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "," + type;
    }
    public  void setData() {
        setMaker("XZ" + getMaker());
        setPrice(getPrice() + 20);
    }
    public int getValue() {
        int inc = 0;
        if(type < 7)
            return super.getPrice() + 10;
        else 
        return super.getPrice() + 15;
    }
    
}
