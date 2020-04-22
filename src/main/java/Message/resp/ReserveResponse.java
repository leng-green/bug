package Message.resp;

import springfox.documentation.service.ResponseMessage;

public class ReserveResponse<T> {
    private static final int CODE_SUCCESS = 0;

    private static final int CODE_FAIL = 400;

    private static final String MSG_FAIL="failed";

    public ReserveResponse(){
    }
    public ReserveResponse(int status ){
        this.status=status;
    }
    public ReserveResponse(int status,T data ){
        this.status=status;
        this.data=data;
    }
    public ReserveResponse(int status, String message){
        this.status = status;
        this.message = message;
    }
    public ReserveResponse(int status, String message,T data) {
        this.status = status;
        this.message = message;
        this.data=data;
    }
    public static ReserveResponse success(int status,String message){
        return new ReserveResponse(status,message);
    }

    public static ReserveResponse success(int status,String message,Object data){
        return new ReserveResponse(status,message,data);
    }

    public static ReserveResponse fail(){
        return new ReserveResponse(CODE_FAIL, MSG_FAIL);
    }


    private int status;

    private String message;

    public T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
