package org.huluo.strategydesignpattern;

//打五折策略接口
public class FiftyPercentDiscount implements Discount {

    @Override
    public void discount() {
        System.out.println("打五折");
    }
}
