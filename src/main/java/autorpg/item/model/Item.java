package autorpg.item.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {

    private String instId;
    private ItemInfo info;

}
