package com.example.pars;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;



import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@SpringBootApplication
public class ParsApplication {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        SpringApplication.run(ParsApplication.class, args);

        String url = "http://www.cbr.ru/scripts/XML_daily.asp";


        Document doc= (Document) Jsoup.connect(url).get();

        Elements norv1=doc.select("#R01535").select("Value");
        Elements norv2=doc.select("#R01535").select("Nominal");
        String norveg1= norv1.text();
        String norveg2=norv2.text();

        char[] ch=norveg1.toCharArray();

        for (int i=0;i<norveg1.length();i++){
            if(ch[i]==','){
                ch[i]='.';
            }
        }

        Double norv=Double.valueOf(String.valueOf(ch));

        Integer rubl=Integer.valueOf(norveg2);

        System.out.printf("1 рубль = %s норвежских крон \n",norv/rubl);



        Elements venger1=doc.select("#R01135").select("Value");
        Elements venger2=doc.select("#R01135").select("Nominal");
        String ven1= venger1.text();
        String ven2=venger2.text();



        char[] chars=ven1.toCharArray();

        for (int i=0;i<ven1.length();i++){
            if(chars[i]==','){
                chars[i]='.';
            }
        }


        Double veng=Double.valueOf(String.valueOf(chars));

        Integer rubls=Integer.valueOf(ven2);

        System.out.printf("1 рубль = %s венгерских форитов \n",veng/rubls);

        System.out.printf("1 норвежский крон = %s венгерских форитов \n",(norv/rubl)/(veng/rubls));











        




    }

}
