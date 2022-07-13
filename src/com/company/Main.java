package com.company;

import com.company.model.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static <Gson> void main(String[] args) {
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            URL url=new URL("https://cbu.uz/uz/arkhiv-kursov-valyut/json/");
            URLConnection connection=url.openConnection();
            BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Type type=new TypeToken<ArrayList<Currency>>(){}.getType();
            ArrayList<Currency> list=gson.fromJson(reader,type);
            for (Currency currency : list) {
                System.out.println(currency);
            }
            Scanner scanner=new Scanner(System.in);
            while (true){
                System.out.println("0=>Exit 1=>DollarConvert  2=>RublConvert   3=>EvroConvert");
                int i=scanner.nextInt();
                switch (i){
                    case 0:
                        break;
                    case 1:

                        System.out.println("1=>Dollardan sumga  2=>sumdan Dollarga");
                        int num=scanner.nextInt();
                        switch (num){
                            case 1:
                                for (Currency currency : list) {
                                    if (currency.getId()==69){
                                        System.out.print("Dollar kiriting: ");
                                        double a=scanner.nextDouble();
                                        System.out.println(a+currency.getCcy()+"="+a*Double.parseDouble(currency.getRate())+" sumga");
                                    }
                                }
                                break;
                            case 2:
                                for (Currency currency : list) {
                                    if (currency.getId()==69){
                                        System.out.print("summani kiriting: ");
                                        double a=scanner.nextDouble();
                                        System.out.println(a+"sum = "+a/Double.parseDouble(currency.getRate())+currency.getCcy());
                                    }
                                }break;
                        }
                        break;

                    case 2:
                        System.out.println("1=>Rubldan sumga  2=>sumdan Rublga");
                        num=scanner.nextInt();
                        switch (num) {
                            case 1:
                                for (Currency currency : list) {
                                    if (currency.getId() == 57) {
                                        System.out.print("Rubl kiriting: ");
                                        double a = scanner.nextDouble();
                                        System.out.println(a + currency.getCcy() + "=" + a * Double.parseDouble(currency.getRate()) + " sumga");
                                    }
                                }
                                break;
                            case 2:
                                for (Currency currency : list) {
                                    if (currency.getId() == 57) {
                                        System.out.print("summani kiriting: ");
                                        double a = scanner.nextDouble();
                                        System.out.println(a + "sum = " + a / Double.parseDouble(currency.getRate()) + currency.getCcy());
                                    }
                                }
                                break;
                        }
                        break;

                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
