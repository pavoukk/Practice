package com.sevenbits.roguelike.coins;

public class SilverCoin implements ICoin {
    private final int id = 7;
    private final int value = 10;
    private int useAmount = 1;
    private boolean useable = true;

    public SilverCoin(){
//        setUseAmount(useAmount);
//        setUseable(useable);
    }

    private void setUseAmount(int useAmount) {
        this.useAmount = useAmount;
    }

    private void setUseable(boolean useable) {
        this.useable = useable;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getUseAmount() {
        return useAmount;
    }

    @Override
    public boolean use() {
        if(useAmount > 0){
            useAmount-=1;
            useable = true;
        }
        return useable;
    }

    @Override
    public boolean isUseable() {
        return useable;
    }
}
