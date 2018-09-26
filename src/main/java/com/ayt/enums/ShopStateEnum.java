package com.ayt.enums;

/**
 * @Auther: ayt
 * @Date: 2018/9/12 23:37
 * @Description: Don't worry ,just try
 */
public enum ShopStateEnum {
    CHECK(0, "审核中"),
    OFFLINE(-1, "非法店铺"),
    SUCCESS(1, "成功"),
    PASS(2, "通过认证"),
    INNER_ERROR(-1001, "系统错误"),
    NULL_SHOPID(-1002,"shopId为空"),
    NULL_SHOP(-1003,"shop为空");

    private int state;
    private String stateInfo;

    /**
     * 构造器设置私有，不希望外部添加，使用枚举创建构造器
     *
     * @param state
     * @param stateInfo
     */
    private ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;

    }

    /**
     * 依据传入的state返回响应的enum值
     */
    public static ShopStateEnum stateOf(int state) {
        for (ShopStateEnum shopStateEnum : values()
                ) {
            if (shopStateEnum.getState() == state) {
                return shopStateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
