package com.ljy.sbtemplate.model.enums;

/**
 * @author Lokiy
 * @date 2019/2/18
 * @description
 */
public enum  SbtEnum {

    /**
     * ljy-app
     */
    LJY_APP("ljy-app","陆璟瑶app"),
    ;

    private String serverId;

    private String serverName;

    public static String val(String serverId){
        for (SbtEnum serverEnum: values()) {
            if(serverId.equals(serverEnum.getServerId())){
                return serverEnum.serverName;
            }
        }
        return null;
    }

    SbtEnum(String serverId, String serverName) {
        this.serverId = serverId;
        this.serverName = serverName;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }
}
