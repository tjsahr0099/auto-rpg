package autorpg.item;

import autorpg.item.data.ItemInfoData;
import autorpg.item.model.ItemInfo;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    public ItemInfo getItem(String id){
        return ItemInfoData.ItemInfoMap.get(id);
    }

}
