package entity.commons;

public enum ProductStatus {

    /**
        Active - product is active
        Pending - product is added to db, but is not currently in sale
        Historical - product is no more available
     */

    ACTIVE,
    PENDING,
    HISTORICAL,
    UNDEFINED;

}