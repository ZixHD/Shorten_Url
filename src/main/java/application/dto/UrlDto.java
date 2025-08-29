package application.dto;


import org.springframework.lang.NonNull;

public class UrlDto {
    @NonNull
    private Long id;

    @NonNull
    private String url;

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    @NonNull
    public String getUrl() {
        return url;
    }

    public void setUrl(@NonNull String url) {
        this.url = url;
    }
}
