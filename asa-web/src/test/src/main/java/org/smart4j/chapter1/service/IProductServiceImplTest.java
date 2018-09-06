package src.main.java.org.smart4j.chapter1.service;

import org.junit.Test;
import org.smart4j.chapter1.service.ClientThread;
import org.smart4j.chapter1.service.IProductService;
import org.smart4j.chapter1.service.IProductServiceImpl;

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