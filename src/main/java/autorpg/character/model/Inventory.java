package autorpg.character.model;

import lombok.Data;

import java.util.List;

@Data
public class Inventory {

    private List<Inventory> items;

}
