public class MonsterFactory {
    //Factory Pattern implementation
    public MonsterDragon GetDragon(String data,String monstertype){
        return new MonsterDragon(data,monstertype);
    }

    public MonsterExoskeleton GetExoskeleton(String data,String monstertype){
        return new MonsterExoskeleton(data,monstertype);
    }

    public MonsterSpirit GetSpirit(String data,String monstertype){
        return new MonsterSpirit(data,monstertype);
    }
}
