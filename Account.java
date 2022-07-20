class Account{

    double initBal;
    String owner;
    String accNo;
    Account(double initBal,String owner,String number){
        this.initBal=initBal;
        this.owner=owner;
        this.accNo=number;
    }
    Account(double initBal,String owner){
        this.initBal=initBal;
        this.owner=owner;
        
    }
    Account(String owner){
        initBal=0;
        
    }

}
