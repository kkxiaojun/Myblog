package blog.entity;

import java.sql.Date;

import javax.persistence.*;

/**
 * 文章实体类
 * @author hope
 *
 */
@Entity
@Table(name = "article", schema = "blog", catalog = "")
public class Article {
    private int id;
    private String title;
    private String content;
    private Date pubDate;
    private ArticleType articletype;
//    private Collection<Reply> reply;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 100)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "pub_date", nullable = false)
    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

/*    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }*/
    
    @ManyToOne
    @JoinColumn(name = "articletype_id",referencedColumnName = "id")
	public ArticleType getArticleType() {
		return articletype;
	}

	public void setArticleType(ArticleType articletype) {
		this.articletype = articletype;
	}

//    @OneToMany(mappedBy="article")
//	public Collection<Reply> getReply() {
//		return reply;
//	}
//
//	public void setReply(Collection<Reply> reply) {
//		this.reply = reply;
//	}
	
	
    
}
