Actually bots can work, I quickly coded a simple bot that will tell me if a new listing has occurred and then it will print out the page for the new listing and then from there is you can find the redirect to the 3080 page. Not sure what types of counter-measures you guys have against simple bots like this but since you guys are using shopify perhaps there are existing plugins that help out with giveaways. Here's code if anyone interested. I still have my doubts as to if my solution would work  cause it seems far to easy to be valid. There has to be a catch. 


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;https://github.com/simar1998/ltt-storewatcher/blob/main/Main,java
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException {
        Elements previousElements = null;
        Elements tempElements;
        Document doc;
        int iterationNum = 10;
        int millisDelay = 3000;
        String lttSoreURI = "https://www.lttstore.com/collections/all";
        try {
            for (int i = 0; i < iterationNum; i++) {
                System.out.println("Iteration num " + i);
                doc = Jsoup.connect(lttSoreURI).get();
                tempElements = doc.getElementsByClass("ProductItem__Image");
                if (previousElements == null){
                    previousElements = tempElements;
                }
                if (tempElements.size() != previousElements.size()){
                    System.out.println("Difference Found!");
                    System.out.println("Printing Links perhaps there is a 3080 here");;
                    System.out.println(tempElements.toString());
                    System.exit(0);
                }
                else {
                    previousElements = tempElements;
                }
                Thread.sleep(millisDelay);
            }
            System.out.println("NO RTX card found here!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
