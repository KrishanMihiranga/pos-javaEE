package lk.ijse.posbackend.service;


import lk.ijse.posbackend.service.custom.Impl.CustomerServiceImpl;

public class ServiceFactory{
    private static ServiceFactory serviceFactory;
    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return serviceFactory == null? serviceFactory = new ServiceFactory() : serviceFactory;
    }
    public enum Servicetypes{
        CUSTOMER,
        ITEM
    }
    public SuperService getService (Servicetypes type){
        switch (type){
            case CUSTOMER:return new CustomerServiceImpl();
            default:return null;
        }
    }
}
