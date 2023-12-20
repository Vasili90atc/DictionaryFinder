package gr.atc.training.dictionaryFinder;

public class App 
{
    public static void main( String[] args )
    {
		Dictionary dict = new Dictionary();
		int count = dict.getWordCount(null, "ab", 0);
		count = dict.getWordCount(null, "is", 0);
		
		
		 count = dict.getWordCount("ab", null, 5);
		 count = dict.getWordCount("bc", null, 5);
		
		 count = dict.getWordCount(null, "qw", 7);
		 count = dict.getWordCount(null, "er", 7);
			
		 count = dict.getWordCount("ko", "yu", 3);
		 count = dict.getWordCount("ge", "io", 3);
				
		count = dict.getWordCount(null, "sd", 9);
		count = dict.getWordCount(null, "fd", 9);
					
		count = dict.getWordCount("ab", "gh", 0);
		count = dict.getWordCount("is", "jk", 0);
						
		count = dict.getWordCount(null, "kl", 8);
		count = dict.getWordCount(null, "zx", 8);
							
		count = dict.getWordCount("is", "cv", 6);
		count = dict.getWordCount("ab", "bn", 6);
								
		count = dict.getWordCount("ma", null, 10);
		count = dict.getWordCount("nd", null, 10);
									
		count = dict.getWordCount("re", "iu", 0);
		count = dict.getWordCount("pu", "rd", 0);
		
		System.out.println("Count: " + count);
	
}
}