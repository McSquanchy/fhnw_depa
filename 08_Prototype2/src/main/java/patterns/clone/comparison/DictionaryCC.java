package patterns.clone.comparison;

public class DictionaryCC {
    private String language;
    private final int size;
    private final String[] words;

    public DictionaryCC(String language, int size) {
        this.language = language;
        this.size = size;
        this.words = new String[size];
        for (int i = 0; i < size; i++)
            this.words[i] = "sample word " + i;
    }

    public DictionaryCC(DictionaryCC dict) {
        this.language = dict.language;
        this.size = dict.size;
        this.words = new String[size];
        System.arraycopy(dict.words, 0, this.words, 0, size);
    }

    @Override
    public DictionaryCC clone() {
       return new DictionaryCC(this);
    }

    public int getSize() {
        return size;
    }
}
