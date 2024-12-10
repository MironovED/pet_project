package songrepo;

import java.io.Serializable;

public class Song implements Serializable {
    /** исполнитель */
    private String author;
    /** название песни */
    private String title;
    /** текст песни */
    private String text;
    /** ссылка на песню в яндекс музыка */
    private String link;

    public Song(String Author, String title, String text, String yandexLink) {
        this.author = Author;
        this.title = title;
        this.text = text;
        this.link = yandexLink;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getLink() {
        return link;
    }

    public String setAuthor(String author) {
        return this.author = author;
    }

    public String setTitle(String title) {
        return this.title = title;
    }

    public String setText(String text) {
        return this.text = text;
    }

    public String setLink(String link) {
        return this.link = link;
    }

}
