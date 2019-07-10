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
       String delims="##";
        Pattern pattern=Pattern.compile(delims,Pattern.CASE_INSENSITIVE);
        String[] al=pattern.split(valueToParse);
        List<Item> itemList=new ArrayList<>();
        try {
            for(int i=0;i<al.length;i++){
                if(al[i].length()>50)
            itemList.add(parseSingleItem(al[i]));}
        } catch (ItemParseException e) {
            e.printStackTrace();
        }


        return itemList;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        String delims="[;]";
        Pattern pattern=Pattern.compile(delims,Pattern.CASE_INSENSITIVE);
        String singleItem1=singleItem.toLowerCase();
        String[] al=pattern.split(singleItem1);
        String nameItem="";
        String pri="";
        String type="";
        String date="";
        Pattern pname=Pattern.compile("^[@:\\^*%]");
        for(int i=0;i<al.length;i++){
            String all[]=al[i].split("[@:\\^*%]");
            if(all.length!=2)
                throw new io.zipcoder.utils.ItemParseException();
             if(all[0].equalsIgnoreCase("name")){
                nameItem=all[1];}
            else if(all[0].equalsIgnoreCase("price"))
               pri =all[1];
            else if(all[0].equalsIgnoreCase("type"))
               type =all[1];
            else if(all[0].equalsIgnoreCase("expiration"))
                date =all[1];
        }

        Double d= Double.valueOf(pri);
        Pattern pattern1 = Pattern.compile("[##]");
        Matcher matcher = pattern1.matcher(date);
        String number = matcher.replaceAll("");
        Item i=new Item(nameItem,d,type,number);

        return i;
    }
    public Item parseSingleItem1(String singleItem) throws ItemParseException {
        String delims="[;!\\^@%*]";
        Pattern pattern=Pattern.compile(delims,Pattern.CASE_INSENSITIVE);
        String singleItem1=singleItem.toLowerCase();
        String[] al=pattern.split(singleItem1);
        String nameItem="";
        String pri="";
        String type="";
        String date="";
        Pattern pname=Pattern.compile("^[@:\\^*%]");
        for(int i=0;i<al.length;i++){
            String all[]=al[i].split("[@:\\^*%]");
            if(all.length!=2)
                throw new io.zipcoder.utils.ItemParseException();
            if(all[0].equalsIgnoreCase("name")){
                nameItem=all[1];}
            else if(all[0].equalsIgnoreCase("price"))
                pri =all[1];
            else if(all[0].equalsIgnoreCase("type"))
                type =all[1];
            else if(all[0].equalsIgnoreCase("expiration"))
                date =all[1];
        }


        Double d= Double.valueOf(pri);
        Pattern pattern1 = Pattern.compile("[##]");
        Matcher matcher = pattern1.matcher(date);
        String number = matcher.replaceAll("");
        Item i=new Item(nameItem,d,type,number);

        return i;
    }

}
