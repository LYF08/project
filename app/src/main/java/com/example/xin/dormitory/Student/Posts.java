package com.example.xin.dormitory.Student;

public class Posts {
    private int imageId;
    private String publisherName;
    private String publisherID;
    private String postDate;
    private String postTitle;
    private int postsID;
    private String postsContent;
    private String LatestReplyTime;
    public String getLatestReplyTime(){
        return LatestReplyTime;
    }
    public void setLatestReplyTime(String LatestReplyTime){
        this.LatestReplyTime = LatestReplyTime;
    }
    public String getPostsContent(){
        return postsContent;
    }
    public void setPostsContent(String postsContent){
        this.postsContent = postsContent;
    }
    public int getPostsID(){
        return postsID;
    }
    public void setPostsID(int postsID){
        this.postsID = postsID;
    }
    public String getPublisherID(){
        return publisherID;
    }
    public void setPublisherID(String publisherID){
        this.publisherID = publisherID;
    }
    public int getImageId(){
        return imageId;
    }
    public String getPublisherName(){
        return publisherName;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
    public String getPostTitle(){
        return postTitle;
    }

    public String getPostDate(){

        return postDate;
    }
}
