package com.wave.service;

import com.wave.bean.ProductBean;

import java.util.List;

/**
 * @author tango
 * @create 2018-04-03 下午8:24
 * @desc ${DESCRIPTION}
 **/
public interface IProductService {


    boolean addProduct(ProductBean productBean);

    boolean deleteProductByUserIDandProductID(long userID,long productID);

    boolean updateProduct(ProductBean productBean);

    List<ProductBean> listProductByUserID(long userID);

    ProductBean loadProductById(String  productID);

    ProductBean loadProductByName(String productName);

    List<ProductBean> listProductByCategory(String category);
}
