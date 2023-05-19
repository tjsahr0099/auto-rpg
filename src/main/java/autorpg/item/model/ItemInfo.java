package autorpg.item.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ItemInfo {

    private String id;
    private String name;
    private String type;


}
