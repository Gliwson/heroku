package heroku.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class ListJsonDTO {

    private List<RowDTO> user = new ArrayList<>();

}
