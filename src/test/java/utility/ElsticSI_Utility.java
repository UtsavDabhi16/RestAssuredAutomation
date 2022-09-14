package utility;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElsticSI_Utility {

    public static void main(String[] args) {

    }
    public boolean version(String s){

        Pattern pattern = Pattern.compile("^[0-9]{1}.[0-9]{1}.[0-9]{1}$");
        Matcher matcher = pattern.matcher(s);
        System.out.println("Macher value is :"+matcher.find());
        return matcher.find();
    }

    public boolean aimlEnabled(boolean value){
        if(value == true){
            return true;
        }else {
            return false;
        }
    }

    public boolean autoCorrectEnabled(boolean value){
        if(value == true){
            return true;
        }else {
            return false;
        }
    }

    public boolean curationsEnabled(boolean value){
        if(value == true){
            return true;
        }else {
            return false;
        }
    }

    public boolean semanticSearchEnabled(boolean value){
        if(value == true){
            return true;
        }else {
            return false;
        }
    }

    public boolean include_index(boolean value){
        if(value == true){
            return true;
        }else {
            return false;
        }
    }

    public boolean is_refresh(boolean value){
        if(value == true){
            return true;
        }else {
            return false;
        }
    }

    public boolean is_imported(boolean value){
        if(value == true){
            return true;
        }else {
            return false;
        }
    }

    public boolean is_nlp_support(boolean value){
        if(value == true){
            return true;
        }else {
            return false;
        }
    }


    public boolean getengineType(String s){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Precision Based Engine");
        list.add("Custom Relevance Engine");
        list.add("Ranking Based Engine V2");

        System.out.println("Contents of the array list: ");
        for (String element : list){
            System.out.println("aaaa :"+element.equals(s));
            if (s.equals(element)){
                System.out.println(element);
                return true;
            }
        }
        return false;
    }


    public boolean getProjectStatus(String s){

        ArrayList<String> list = new ArrayList<String>();
        list.add("PUBLISHED");
        list.add("FAILED");
        list.add("ARCHIVED");
        list.add("DISCONNECTED");
        list.add("DRAFT");
        list.add("REPUBLISH");
        list.add("PUBLISHING");

        System.out.println("Get Project Status is: ");
        for (String element : list){
            System.out.println("Project is :"+element.equals(s));
            if (s.equals(element)){
                System.out.println(element);
                return true;
            }
        }
        return false;
    }


    public boolean getSearchType(String s){

        ArrayList<String> list = new ArrayList<String>();
        list.add("SINGLE");
        list.add("META");

        System.out.println("Get Search Status is: ");
        for (String element : list){
            System.out.println("Project is :"+element.equals(s));
            if (s.equals(element)){
                System.out.println(element);
                return true;
            }
        }
        return false;
    }


    public boolean getSupportEngine(String s){

        ArrayList<String> list = new ArrayList<String>();
        list.add("ELASTIC");
        list.add("AWS");
        list.add("OPEN SEARCH");
        list.add("CHAOS");
        list.add("SOLR");

        System.out.println("Get Support Engine Status is: ");
        for (String element : list){
            System.out.println("Project is :"+element.equals(s));
            if (s.equals(element)){
                System.out.println(element);
                return true;
            }
        }
        return false;
    }

    public boolean getIndexMode(String s){

        ArrayList<String> list = new ArrayList<String>();
        list.add("BASIC");
        list.add("ADVANCED");
        list.add("PRECISION");

        System.out.println("Get Support Engine Status is: ");
        for (String element : list){
            System.out.println("Project is :"+element.equals(s));
            if (s.equals(element)){
                System.out.println(element);
                return true;
            }
        }
        return false;
    }



}
