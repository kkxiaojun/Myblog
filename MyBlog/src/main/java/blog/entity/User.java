package blog.entity;

import javax.persistence.*;

/**
 * User类
 * author hope
 */
@Entity
@Table(name = "user", schema = "blog", catalog = "")
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String qq;
    private String info;
//    private Collection<Article> articleById;

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
    @Column(name = "username", nullable = false, unique = true, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
    
/*    @OneToMany(mappedBy = "userByUserId")
	public Collection<Article> getArticleById() {
		return articleById;
	}

	public void setArticleById(Collection<Article> articleById) {
		this.articleById = articleById;
	}*/
}
