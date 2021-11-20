package code_space.domain;

public class list_info {
    private int id;
    private int rid;
    private int cid;
    private String title;
    private String content;
    private String intro;
    private String rimage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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
    @Override
    public String toString() {
        return "list_info{" +
                "id=" + id +
                ", rid=" + rid +
                ", cid=" + cid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", intro='" + intro + '\'' +
                ", rimage='" + rimage + '\'' +
                '}';
    }


}
