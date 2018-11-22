package com.sevenbits.roguelike.coins;

public class GoldCoin implements ICoin {
    private final int id = 6;
    private final int value = 100;
    private  int useAmount = 1;
    private boolean useable = true;
    public GoldCoin() {
//        setUseAmount(1);
//        setUseable(true);
    }

    private void setUseAmount(int useAmount) {
        this.useAmount = useAmount;
    }

    private void setUseable(boolean useable) {
        this.useable = useable;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getValue() {
        return value;
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

    @Override
    public String toString() {
        return "GoldCoin{" +
                "id=" + id +
                ", value=" + value +
                ", useAmount=" + useAmount +
                ", useable=" + useable +
                '}';
    }
}
