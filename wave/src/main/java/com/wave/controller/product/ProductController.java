package com.wave.controller.product;

import com.wave.bean.ProductBean;
import com.wave.dto.ResponseDTO;
import com.wave.entity.ProductEntity;
import com.wave.service.IProductService;
import com.wave.utils.ObjectUtils;
import com.wave.utils.ResponseCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;

/**
 * @author tango
 * @create 2018-03-30 下午7:51
 * @desc 产品相关的操作
 **/
@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addProduct(ProductBean productBean) {

        if (ObjectUtils.isEmpty(productBean)) {
            return new ResponseDTO(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getMsg(), null);
        }

        boolean ret = iProductService.addProduct(productBean);
        if (ret) {
            return new ResponseDTO(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), null);

        }
        return new ResponseDTO(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMsg(), null);
    }

    @RequestMapping(value = "/product/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteProduct(long userid, long productid) {

        if (userid <= 0 || productid <= 0) {
            return new ResponseDTO(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getMsg(), null);
        }
        boolean ret = iProductService.deleteProductByUserIDandProductID(userid, productid);
        if (ret) {
            return new ResponseDTO(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), null);

        }
        return new ResponseDTO(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMsg(), null);
    }

    @RequestMapping(value = "/product/update", method = RequestMethod.POST)
    @ResponseBody
    public Object updateProduct(ProductBean productBean) {
        if (ObjectUtils.isEmpty(productBean)) {
            return new ResponseDTO(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getMsg(), null);
        }
        boolean ret = iProductService.updateProduct(productBean);

        if (ret) {
            return new ResponseDTO(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), null);

        }
        return new ResponseDTO(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMsg(), null);
    }

    @RequestMapping(value = "/product/search", method = RequestMethod.POST)
    @ResponseBody
    public Object searchProduct() {

        return "";
    }

    @RequestMapping(value = "/product/list/uid", method = RequestMethod.POST)
    @ResponseBody
    public Object listProductByUserID(long userid) {
        if (userid <= 0) {
            return new ResponseDTO(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getMsg(), null);
        }

        Object data = iProductService.listProductByUserID(userid);

        if (ObjectUtils.isEmpty(data)) {
            return new ResponseDTO(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMsg(), null);
        }

        return new ResponseDTO(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);

    }
}
