package autorpg.user.model;

import autorpg.character.model.Character;
import lombok.Data;

@Data
public class User {

    private String userId;
    private Character[] characters;
    private Character loginedCharacter;


}
