package cloud.node02.consume.tool;

public class ReturnException {
    // 响应码
    private Integer code;
    // 异常描述
    private String msg;
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}