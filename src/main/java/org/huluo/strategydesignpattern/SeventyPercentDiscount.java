package org.huluo.strategydesignpattern;

//打七折策略接口
public class SeventyPercentDiscount implements Discount {

    @Override
    public void discount() {
        System.out.println("打七折");
    }
}
