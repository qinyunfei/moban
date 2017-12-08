package sgg.qin.domain.systems;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Table(name = "sys_resource")
public class SysResource implements Serializable {
    @Id
    private Integer id;

    private String name;

    private String type;

    private String url;

    private Integer pid;

    private String permission;

    private Boolean available;

    private String icon;
    
    
    @Transient
    private List<SysResource> children;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

  

    /**
     * @return permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * @return available
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * @param available
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public List<SysResource> getChildren() {
		return children;
	}

	public void setChildren(List<SysResource> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "SysResource [id=" + id + ", name=" + name + ", type=" + type + ", url=" + url + ", pid=" + pid
				+ ", permission=" + permission + ", available=" + available + ", icon=" + icon + ", children="
				+ children + "]";
	}
    
    

  
}