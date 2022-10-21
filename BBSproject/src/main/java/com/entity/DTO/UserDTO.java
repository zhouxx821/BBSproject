package com.entity.DTO;

import java.io.Serializable;
 import java.util.HashMap;

 public class UserDTO implements Serializable {
      /**
        * Property：序列化版本
        */

    private static final long serialVersionUID = 1314L;
     /**
       * Property：用户标识
       */

    private String UserId;
     /**
      * Property：用户姓名
       */

    private String UserName;
     /**
       * Property：用户性别
       */

    private String UserSex;
     /**
       * Property：添加额外属性
       */

    private HashMap<String, Object> extProperties;

             /**
       * Getter Method
       * @return 用户标识
       */


    public String getUserId() {
         return UserId;

    }
     /**
       * Setter Method
       */


    public void setUserId(String userId) {
         UserId = userId;

    }
     /**
       * Getter Method
       * @return 用户姓名
       */


    public String getUserName() {
         return UserName;

    }
     /**
       * Setter Method
       */


    public void setUserName(String userName) {
         UserName = userName;

    }
     /**
       * Setter Method
       */

    public void setUserSex(String userSex) {
         UserSex = userSex;

    }
     /**
      * Getter Method
       * @return 用户性别
       */


    public String getUserSex() {
         return UserSex;

    }
     /**
      * Setter Method
      */


    public void setExtProperties(HashMap<String, Object> extPro) {
         this.extProperties = extPro;

    }
     /**
       * Getter Method
      * @return 额外的属性信息
      */


    public HashMap<String, Object> getExtProperties() {
        return extProperties;

    }
}