package mains.other;

public class Result {
    private String msg;
    private Integer code;
    private Object data;

    public static Result ok(Object data) {
        Result r = new Result();
        r.setCode(200);
        r.setMsg("success");
        r.setData(data);
        return r;
    }
    //如果想定義失敗的方法，可以再弄一個fail，或者其他。

    @Override
    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
