package Workshop2;

public class FixedDepositAccount extends BankAccount {
    private float interest = 3f;
    private int durationInMonths = 6;
    private int interestChangeCounter = 0;
    private int durationChangeCounter = 0;

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(Integer durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public FixedDepositAccount (String accountName) {
        super(accountName);
    }

    public FixedDepositAccount (String accountName, float accountBalance) {
        super(accountName, accountBalance);
    }

    public FixedDepositAccount (String accountName, float accountBalance, float interest) {
        super(accountName, accountBalance);
        this.interest = interest; 
        this.interestChangeCounter += 1;
    }

    public FixedDepositAccount (String accountName, float accountBalance, float interest, int durationInMonths) {
        super(accountName, accountBalance);
        this.interest = interest;
        this.durationInMonths = durationInMonths; 
        this.interestChangeCounter += 1;
        this.durationChangeCounter += 1;
    }

    @Override
    public float withdraw (float amount) {
        System.out.println("Can't do deposits/withdrawals on FD account, please try again on your bank account.");
        return 0; 
    }

    @Override
    public float deposit (float amount) {
        System.out.println("Can't do deposits/withdrawals on FD account, please try again on your bank account.");
        return 0; 
    }

    @Override 
    public float getAccountBalance() {
        float finalAccountBalance = super.getAccountBalance() * (1 + (interest/100));
        return finalAccountBalance;
    }

    public float updateInterest (float interest) {
        if(interestChangeCounter < 1) {
            this.interest = interest; 
            interestChangeCounter += 1; 
            return interest;
        } else {
            throw new IllegalArgumentException("Interest can only be changed once."); 
        }
    }

    public int updateInterestDuration (int durationInMonths) {
        if(durationChangeCounter < 1) {
            this.durationInMonths = durationInMonths; 
            durationChangeCounter += 1; 
            return durationInMonths; 
        } else {
            throw new IllegalArgumentException("Interest duration can only be changed once."); 
        }
    }
}
