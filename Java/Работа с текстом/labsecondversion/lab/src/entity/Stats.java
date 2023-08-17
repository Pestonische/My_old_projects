package entity;

import java.util.Objects;

public class Stats {
    private String tag;
    private Integer freq;

    public Stats(String word, Integer freq) {
        this.tag = word;
        this.freq = freq;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return Objects.equals(tag, stats.tag) &&
                Objects.equals(freq, stats.freq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, freq);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Stats{");
        sb.append("tag='").append(tag).append('\'');
        sb.append(", freq=").append(freq);
        sb.append('}');
        return sb.toString();
    }
}
