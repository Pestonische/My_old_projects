package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TextVoc {
    private String nameText;
    private String text;
    private HashMap<String, Integer> freq = new HashMap<>();
    private ArrayList<Double> weight = new ArrayList<>();
    private double relev = 0;


    public TextVoc(String text, String name) {
        this.text = text;
        this.nameText = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNameText() {
        return nameText;
    }

    public void setNameText(String nameText) {
        this.nameText = nameText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextVoc text1 = (TextVoc) o;
        return Objects.equals(text, text1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TextVoc{");
        sb.append("text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void findFreqForText(ArrayList<Word> words){
        String[] textWords = text.split("[^A-Za-z]");
        for (int i = 0; i < textWords.length; i++){
            if (!textWords[i].equals("") && freq.containsKey(textWords[i])){
                freq.replace(textWords[i], freq.get(textWords[i]), freq.get(textWords[i]) + 1);
            } else {
                for (int j = 0; j < words.size(); j++){
                    if (words.get(j).getWord().equals(textWords[i])){
                        freq.put(textWords[i], 1);
                        break;
                    }
                }
            }
        }
    }

    public void findWeight() {
        int totalSum = 0;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            totalSum += entry.getValue();
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            weight.add((double) entry.getValue() / 7d);//(double) totalSum);
        }
    }

    public void findRelev() {
        for (int i = 0; i < weight.size(); i++) {
            relev += weight.get(i);
        }
    }

    public double getRelev() {
        return relev;
    }
}
