package lk.Demo.src.dao;

import lk.Demo.src.dao.custom.impl.CustomerDAOimpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        if (daoFactory==null){
            daoFactory=new DAOFactory();

        }
        return daoFactory;
    }
    public enum DAOType{
        CUSTOMER;
    }
    public SuperDAO getDAO (DAOFactory.DAOType type){

        switch (type){
            case CUSTOMER:return new CustomerDAOimpl();

            default:return null;
        }



    }
}
