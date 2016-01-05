import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Created by mrcai on 2016/1/5.
 */
public  class readfile {
    Vector<Item> list;
    Item curItem=new Item();
    final int  LISTSIZE=128;
    public void readfile() {
        list = new Vector<Item>();
        list.clear();
    }

    public int readRequirement(String filePath) {
        try {

            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), "utf-8");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    //System.out.println(lineTxt);
                    OUTLIST(lineTxt);
                }
                read.close();
            } else {
                System.out.println("#找不到指定的文件#");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("#读取文件内容出错#");
            e.printStackTrace();
            return 2;
        }
        return 0;
    }
    public void  OUTLIST(String lineTxt){
        if(lineTxt.indexOf("[")!=-1){
            System.out.println("***商店购物清单***");
        }
        if(lineTxt.indexOf("{")!=-1){
            //curItem=new Item();
            //System.out.printf("名称");
            //System.out.println(lineTxt);
        }
        if(lineTxt.indexOf("unit:")!=-1){
            String[] strArray  = lineTxt.split("'");
            if(strArray[1]!=null)
                curItem.unit=strArray[1];
            //System.out.println(lineTxt);
        }
        if(lineTxt.indexOf("price:")!=-1){
            String[] strArray  = lineTxt.split(":");
                curItem.price=Double.parseDouble(strArray[1]);
            //curItem.price=1;
            //System.out.println(lineTxt);
        }
        if(lineTxt.indexOf("name:")!=-1){
            String[] strArray  = lineTxt.split("'");
            if(strArray[1]!=null)
            curItem.name=strArray[1];
            //System.out.println(lineTxt);
        }
        if(lineTxt.indexOf("},")!=-1) {
            //list.addElement(curItem);
            System.out.println(curItem.toString());
            //System.out.printf("\n");
            //System.out.println(lineTxt);
        }
        if(lineTxt.indexOf("]")!=-1){
//            for(int i=0;i<list.size();i++)
//            {
//                System.out.println(curItem.toString());
//            }
            System.out.println("----------------------");
            System.out.println("总计"+0+"（元）");
            System.out.println("**********************");
        }
    }
}