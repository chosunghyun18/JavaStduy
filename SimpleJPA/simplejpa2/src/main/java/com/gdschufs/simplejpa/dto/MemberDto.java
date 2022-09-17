package com.gdschufs.simplejpa.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MemberDto
{
    @Data
    @AllArgsConstructor
    public static class MemberResultResponse<T>
    {
        private String message;
        private int status;
        private T data;
    }

    @Data  @AllArgsConstructor
    public static class MemberPostResponse
    {
        private String m_name;
        private String m_email;
        private String m_password;
    }

    @Data  @NoArgsConstructor
    public static class MemberPostRequest
    {
        private String m_name;
        private String m_email;
        private String m_password;
    }

}
