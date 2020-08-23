package com.csbd.CSBD100.v.model.enums.type;

import com.csbd.CSBD100.v.model.enums.categorie.Tax;

public enum TransactionType {

    BUY {
        @Override
        public double doTransactionOperation(Double price) {
           return Tax.BUY.calculateTax(price);
        }
    },

    SELL {
        @Override
        public double doTransactionOperation(Double price) {
            return Tax.SELL.calculateTax(price);
        }
    },

    CREDIT {
        @Override
        public double doTransactionOperation(Double price) {
            return Tax.CREDIT.calculateTax(price);
        }
    },

    NO_PROFIT {
        @Override
        public double doTransactionOperation(Double price) {
            return Tax.NONE.calculateTax(price);
        }
    };

    public abstract double doTransactionOperation(Double price);

}
