package autorpg.monster.data;


import autorpg.item.data.ItemInfoData;
import autorpg.item.model.ItemInfo;
import autorpg.monster.model.DropItem;
import autorpg.monster.model.Monster;

public class MonsterData {

    public static Monster createMonster(){

        DropItem[] dropItems = new DropItem[2];

        dropItems[0] = DropItem.builder().dropPercentage(100)
                .itemId(ItemInfoData.createShoes().getId()).build();

        dropItems[1] = DropItem.builder().dropPercentage(100)
                .itemId(ItemInfoData.createRedPortion().getId()).build();


        return Monster.builder()
                .hp(50)
                .turnCnt(0)
                .level(1)
                .def(10)
                .maxAtk(10)
                .minAtk(1)
                .spd(4)
                .maxHp(50)
                .gainExp(10)
                .dropTable(dropItems)
                .build();

    }

}
