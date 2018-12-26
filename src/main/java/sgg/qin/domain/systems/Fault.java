package sgg.qin.domain.systems;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Fault implements Serializable {
    @Id
    private Integer id;

    /**
     * 问题类型
     */
    @Column(name = "problem_type")
    private Integer problemType;

    /**
     * 问题模块
     */
    @Column(name = "problem_module")
    private Integer problemModule;

    /**
     * 提出人
     */
    @Column(name = "forward_people")
    private String forwardPeople;

    /**
     * 提出单位
     */
    @Column(name = "forward_unit")
    private String forwardUnit;

    /**
     * 紧急程度
     */
    @Column(name = "emergency_degree")
    private Integer emergencyDegree;

    /**
     * 问题来源
     */
    @Column(name = "problem_source")
    private Integer problemSource;

    /**
     * 提出日期
     */
    @Column(name = "proposed_date")
    private Date proposedDate;

    /**
     * 问题描述
     */
    @Column(name = "problem_description")
    private String problemDescription;

    /**
     * 响应时间
     */
    @Column(name = "response_time")
    private Date responseTime;

    /**
     * 计划完成日期
     */
    @Column(name = "scheduled_completion_date")
    private Date scheduledCompletionDate;

    /**
     * 实际完成时间
     */
    @Column(name = "actual_completion")
    private Date actualCompletion;

    /**
     * 问题状态
     */
    @Column(name = "problem_state")
    private Integer problemState;

    /**
     * 负责人
     */
    private String head;

    /**
     * 解决方案
     */
    private String solution;

    /**
     * 新增/重复
     */
    @Column(name = "add_repeat")
    private String addRepeat;

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
     * 获取问题类型
     *
     * @return problem_type - 问题类型
     */
    public Integer getProblemType() {
        return problemType;
    }

    /**
     * 设置问题类型
     *
     * @param problemType 问题类型
     */
    public void setProblemType(Integer problemType) {
        this.problemType = problemType;
    }

    /**
     * 获取问题模块
     *
     * @return problem_module - 问题模块
     */
    public Integer getProblemModule() {
        return problemModule;
    }

    /**
     * 设置问题模块
     *
     * @param problemModule 问题模块
     */
    public void setProblemModule(Integer problemModule) {
        this.problemModule = problemModule;
    }

    /**
     * 获取提出人
     *
     * @return forward_people - 提出人
     */
    public String getForwardPeople() {
        return forwardPeople;
    }

    /**
     * 设置提出人
     *
     * @param forwardPeople 提出人
     */
    public void setForwardPeople(String forwardPeople) {
        this.forwardPeople = forwardPeople == null ? null : forwardPeople.trim();
    }

    /**
     * 获取提出单位
     *
     * @return forward_unit - 提出单位
     */
    public String getForwardUnit() {
        return forwardUnit;
    }

    /**
     * 设置提出单位
     *
     * @param forwardUnit 提出单位
     */
    public void setForwardUnit(String forwardUnit) {
        this.forwardUnit = forwardUnit == null ? null : forwardUnit.trim();
    }

    /**
     * 获取紧急程度
     *
     * @return emergency_degree - 紧急程度
     */
    public Integer getEmergencyDegree() {
        return emergencyDegree;
    }

    /**
     * 设置紧急程度
     *
     * @param emergencyDegree 紧急程度
     */
    public void setEmergencyDegree(Integer emergencyDegree) {
        this.emergencyDegree = emergencyDegree;
    }

    /**
     * 获取问题来源
     *
     * @return problem_source - 问题来源
     */
    public Integer getProblemSource() {
        return problemSource;
    }

    /**
     * 设置问题来源
     *
     * @param problemSource 问题来源
     */
    public void setProblemSource(Integer problemSource) {
        this.problemSource = problemSource;
    }

    /**
     * 获取提出日期
     *
     * @return proposed_date - 提出日期
     */
    public Date getProposedDate() {
        return proposedDate;
    }

    /**
     * 设置提出日期
     *
     * @param proposedDate 提出日期
     */
    public void setProposedDate(Date proposedDate) {
        this.proposedDate = proposedDate;
    }

    /**
     * 获取问题描述
     *
     * @return problem_description - 问题描述
     */
    public String getProblemDescription() {
        return problemDescription;
    }

    /**
     * 设置问题描述
     *
     * @param problemDescription 问题描述
     */
    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription == null ? null : problemDescription.trim();
    }

    /**
     * 获取响应时间
     *
     * @return response_time - 响应时间
     */
    public Date getResponseTime() {
        return responseTime;
    }

    /**
     * 设置响应时间
     *
     * @param responseTime 响应时间
     */
    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * 获取计划完成日期
     *
     * @return scheduled_completion_date - 计划完成日期
     */
    public Date getScheduledCompletionDate() {
        return scheduledCompletionDate;
    }

    /**
     * 设置计划完成日期
     *
     * @param scheduledCompletionDate 计划完成日期
     */
    public void setScheduledCompletionDate(Date scheduledCompletionDate) {
        this.scheduledCompletionDate = scheduledCompletionDate;
    }

    /**
     * 获取实际完成时间
     *
     * @return actual_completion - 实际完成时间
     */
    public Date getActualCompletion() {
        return actualCompletion;
    }

    /**
     * 设置实际完成时间
     *
     * @param actualCompletion 实际完成时间
     */
    public void setActualCompletion(Date actualCompletion) {
        this.actualCompletion = actualCompletion;
    }

    /**
     * 获取问题状态
     *
     * @return problem_state - 问题状态
     */
    public Integer getProblemState() {
        return problemState;
    }

    /**
     * 设置问题状态
     *
     * @param problemState 问题状态
     */
    public void setProblemState(Integer problemState) {
        this.problemState = problemState;
    }

    /**
     * 获取负责人
     *
     * @return head - 负责人
     */
    public String getHead() {
        return head;
    }

    /**
     * 设置负责人
     *
     * @param head 负责人
     */
    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    /**
     * 获取解决方案
     *
     * @return solution - 解决方案
     */
    public String getSolution() {
        return solution;
    }

    /**
     * 设置解决方案
     *
     * @param solution 解决方案
     */
    public void setSolution(String solution) {
        this.solution = solution == null ? null : solution.trim();
    }

    /**
     * 获取新增/重复
     *
     * @return add_repeat - 新增/重复
     */
    public String getAddRepeat() {
        return addRepeat;
    }

    /**
     * 设置新增/重复
     *
     * @param addRepeat 新增/重复
     */
    public void setAddRepeat(String addRepeat) {
        this.addRepeat = addRepeat == null ? null : addRepeat.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", problemType=").append(problemType);
        sb.append(", problemModule=").append(problemModule);
        sb.append(", forwardPeople=").append(forwardPeople);
        sb.append(", forwardUnit=").append(forwardUnit);
        sb.append(", emergencyDegree=").append(emergencyDegree);
        sb.append(", problemSource=").append(problemSource);
        sb.append(", proposedDate=").append(proposedDate);
        sb.append(", problemDescription=").append(problemDescription);
        sb.append(", responseTime=").append(responseTime);
        sb.append(", scheduledCompletionDate=").append(scheduledCompletionDate);
        sb.append(", actualCompletion=").append(actualCompletion);
        sb.append(", problemState=").append(problemState);
        sb.append(", head=").append(head);
        sb.append(", solution=").append(solution);
        sb.append(", addRepeat=").append(addRepeat);
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
        Fault other = (Fault) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProblemType() == null ? other.getProblemType() == null : this.getProblemType().equals(other.getProblemType()))
            && (this.getProblemModule() == null ? other.getProblemModule() == null : this.getProblemModule().equals(other.getProblemModule()))
            && (this.getForwardPeople() == null ? other.getForwardPeople() == null : this.getForwardPeople().equals(other.getForwardPeople()))
            && (this.getForwardUnit() == null ? other.getForwardUnit() == null : this.getForwardUnit().equals(other.getForwardUnit()))
            && (this.getEmergencyDegree() == null ? other.getEmergencyDegree() == null : this.getEmergencyDegree().equals(other.getEmergencyDegree()))
            && (this.getProblemSource() == null ? other.getProblemSource() == null : this.getProblemSource().equals(other.getProblemSource()))
            && (this.getProposedDate() == null ? other.getProposedDate() == null : this.getProposedDate().equals(other.getProposedDate()))
            && (this.getProblemDescription() == null ? other.getProblemDescription() == null : this.getProblemDescription().equals(other.getProblemDescription()))
            && (this.getResponseTime() == null ? other.getResponseTime() == null : this.getResponseTime().equals(other.getResponseTime()))
            && (this.getScheduledCompletionDate() == null ? other.getScheduledCompletionDate() == null : this.getScheduledCompletionDate().equals(other.getScheduledCompletionDate()))
            && (this.getActualCompletion() == null ? other.getActualCompletion() == null : this.getActualCompletion().equals(other.getActualCompletion()))
            && (this.getProblemState() == null ? other.getProblemState() == null : this.getProblemState().equals(other.getProblemState()))
            && (this.getHead() == null ? other.getHead() == null : this.getHead().equals(other.getHead()))
            && (this.getSolution() == null ? other.getSolution() == null : this.getSolution().equals(other.getSolution()))
            && (this.getAddRepeat() == null ? other.getAddRepeat() == null : this.getAddRepeat().equals(other.getAddRepeat()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProblemType() == null) ? 0 : getProblemType().hashCode());
        result = prime * result + ((getProblemModule() == null) ? 0 : getProblemModule().hashCode());
        result = prime * result + ((getForwardPeople() == null) ? 0 : getForwardPeople().hashCode());
        result = prime * result + ((getForwardUnit() == null) ? 0 : getForwardUnit().hashCode());
        result = prime * result + ((getEmergencyDegree() == null) ? 0 : getEmergencyDegree().hashCode());
        result = prime * result + ((getProblemSource() == null) ? 0 : getProblemSource().hashCode());
        result = prime * result + ((getProposedDate() == null) ? 0 : getProposedDate().hashCode());
        result = prime * result + ((getProblemDescription() == null) ? 0 : getProblemDescription().hashCode());
        result = prime * result + ((getResponseTime() == null) ? 0 : getResponseTime().hashCode());
        result = prime * result + ((getScheduledCompletionDate() == null) ? 0 : getScheduledCompletionDate().hashCode());
        result = prime * result + ((getActualCompletion() == null) ? 0 : getActualCompletion().hashCode());
        result = prime * result + ((getProblemState() == null) ? 0 : getProblemState().hashCode());
        result = prime * result + ((getHead() == null) ? 0 : getHead().hashCode());
        result = prime * result + ((getSolution() == null) ? 0 : getSolution().hashCode());
        result = prime * result + ((getAddRepeat() == null) ? 0 : getAddRepeat().hashCode());
        return result;
    }
}