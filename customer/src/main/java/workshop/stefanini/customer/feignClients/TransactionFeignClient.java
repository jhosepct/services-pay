package workshop.stefanini.customer.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import workshop.stefanini.customer.config.FeignClientConfig;
import workshop.stefanini.customer.dto.TransactionDTO;

@FeignClient(name = "transaction-service", url = "${external.api.transaction.base-url}", configuration = FeignClientConfig.class)
public interface TransactionFeignClient {

    @PostMapping()
    TransactionDTO saveTransaction(@RequestBody TransactionDTO transaction);
}
