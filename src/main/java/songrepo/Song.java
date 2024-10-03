package songrepo;

import java.io.Serializable;

public class Song implements Serializable {
    /** исполнитель */
    private String Author;
    /** название песни */
    private String title;
    /** текст песни */
    private String text;
    /** ссылка на песню в яндекс музыка */
    private String yandexLink;

    public Song(String Author, String title, String text, String yandexLink) {
        this.Author = Author;
        this.title = title;
        this.text = text;
        this.yandexLink = yandexLink;
    }

    public String getAuthor() {
        return Author;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getYandexLink() {
        return yandexLink;
    }
}
