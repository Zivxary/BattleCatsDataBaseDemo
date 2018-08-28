package zxary.project.com.tw.battlecatsdatabasedemo.UnitAttribute.Stats;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.StatsData;

public class CatStatCollection extends AbstractStatCollection {

    public int rarity;
    public int max_level;
    public int max_bonus_level;
    public int custom_level;
    public int custom_bonus_level;
	
	public CatStatCollection(final StatsData data) {
        super(data);
    }
	
}
