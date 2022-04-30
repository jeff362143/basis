package com.pojo;

public class Inform {

        private int id;
        private String owner;
        private String content;
        private int blogid;
        private String sender;
        private int flag;
        private String blogtitle;

        public Inform() {
        }

        public Inform(int id, String owner, String content, int blogid, String sender, int flag,String blogtitle) {
            this.id = id;
            this.owner = owner;
            this.content = content;
            this.blogid = blogid;
            this.sender = sender;
            this.flag = flag;
            this.blogtitle = blogtitle;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getBlogid() {
            return blogid;
        }

        public void setBlogid(int blogid) {
            this.blogid = blogid;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

    public String getBlogtitle() {
        return blogtitle;
    }

    public void setBlogtitle(String blogtitle) {
        this.blogtitle = blogtitle;
    }

    @Override
    public String toString() {
        return "Inform{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", content='" + content + '\'' +
                ", blogid=" + blogid +
                ", sender='" + sender + '\'' +
                ", flag=" + flag +
                ", blogtitle='" + blogtitle + '\'' +
                '}';
    }
}
