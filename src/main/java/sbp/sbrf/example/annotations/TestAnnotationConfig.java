package sbp.sbrf.example.annotations;

import org.springframework.stereotype.Component;

@Component("test")
public class TestAnnotationConfig {

    private String msg = "Hello2";

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
