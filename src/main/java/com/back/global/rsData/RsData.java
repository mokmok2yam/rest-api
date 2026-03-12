package com.back.global.rsData;

public record RsData<T> (
        String msg,
        String resultCode,
        T data
)
{
    public RsData(String msg, String resultCode){
        this(msg,resultCode,null);
    }
  //  @JsonIgnore
    public int getStatusCode(){
        return Integer.parseInt(this.resultCode.split("-")[0]);
    }
}
