package swu606309.swuFind.domain;

public class Publish_info {
    String title;
    String intro;
    String content;
    int cid;
    String rimage;
    @Override
    public String toString() {
        return "publish_info{" +
                "title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", content='" + content + '\'' +
                ", cid=" + cid +
                ", rimage='" + rimage + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage;
    }
}
