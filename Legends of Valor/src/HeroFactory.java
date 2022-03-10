public class HeroFactory {
    // Factory Pattern Implementation
    public HeroBaseSorcerers GetSorcerers(String data,String herotype){
        return new HeroBaseSorcerers(data,herotype);
    }

    public HeroBaseWarriors GetWarriors(String data,String herotype){
        return new HeroBaseWarriors(data,herotype);
    }

    public HeroBasePaladins GetPaladins(String data,String herotype){
        return new HeroBasePaladins(data,herotype);
    }
}
