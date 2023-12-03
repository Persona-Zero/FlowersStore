package com.cl.flowersStore.dao;

import com.cl.flowersStore.entity.LoginForm;
import com.cl.flowersStore.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {

    @Select("select * from users where account = #{account} and password = #{password} and role = #{role};")
    User login(LoginForm form);

}




