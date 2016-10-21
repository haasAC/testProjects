public class ArrayListTest <T extends Number> {
    T height;
    T width;
    public ArrayListTest (){
        height = null;
        width = null;
    }
    public ArrayListTest(T h, T w){
            height = h; width = w;
        }
    public T getHeight(){
        return height;
    }
    public void setHeight(T h){
        height = h;
    }
    public Number getArea()
    {
        return height.doubleValue() * width.doubleValue();
    }
    
    public static void main(String[] args){
        //ArrayListTest<double> = new ArrayListTest();
        //ArrayListTest(3,4);
        
        
        
    }
}