package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.*;

//@RequestMapping     //스프링은 @Controller 또는 RequestMapping 애노테이션이 있어야 스프링 컨트롤러로 인식
//@ResponseBody
@RestController     //스프링부트 3.0 이상에선 Controller이 있어야 스프링 컨트롤러로 인식
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();

}
