/**
 * Created by mrcai on 2016/1/5.
 */
public class Item {
    String name;
    String unit;
    double price;
    int number;
    Item(){
        name="NULL";
        unit = "NNNN";
        price = 0;
        number = 0;
    }
    Item(    String n,  String u, double p){
        name=n;
        unit = u;
        price = p;
        number = 1;
    }
    @Override
    public String toString() {
        return "名称："+name+",数量："+number+unit+",单价："+price+"（元），小计："+price*number+"（元）" ;
    }
}