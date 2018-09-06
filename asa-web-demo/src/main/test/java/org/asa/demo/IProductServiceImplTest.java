package java.org.asa.demo;

import org.asa.demo.service.ClientThread;
import org.asa.demo.service.IProductService;
import org.asa.demo.service.IProductServiceImpl;
import org.junit.Test;

public class IProductServiceImplTest {
    private IProductService iProductService;

    {
        iProductService = new IProductServiceImpl();
    }

    @Test
    public void updatePriceSingleThreadTest() {
        iProductService.updateProductPrice(1L, 350);
    }

    @Test
    public void updatePriceMultiThreadTest() {
        for (int i = 0; i < 1; i++) {
            IProductServiceImpl iProductService = new IProductServiceImpl();
            ClientThread thread = new ClientThread(iProductService);
            thread.start();
        }
    }
}