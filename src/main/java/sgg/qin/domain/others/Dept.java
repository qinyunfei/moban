package sgg.qin.domain.others;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public class Dept implements Serializable {
	
	
	
    public Dept() {
		super();
	}
    
    

	public Dept(String dname, Date creatdata) {
		super();
		this.dname = dname;
		this.creatdata = creatdata;
	}



	@Id
    private Integer deptno;
    
	//有很多数据验证注解请百度
    @NotNull(message = "用户名不能为空")  
    @Length(min=5, max=20, message="用户名长度必须在5-20之间")  
    @Pattern(regexp = "^[a-zA-Z_]\\w{4,19}$", message = "用户名必须以字母下划线开头，可由字母数字下划线组成")  
    private String dname;
    
    @Past(message="没出生都会上网录信息") //数据验证  日期必须是一个过去的时间
	@DateTimeFormat(pattern="yyyy-MM-dd")//日期格式化(设置页面提交数据的格式) 有很多格式化注解请百度
    @Column(name = "creatData")
    private Date creatdata;

    private static final long serialVersionUID = 1L;

    /**
     * @return deptno
     */
    public Integer getDeptno() {
        return deptno;
    }

    /**
     * @param deptno
     */
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    /**
     * @return dname
     */
    public String getDname() {
        return dname;
    }

    /**
     * @param dname
     */
    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    /**
     * @return creatData
     */
    public Date getCreatdata() {
        return creatdata;
    }

    /**
     * @param creatdata
     */
    public void setCreatdata(Date creatdata) {
        this.creatdata = creatdata;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptno=").append(deptno);
        sb.append(", dname=").append(dname);
        sb.append(", creatdata=").append(creatdata);
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
        Dept other = (Dept) that;
        return (this.getDeptno() == null ? other.getDeptno() == null : this.getDeptno().equals(other.getDeptno()))
            && (this.getDname() == null ? other.getDname() == null : this.getDname().equals(other.getDname()))
            && (this.getCreatdata() == null ? other.getCreatdata() == null : this.getCreatdata().equals(other.getCreatdata()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeptno() == null) ? 0 : getDeptno().hashCode());
        result = prime * result + ((getDname() == null) ? 0 : getDname().hashCode());
        result = prime * result + ((getCreatdata() == null) ? 0 : getCreatdata().hashCode());
        return result;
    }
}