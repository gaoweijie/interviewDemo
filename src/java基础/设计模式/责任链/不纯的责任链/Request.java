package java基础.设计模式.责任链.不纯的责任链;

import java.util.ArrayList;
import java.util.List;

public class Request {

    /**
     * 申请人姓名
     */
    private String name;

    /**
     * 申请报销金额
     */
    private Long gold;

    /**
     * 审批意见
     */
    private List<String> opinions = new ArrayList<String>();


    //*********************************************************
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    public List<String> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<String> opinions) {
        this.opinions = opinions;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", gold=" + gold +
                ", opinions=" + opinions +
                '}';
    }
}
