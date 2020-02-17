import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the text:");
        String text = reader.readLine();
        System.out.println(getAnagram(text));
    }


    private static String getAnagram(String text)
    {
        String[] words = text.split(" ");
        StringBuilder anagrBuilder = new StringBuilder();

        for(String word: words)
        {
            anagrBuilder.append(makeAnagram(word));
            anagrBuilder.append(" ");
        }
        anagrBuilder.deleteCharAt(anagrBuilder.length() - 1);
        return anagrBuilder.toString();
    }

    private static String makeAnagram(String word)
    {
        char[] arrayword = word.toCharArray();
        StringBuilder anagrBuilder = new StringBuilder();

        for(char letter:arrayword)
        {
            if(Character.isLetter(letter))
            {
                anagrBuilder.append(letter);
            }
        }
        anagrBuilder.reverse();

        for(int i = 0; i < word.length(); i ++)
        {
            char letter = arrayword[i];
            if(!Character.isLetter(letter))
            {
                anagrBuilder.insert(i, letter);
            }
        }
        return anagrBuilder.toString();
    }
}
