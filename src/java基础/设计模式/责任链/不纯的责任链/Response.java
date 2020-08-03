package java基础.设计模式.责任链.不纯的责任链;

import java.util.ArrayList;
import java.util.List;

public class Response {

    /**
     * 领导的签名
     */
    private List<String> sign = new ArrayList<String>();

    //***************************************************
    public List<String> getSign() {
        return sign;
    }

    public void setSign(List<String> sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Response{" +
                "sign=" + sign +
                '}';
    }
}
