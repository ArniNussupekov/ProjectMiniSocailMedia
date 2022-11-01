import java.util.LinkedList;
import java.util.Scanner;

class Post {
    private String post;
    private int like;
    private LinkedList<String> comments;

    Post(String post){
        this.post = post;
        like = 0;
        comments = new LinkedList<>();
    }

    public void makeComment(){
        Scanner sc = new Scanner(System.in);
        comments.add(sc.nextLine());
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

    @Override
    public String toString() {
       return "Post: " + post;
    }
}
