package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;

public class CatStats extends AbstractStats {

    public int rarity;
    public int max_level;
    public int max_bonus_level;
    public int custom_level;
    public int custom_bonus_level;

    public CatStats(final StatsData data) {
        super(data);
    }
}
