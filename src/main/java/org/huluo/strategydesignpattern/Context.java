package org.huluo.strategydesignpattern;

/**
 * 策略模式调用上下文
 */
public class Context {

    /**
     * 策略接口
     */
    Discount discount;

    public Context(Discount discount) {
        this.discount = discount;
    }

    //根据传入的策略对象执行对应的策略
    private void doDiscount() {
        discount.discount();
    }

    public static void main(String[] args) {
        //打五折策略对象
        Discount fiftyPercentDiscount = new FiftyPercentDiscount();
        //打七折策略对象
        Discount seventyPercentDiscount = new SeventyPercentDiscount();

        //新建上下文
        Context context = new Context(fiftyPercentDiscount);
        //根据内在的五折策略对象打折
        context.doDiscount();
        //改为打七折的策略
        context.discount = seventyPercentDiscount;
        context.doDiscount();
    }

}
