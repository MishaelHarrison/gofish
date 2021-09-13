package com.goFish.fishing.Model;

import com.goFish.fishing.Model.Enum.Card;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pair {
    public Card L;
    public Card R;
}
