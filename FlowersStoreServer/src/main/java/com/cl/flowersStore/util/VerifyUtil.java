package com.cl.flowersStore.util;

import com.cl.flowersStore.entity.LoginForm;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;

public class VerifyUtil {

    private static ArrayList<String> roles = new ArrayList<String>();
    public static boolean verifyLoginForm(LoginForm form) {
        if (form==null || StringUtil.isEmpty(form.getAccount())|| StringUtil.isEmpty(form.getPassword())|| StringUtil.isEmpty(form.getRole())) {
            return false;
        }
        if (form.getRole().equals("user") || form.getRole().equals("admin")){
            return true;
        }
        return false;
    }

}
