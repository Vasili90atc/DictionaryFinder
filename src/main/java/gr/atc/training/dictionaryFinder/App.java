package gr.atc.training.dictionaryFinder;

public class App 
{
    public static void main( String[] args )
    {
		Dictionary dict = new Dictionary();
		int count = dict.getWordCount(null, "a", 0);
		System.out.println("Count: " + count);
}
}
