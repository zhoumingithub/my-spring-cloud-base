package cloud.block.code.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "NODE02-PROVIDER",fallback = FallbackService.class)
public interface GetAuthorService {

    @RequestMapping(value = "/getAuthorInfo/{authorId}",method = RequestMethod.GET)
    String getAuthorInfo (@PathVariable("authorId") String authorId) ;

}
