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
        for(int i=0;i<al.length;i++){
            try {
                list.add(ip.parseSingleItem1(al[i]));
            } catch (ItemParseException e) {
                e.printStackTrace();
            }}
    System.out.println(list.size());
    for(Item i:list) {
           if (i.getName().equalsIgnoreCase("milk")){
               milk++;

               if (i.getPrice() == 3.23)
                   p1++;
               else if (i.getPrice() == 1.23)
                   p2++;
               else
                   error++;
           }
    }
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
        String delims="##";
        List<Item> list=new ArrayList<>();
        Pattern pattern=Pattern.compile(delims,Pattern.CASE_INSENSITIVE);
        String[] al=pattern.split(originalFileText);
        for(int i=0;i<al.length;i++){
            try {
                list.add(ip.parseSingleItem1(al[i]));
            } catch (ItemParseException e) {
                e.printStackTrace();
            }}
        for(Item i:list) {
            if (i.getName().equalsIgnoreCase("bread")){
                bread++;

                if (i.getPrice() == 1.23)
                    p1++;
                else
                    error++;
            }
        }
        List<Integer> alist=new ArrayList<>();
        alist.add(bread);
        alist.add(p1);
        alist.add(error);
        return alist;
    }
    public List<Integer> numOfOccCookies(){
        Integer cookies=0;
        Integer p1=0;
        Integer error=0;
        ItemParser ip=new ItemParser();
        String delims="##";
        List<Item> list=new ArrayList<>();
        Pattern pattern=Pattern.compile(delims,Pattern.CASE_INSENSITIVE);
        String[] al=pattern.split(originalFileText);
        for(int i=0;i<al.length;i++){
            try {
                list.add(ip.parseSingleItem1(al[i]));
            } catch (ItemParseException e) {
                e.printStackTrace();
            }}
        for(Item i:list) {
            if (i.getName().equalsIgnoreCase("cookies")||i.getName().equalsIgnoreCase("Co0kieS")){
                cookies++;

                if (i.getPrice() == 2.25)
                    p1++;
                else
                    error++;
            }
        }
        List<Integer> alist=new ArrayList<>();
        alist.add(cookies);
        alist.add(p1);
        alist.add(error);
        return alist;
    }
    public List<Integer> numOfOccApples() {
        Integer app=0;
        Integer p1=0;
        Integer p2=0;
        Integer errormain=0;
        ItemParser ip=new ItemParser();
        List<Item> list=new ArrayList<>();
        String delims="##";
        Pattern pattern=Pattern.compile(delims,Pattern.CASE_INSENSITIVE);
        String[] al=pattern.split(originalFileText);
        for(int i=0;i<al.length;i++){
            try {
                list.add(ip.parseSingleItem1(al[i]));
            } catch (ItemParseException e) {
                e.printStackTrace();
            }}
        System.out.println(al.length);
        System.out.println(list.size());
        errormain=(al.length-list.size());
        for(Item i:list) {
            if (i.getName().equalsIgnoreCase("apples")){
                app++;
                if (i.getPrice() == 0.25)
                    p1++;
                else if (i.getPrice() == 0.23)
                    p2++;
            }
        }
        List<Integer> alist=new ArrayList<>();
        alist.add(app);
        alist.add(p1);
        alist.add(p2);
        alist.add(errormain);
        return alist;
    }


    @Override
    public String toString() {
        System.out.println(numOfOcc());
        System.out.println(numOfOccBread());
        return new StringBuilder()

                .append("name:    Milk \t\t seen: " + numOfOcc().get(0)+" times")
                .append("\n============= \t \t =============")
                .append("\nPrice: \t 3.23\t\t seen: " + numOfOcc().get(1)+" times")
                .append("\n-------------\t\t -------------")
                .append("\nPrice: \t 1.23\t\t seen: " + numOfOcc().get(2)+" time").append("\n")
                .append("\nname:   Bread \t\t seen: " + numOfOccBread().get(0)+" times")
                .append("\n============= \t \t =============")
                .append("\nPrice: \t 1.23\t\t seen: " + numOfOccBread().get(1)+" times")
                .append("\n-------------\t\t -------------").append("\n")
                .append("\nname: Cookies \t\t seen: " + numOfOccCookies().get(0)+" times")
                .append("\n============= \t \t =============")
                .append("\nPrice: \t 2.25\t\t seen: " + numOfOccCookies().get(1)+" times")
                .append("\n-------------\t\t -------------").append("\n")
                .append("\nname:  Apples \t\t seen: " + numOfOccApples().get(0)+" times")
                .append("\n============= \t \t =============")
                .append("\nPrice: \t 0.25\t\t seen: " + numOfOccApples().get(1)+" times")
                .append("\n-------------\t\t -------------")
                .append("\nPrice: \t 0.23\t\t seen: " + numOfOccApples().get(2)+" times").append("\n")
                .append("\nErrors         \t \t seen: " + numOfOccApples().get(3)+" times").append("\n")
                .toString();
    }
}
