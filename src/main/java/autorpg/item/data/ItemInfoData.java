package autorpg.item.data;

import autorpg.item.model.Item;
import autorpg.item.model.ItemInfo;
import autorpg.monster.model.DropItem;
import autorpg.monster.model.Monster;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class ItemInfoData {

    public static Map<String,ItemInfo> ItemInfoMap = new HashMap<String,ItemInfo>();

    public static ItemInfo createShoes(){
        ItemInfo itemInfo = ItemInfo.builder().id("A123456")
                .name("슈즈")
                .type("EQUIP")
                .build();
        ItemInfoMap.put("A123456",itemInfo);
        return itemInfo;

    }

    public static ItemInfo createRedPortion(){
        ItemInfo itemInfo = ItemInfo.builder().id("U123456")
                .name("빨간포션")
                .type("USE")
                .build();
        ItemInfoMap.put("U123456",itemInfo);
        return itemInfo;

    }

}
