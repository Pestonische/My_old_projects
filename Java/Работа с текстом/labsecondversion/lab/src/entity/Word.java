package entity;

import java.util.Objects;

public class Word {
    private String word;
    private int frequency;
    private String tags;
    private String forms;
    private String canonicalTags;

    public Word(String word, int frequency, String tags, String forms, String canonicalTags) {
        this.word = word;
        this.frequency = frequency;
        this.tags = tags;
        this.forms = forms;
        this.canonicalTags = canonicalTags;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getForms() {
        return forms;
    }

    public void setForms(String forms) {
        this.forms = forms;
    }

    public String getCanonicalTags() {
        return canonicalTags;
    }

    public void setCanonicalTags(String canonicalTags) {
        this.canonicalTags = canonicalTags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return frequency == word1.frequency &&
                Objects.equals(word, word1.word) &&
                Objects.equals(tags, word1.tags) &&
                Objects.equals(forms, word1.forms) &&
                Objects.equals(canonicalTags, word1.canonicalTags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, frequency, tags, forms, canonicalTags);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Word{");
        sb.append("word='").append(word).append('\'');
        sb.append(", frequency=").append(frequency);
        sb.append(", tags='").append(tags).append('\'');
        sb.append(", forms='").append(forms).append('\'');
        sb.append(", canonicalTags='").append(canonicalTags).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
