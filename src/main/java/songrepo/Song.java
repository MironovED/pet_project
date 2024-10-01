package songrepo;

import java.io.Serializable;

public class Song implements Serializable {
    /** название песни */
    private String title;
    /** текст песни */
    private String text;
    /** ссылка на песню в яндекс музыка */
    private String yandexLink;

    public Song(String text, String chords, String yandexLink) {
        this.text = text;
        this.title = chords;
        this.yandexLink = yandexLink;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setChords(String chords) {
        this.title = chords;
    }

    public void setYandexLink(String yandexLink) {
        this.yandexLink = yandexLink;
    }

    public String getText() {
        return text;
    }

    public String getChords() {
        return title;
    }

    public String getYandexLink() {
        return yandexLink;
    }
}
