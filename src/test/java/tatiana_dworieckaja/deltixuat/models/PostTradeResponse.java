package tatiana_dworieckaja.deltixuat.models;

import lombok.Data;

import java.util.List;

@Data
public class PostTradeResponse {
    List<Item> items;
    Boolean hasMore;
}
