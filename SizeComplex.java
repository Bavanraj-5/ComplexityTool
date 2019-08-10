
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Pattern;


public class SizeComplex {
	
	public void CheckSize() {
		String fileLocation;
        String words;
        String line = null;

        String[] cs1keywords = {"+", "-", "*", "/", "%", "++", "--",
        						"==", "!=", ">", "<", ">=", "<=", 
        						"&&", "||", "!", 
        						"|", "^", "~", "<<", ">>", ">>>", "<<<", 
        						",", "->", ".", "::",
        						"+=", "-=", "*=", "/=", "=", ">>>=", "|=","&=", "%=", "<<=", ">>=", "^=",
        						"void", "double", "int", "float", "string","printf", "println", "cout", "cin", "if", "for", "while", "do while", "switch", "case",
        						"endl", "\n"," "};
		String[] cs2keywords = {"new", "delete", "throw", "throws"};
		int complexity = 0;
		int totalcomplexity = 0;

        try {
        	
        	Pattern pattern = Pattern.compile("\"([^\"]*)\"");
            fileLocation = "D:\\Eclipse Workspace\\TransportService\\src\\transportservice\\Dress_delivery.java";
            FileReader filereader = new FileReader(fileLocation);
            BufferedReader bufferedreader = new BufferedReader(filereader);
            line = bufferedreader.readLine();
            while (line != null) {
                StringTokenizer stringToken = new StringTokenizer(line);
                complexity = 0;
                
                while (stringToken.hasMoreTokens()) {
                    words = stringToken.nextToken();
                    
                    for (int i = 0; i < cs1keywords.length; i++) {
                        if (cs1keywords[i].equals("//")) {
                            break;
                        } else {
                            if (cs1keywords[i].equals(words)) {
                                complexity++;
                            }
                        }
                    }
                    for (int i = 0; i < cs2keywords.length; i++) {
                        if (cs2keywords[i].equals("//")) {
                            break;
                        } else {
                            if (cs2keywords[i].equals(words)) {
                                complexity = complexity + 2;
                            }
                        }
                    }
                    
                }
                totalcomplexity = totalcomplexity + complexity;
                System.out.println("Line Complexity is: " + complexity);
                line = bufferedreader.readLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Total Size Complexity is: " + totalcomplexity);
	}
	
    public static void main(String ss[]) {
    	SizeComplex CS = new SizeComplex();
    	//RecursionComplex RC = new RecursionComplex();
        CS.CheckSize();
        //RC.CheckRecursion();
    }

}
