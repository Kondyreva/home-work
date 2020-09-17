package sbp.sbrf.example;

public class TestClassPathXml {

    private String msg = "Hello";

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Test{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
