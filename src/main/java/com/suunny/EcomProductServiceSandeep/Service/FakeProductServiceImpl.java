package com.suunny.EcomProductServiceSandeep.Service;

import com.suunny.EcomProductServiceSandeep.Client.FakeStoreClient;
import com.suunny.EcomProductServiceSandeep.Dto.FakeStoreResponseDto.FakeStoreProductResponseDto;
import com.suunny.EcomProductServiceSandeep.Exception.NoProductFoundException;
import com.suunny.EcomProductServiceSandeep.Exception.ProductNotFoundException;
import com.suunny.EcomProductServiceSandeep.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("FakeProductServiceImpl")
public class FakeProductServiceImpl {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    //@Override
    public List<FakeStoreProductResponseDto> getAllProducts() {
        List<FakeStoreProductResponseDto> fakeStoreProducts
                = fakeStoreClient.getAllProducts();

        if(fakeStoreProducts == null){
            throw new NoProductFoundException("No Products are found in DB!");
        }
        return fakeStoreProducts;
    }

    //@Override
    public FakeStoreProductResponseDto getProduct(int productId) throws ProductNotFoundException{
      FakeStoreProductResponseDto fakeStoreProductResponseDto = fakeStoreClient.getProduct(productId);
      if(fakeStoreProductResponseDto == null){
          throw new ProductNotFoundException("Product id " + productId + " not present in the DB!");
      }
      return fakeStoreProductResponseDto;
    }

    //@Override
    public Product createProduct(Product product) {
        return null;
    }

    //@Override
    public Product updateProduct(Product updatedProduct, int productId) {
        return null;
    }

    //@Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}
