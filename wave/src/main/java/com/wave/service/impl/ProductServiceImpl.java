package com.wave.service.impl;

import com.wave.bean.ProductBean;
import com.wave.entity.ProductEntity;
import com.wave.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tango
 * @create 2018-04-03 下午8:28
 * @desc ${DESCRIPTION}
 **/
@Service
public class ProductServiceImpl implements IProductService {

    public boolean addProduct(ProductBean productBean) {

        ProductEntity productEntity = new ProductEntity();

        BeanUtils.copyProperties(productBean,productEntity);
        //2.填充productID

        //3.填充添加时间





        return false;
    }

    public ProductBean loadProductById(String productID) {
        return null;
    }

    public ProductBean loadProductByName(String productName) {
        return null;
    }

    public List<ProductBean> listProductByCategory(String category) {
        return null;
    }

    public boolean deleteProductByUserIDandProductID(long userID, long productID) {
        return false;
    }

    public boolean updateProduct(ProductBean productBean) {
        return false;
    }

    public List<ProductBean> listProductByUserID(long userID) {
        return null;
    }
}
