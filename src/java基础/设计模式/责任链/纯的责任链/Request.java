package java基础.设计模式.责任链.纯的责任链;

public class Request {

    /**
     * 请假人姓名
     */
    private String name;

    /**
     * 请假天数
     */
    private Integer days;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}