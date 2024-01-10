package lk.ijse.posbackend.bo;

import lk.ijse.posbackend.bo.custom.impl.CustomerBoImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        return boFactory== null? boFactory= new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,
        ITEM
    }

    public SuperBO getBo(BOTypes type){
        switch (type){
            case CUSTOMER: return new CustomerBoImpl();
            default:return null;
        }
    }
}