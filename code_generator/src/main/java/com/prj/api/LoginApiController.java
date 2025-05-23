package com.prj.api;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.prj.common.*;
import com.prj.config.ProjectConfig;
import com.prj.enums.UserStatusEnum;
import com.prj.persistence.entity.User;
import com.prj.persistence.service.UserPersistenceService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping(ProjectConfig.API_PREFIX + "/userAccount")
@Api(tags = "用户登录 API 接口")
public class LoginApiController extends ApiControllerBase {
    private final static Logger logger = LoggerFactory.getLogger(LoginApiController.class);
    @Autowired private TransactionUtil transactionUtil;
    @Autowired private UserPersistenceService userPersistenceService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RestApiResult login(@Valid @RequestBody LoginForm form) {
        List<User> users = userPersistenceService.list(new QueryWrapper<User>().eq(User.LOGIN_NAME, form.getLoginName()).eq(User.PASSWORD, form.getPassword()));
        if(users.size()==0) {
            return RestApiResult.fail(-1, "登录失败！");
        }
        if(UserStatusEnum.已禁用.equals(users.get(0).getStatus())) {return RestApiResult.fail(-1, "账户已被禁用！");}
        CurrentUser currentUser = new CurrentUser(users.get(0).getId(), users.get(0).getRealname(), users.get(0).getRole());
        AppEnv.setCurrentUser(currentUser);
        return new RestApiResult(currentUser.getId());
    }
    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public RestApiResult getCurrentUser() {
        CurrentUser entity = AppEnv.getCurrentUser();
        return new RestApiResult(entity);
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public RestApiResult logout() {
        AppEnv.setCurrentUser(null);
        return new RestApiResult();
    }
}
