import java.util.LinkedList;

class Post {
    private String post;
    private int like;
    public LinkedList<String> comments;

    Post(String post){
        this.post = post;
        like = 0;
        comments = new LinkedList<>();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public LinkedList<String> getComments() {
        return comments;
    }

    public void setComments(LinkedList<String> comments) {
        this.comments = comments;
    }
}
