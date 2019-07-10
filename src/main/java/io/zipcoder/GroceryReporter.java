package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }
public List<Integer> numOfOcc() {
        Integer milk=0;
        Integer p1=0;
        Integer p2=0;
        Integer error=0;
        ItemParser ip=new ItemParser();
    List<Item> list=new ArrayList<>();
    String delims="##";
    Pattern pattern=Pattern.compile(delims,Pattern.CASE_INSENSITIVE);
    String[] al=pattern.split(originalFileText);
    try {
        for(int i=0;i<al.length;i++){
            if(al[i].length()>51)
                list.add(ip.parseSingleItem(al[i]));}
    } catch (ItemParseException e) {
        e.printStackTrace();
    }
    System.out.println(list.size());


    for(Item i:list) {
           if (i.getName().equals("milk"))
               milk++;
           { if (i.getPrice() == 3.23)
                   p1++;
               else if (i.getPrice() == 1.23)
                   p2++;
               else
                   error++; }}
       List<Integer> alist=new ArrayList<>();
       alist.add(milk);
       alist.add(p1);
       alist.add(p2);
       alist.add(error);
       return alist;
}
    public List<Integer> numOfOccBread(){
        Integer bread=0;
        Integer p1=0;
        Integer error=0;
        ItemParser ip=new ItemParser();
        List<Item> list=ip.parseItemList(originalFileText);
        for(Item i:list) {
            if (i.getName().equals("bread"))
                bread++;
            { if (i.getPrice() == 1.23)
                p1++;
            else
                error++; }}
        List<Integer> alist=new ArrayList<>();
        alist.add(bread);
        alist.add(p1);
        alist.add(error);
        return alist;
    }
    @Override
    public String toString() {
        System.out.println(numOfOcc());
        System.out.println(numOfOccBread());
        return new StringBuilder()

                .append("\nname:    Milk        seen: " + numOfOcc().get(0)+" times")
                .append("\n=============        =============")
                .append("\nPrice:   3.23        seen: " + numOfOcc().get(1)+" times")
                .append("\n-------------        -------------")
                .append("\nPrice:   1.23        seen: " + numOfOcc().get(2)+" times")
                .toString();
    }
}
