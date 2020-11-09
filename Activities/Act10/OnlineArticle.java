/**
 * A class for holding OnlineArticles for sale. 
 *
 * @author Matthew Freestone
 * @version 11/1/2020 
 */
public class OnlineArticle extends OnlineTextItem {

   private int wordCount; 
   /**
    * Constructor for class. 
    * @param nameIn Name of the article. 
    * @param priceIn Price of the article. 
    */
   public OnlineArticle(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      wordCount = 0; 
   }


   /**
    * Sets the word count of the article.

    * @param wordCountIn word count of the article
    */
   public void setWordCount(int wordCountIn) {
      wordCount = wordCountIn;
   }
}