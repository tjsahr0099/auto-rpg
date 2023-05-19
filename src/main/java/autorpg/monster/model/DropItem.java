package autorpg.monster.model;

import autorpg.item.model.ItemInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DropItem {

    private int dropPercentage;
//    private ItemInfo item;
    private String itemId;

}
