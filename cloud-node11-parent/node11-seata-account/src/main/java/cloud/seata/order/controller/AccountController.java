package cloud.seata.order.controller;

import cloud.seata.order.service.AccountService;
import com.seata.feign.AccountFeign;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AccountController implements AccountFeign {

    @Resource
    private AccountService accountService ;

    @Override
    public Integer updateAccount(Long money) {
        return accountService.updateAccount(money);
    }
}
