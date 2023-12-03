package com.cl.flowersStore.controller;

import com.cl.flowersStore.config.Constant;
import com.cl.flowersStore.config.HttpMsg;
import com.cl.flowersStore.dao.LoginDao;
import com.cl.flowersStore.entity.LoginForm;
import com.cl.flowersStore.entity.R;
import com.cl.flowersStore.entity.User;
import com.cl.flowersStore.util.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 **/
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginDao loginDao;

    @RequestMapping("/doLogin")
    R doLogin(@RequestBody LoginForm form) {
        R r = new R();
        if (!VerifyUtil.verifyLoginForm(form)) {
            return r.setCode(4000).setMsg(HttpMsg.ERROR_INPUT);
        }
        User loginUser = loginDao.login(form);
        if (loginUser != null) {
            return r.setCode(2000).setMsg("欢迎您：" + loginUser.getName()).setData(loginUser);
        }
        return r.setCode(4000).setMsg(HttpMsg.ERROR_VERIFY);
    }

    @RequestMapping("/test")
    R test() {
        R r = new R();
        return r.setCode(4000).setMsg(Constant.IMG_PATH);
    }

}
