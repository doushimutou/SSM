package com.ayt.enums;

/**
 * 商品种类状态枚举
 * @Author: ayt
 * @Date: 2018/9/23 22:08
 * @Description: Don't worry ,just try
 */
public enum  ProductCategoryStateEnum {
    SUCCESS(1,"成功"),
    NULL_PRODUCTCATEGORY(-1001,"商品种类为空"), FAILED(0,"失败" );


    //状态
    private int state;
    //状态信息
    private String stateInfo;

    private ProductCategoryStateEnum(int state, String stateInfo ) {
        this.state=state;
        this.stateInfo=stateInfo;
    }
    public int getState() {
        return state;
    }
    public String getStateInfo() {
        return stateInfo;
    }

    /**
     * 依据传入的state返回响应的enum值
     */
    public static ProductCategoryStateEnum stateOf(int state) {
        for (ProductCategoryStateEnum productCategoryStateEnum : values()
                ) {
            if (productCategoryStateEnum.getState() == state) {
                return productCategoryStateEnum;
            }
        }
        return null;
    }
}
