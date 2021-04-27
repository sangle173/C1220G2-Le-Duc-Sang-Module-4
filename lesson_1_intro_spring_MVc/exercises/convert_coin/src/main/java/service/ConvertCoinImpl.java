package service;

public class ConvertCoinImpl implements IConvert {
    @Override
    public Double convertCoin(Double value) {
        return value * 23000;
    }
}
