import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
                    System.out.println(doc.toString());
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
