package com.yang.bean;

/**
 * @ProjectName: com.yang.bean
 * @author: ZhangBiBo
 * @description: 测试resultMap的实体类
 * @data: 2021/12/24
 */
public class UserVo {
    private Integer idVO;
    private String usernameVO;
    private String passwordVO;
    private String emailVO;

    @Override
    public String toString() {
        return "UserVo{" +
                "idVO=" + idVO +
                ", usernameVO='" + usernameVO + '\'' +
                ", passwordVO='" + passwordVO + '\'' +
                ", emailVO='" + emailVO + '\'' +
                '}';
    }

    public Integer getIdVO() {
        return idVO;
    }

    public void setIdVO(Integer idVO) {
        this.idVO = idVO;
    }

    public String getUsernameVO() {
        return usernameVO;
    }

    public void setUsernameVO(String usernameVO) {
        this.usernameVO = usernameVO;
    }

    public String getPasswordVO() {
        return passwordVO;
    }

    public void setPasswordVO(String passwordVO) {
        this.passwordVO = passwordVO;
    }

    public String getEmailVO() {
        return emailVO;
    }

    public void setEmailVO(String emailVO) {
        this.emailVO = emailVO;
    }

    public UserVo() {
    }

    public UserVo(Integer idVO, String usernameVO, String passwordVO, String emailVO) {
        this.idVO = idVO;
        this.usernameVO = usernameVO;
        this.passwordVO = passwordVO;
        this.emailVO = emailVO;
    }
}
