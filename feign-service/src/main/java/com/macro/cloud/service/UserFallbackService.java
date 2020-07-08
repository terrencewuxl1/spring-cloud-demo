package com.macro.cloud.service;

import com.macro.cloud.domain.CommonResult;
import com.macro.cloud.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackService implements UserService {
    @Override
    public CommonResult create(User user) {
        return getDefaultCommonResult();
    }

    private CommonResult getDefaultCommonResult() {
        User defaultUser=new User(-1L,"defaultUser","111111");
        return new CommonResult(defaultUser);
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        return getDefaultCommonResult();
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        return getDefaultCommonResult();
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult("invoke fail, service is fallback.",500);
    }

    @Override
    public CommonResult delete(Long id) {
        return new CommonResult("invoke fail, service is fallback.",500);
    }
}
