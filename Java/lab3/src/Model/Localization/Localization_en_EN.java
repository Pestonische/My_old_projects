package Model.Localization;

import java.util.ListResourceBundle;

public class Localization_en_EN extends ListResourceBundle{

    private static final String[][] contents =
            {
                    {"GivenTextIsEmpty","Given text is empty"},
                    {"MaxLength", "Max length"},
                    {"ErrorWithReadingFile", "Error with reading file!!!"},
                    {"FileIsEmpty", "File is empty!!!"},
                    {"Sentences", "Sentences:"},
                    {"Words", "Words(first sentence):"},
                    {"Punctuation", "Punctuation marks(first sentence):"},
                    {"AllText", "All text:"},
                    {"MyTask", "My task"},
                    {"WordsInSentence", "1.For each word from the given list, find " +
                            "how many times does it occur in each sentence"},
                    {"sortWords", "2.display words with a total number of occurrences"},
                    {"NullArrayParts", "No sentences and parts of code in text!"},
                    {"NoSentences", "No sentences in text!"}
            };

    public Object[][] getContents() {
        return contents;
    }
}