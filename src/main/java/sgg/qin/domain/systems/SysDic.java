package sgg.qin.domain.systems;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_dic")
public class SysDic implements Serializable {
    @Id
    private Integer id;

    /**
     * 分类id
     */
    private Integer tid;

    /**
     * 名字
     */
    private String text;

    /**
     * 1是分类 2是明细
     */
    private Integer type;

    /**
     * 父id
     */
    private Integer pid;

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
     * 获取分类id
     *
     * @return tid - 分类id
     */
    public Integer getTid() {
        return tid;
    }

    /**
     * 设置分类id
     *
     * @param tid 分类id
     */
    public void setTid(Integer tid) {
        this.tid = tid;
    }

    /**
     * 获取名字
     *
     * @return text - 名字
     */
    public String getText() {
        return text;
    }

    /**
     * 设置名字
     *
     * @param text 名字
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * 获取1是分类 2是明细
     *
     * @return type - 1是分类 2是明细
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1是分类 2是明细
     *
     * @param type 1是分类 2是明细
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取父id
     *
     * @return pid - 父id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父id
     *
     * @param pid 父id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tid=").append(tid);
        sb.append(", text=").append(text);
        sb.append(", type=").append(type);
        sb.append(", pid=").append(pid);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysDic other = (SysDic) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTid() == null ? other.getTid() == null : this.getTid().equals(other.getTid()))
            && (this.getText() == null ? other.getText() == null : this.getText().equals(other.getText()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTid() == null) ? 0 : getTid().hashCode());
        result = prime * result + ((getText() == null) ? 0 : getText().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        return result;
    }
}