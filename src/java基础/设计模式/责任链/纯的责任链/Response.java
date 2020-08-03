package java基础.设计模式.责任链.纯的责任链;

public class Response {

    /**
     * 审批人姓名
     */
    private String approvalName;

    /**
     * 审批结果
     */
    private boolean result;

    /**
     * 审批消息
     */
    private String msg;

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "approvalName='" + approvalName + '\'' +
                ", result=" + result +
                ", msg='" + msg + '\'' +
                '}';
    }
}