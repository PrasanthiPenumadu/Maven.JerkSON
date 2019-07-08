package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {
       String delims="[##]";
        String[] al=valueToParse.split(delims);

        String pS="nAme:";
       Integer j=0;
        //String x=valueToParse.replace("##", ",");
        Pattern pattern=Pattern.compile(pS);
        Matcher matcher=pattern.matcher(valueToParse);
        for(int i=0;matcher.find();i++)
            j=matcher.end();
            System.out.println(matcher.end());
            List<String> list=Arrays.asList(al);
           // List<Item> alist= new ArrayList<Item>(list) ;

        return null;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        String delims="[;]";
       // String[] al=singleItem.split(delims);
        Pattern pattern=Pattern.compile(delims,Pattern.CASE_INSENSITIVE);
        String singleItem1=singleItem.toLowerCase();
        String[] al=pattern.split(singleItem1);
//        for(String x:al){
//           // if(x.())
//            String pS="nAme:";
//            Integer j=0;
//            Pattern pattern1=Pattern.compile(pS);
//            Matcher matcher=pattern1.matcher(x);
//            for(int i=0;matcher.find();i++)
//                j=matcher.end();
//            System.out.println(matcher.end());
//        }
        Pattern p=Pattern.compile("\\d+");

//        Pattern pname=Pattern.compile("\\naMe:+");
//        String name=pname.matcher(al[0]).group(1);
//        System.out.println(name);
String x=al[0].replace("name:", "");
        Double d= Double.valueOf((al[1]).replaceAll("\\D+",""));
//Double d= Double.valueOf(p.matcher(al[1]).group());
        System.out.println(d/100);
String y=al[2].replace("type:", "");
String z=al[3].replace("##", "");
String z1=z.replace("expiration:", "");
//        System.out.println(x+" "+al[1]+" "+y+" "+z);
//        String res=(x+" "+ p.matcher(al[1]).group()+" "+y+" "+ p.matcher(al[3]).group());
        Item i=new Item(x,d/100,y,z1);

        return i;
    }
}
