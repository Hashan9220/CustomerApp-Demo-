package lk.Demo.src.bo;

import lk.Demo.src.bo.custom.impl.CustomerBOimpl;

public class BOFactory {
    static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {

        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;

    }

    public <T extends SuperBO>T getBO(BOType boType) {
        switch (boType) {
            case CUSTOMER:
                return (T) new CustomerBOimpl();
            default:
                return null;
        }
    }

    public enum BOType {
        CUSTOMER
    }
}

