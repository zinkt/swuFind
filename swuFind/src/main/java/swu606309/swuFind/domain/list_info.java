package swu606309.swuFind.domain;

public class list_info {
    private int did;
    private int cid;
    private String title;
    private String content;
    private String intro;
    private String rimage;

    @Override
    public String toString() {
        return "list_info{" +
                "did=" + did +
                ", cid=" + cid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", intro='" + intro + '\'' +
                ", rimage='" + rimage + '\'' +
                '}';
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage;
    }
}
